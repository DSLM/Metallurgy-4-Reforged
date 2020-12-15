/*==============================================================================
 = Class: AdamantineArmorEffect
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2020.
 =============================================================================*/

package it.hurts.metallurgy_reforged.effect.armor;

import it.hurts.metallurgy_reforged.effect.BaseMetallurgyEffect;
import it.hurts.metallurgy_reforged.effect.EnumEffectCategory;
import it.hurts.metallurgy_reforged.handler.LivingEventHandler;
import it.hurts.metallurgy_reforged.material.ModMetals;
import it.hurts.metallurgy_reforged.network.PacketManager;
import it.hurts.metallurgy_reforged.network.client.PacketRenderDeathProtection;
import it.hurts.metallurgy_reforged.util.ItemUtils;
import it.hurts.metallurgy_reforged.util.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class AdamantineArmorEffect extends BaseMetallurgyEffect {

    private final LivingEventHandler<LivingDeathEvent> ENTITY_HURTS = new LivingEventHandler<>(this::onEntityDeath, LivingDeathEvent.class);

    public AdamantineArmorEffect() {
        super(ModMetals.ADAMANTINE);
    }

    @Override
    public EnumEffectCategory getCategory() {
        return EnumEffectCategory.ARMOR;
    }

    @Override
    public LivingEventHandler<? extends LivingEvent>[] getEvents() {
        return new LivingEventHandler[]{ENTITY_HURTS};
    }

    /**
     * If the player has Adamantine armor they have a chance to survive death with an armor piece sacrificing itself
     *
     * @param event Fired when the player is about to die
     */
    public void onEntityDeath(LivingDeathEvent event) {
        EntityLivingBase entity = event.getEntityLiving();

        if (!entity.world.isRemote && entity instanceof EntityPlayerMP) {
            //Get a random slot from the Armor slots (the "2 +" skips main hand and off hand slots)
            EntityEquipmentSlot randomArmorSlot = EntityEquipmentSlot.values()[2 + Utils.random.nextInt(4)];

            ItemStack armorPiece = entity.getItemStackFromSlot(randomArmorSlot);
            //Check whether the itemStack inside the random slot is an Adamantine armor piece
            if (ItemUtils.isMadeOfMetal(metal, armorPiece.getItem())) {
                //Remove armor piece from the slot
                entity.setItemStackToSlot(randomArmorSlot, ItemStack.EMPTY);
                //Play Totem of Undying sound
                entity.world.playSound(null, entity.getPosition(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 1, 1);

                //Set the player health to half a heart
                // (if this line is removed the player dies even when cancelling the death event because they have 0 health)
                entity.setHealth(1F);
                //Cancel Player Death
                event.setCanceled(true);

                //Send a packet to emit particles and render the Totem item overlay
                PacketRenderDeathProtection packet = new PacketRenderDeathProtection(entity, armorPiece);
                //This criteria needs to be triggered in order to the totem overlay to work
                CriteriaTriggers.USED_TOTEM.trigger(((EntityPlayerMP) entity), armorPiece);

                //Send two packets to the client (one to self and many to the other players that are watching the entity)
                PacketManager.network.sendTo(packet, ((EntityPlayerMP) entity));
                PacketManager.network.sendToAllTracking(packet, entity);
            }
        }

        //Give absorption and regeneration III to the player so that they don't die instantly after being revived
        entity.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20 * 25, 2));
        entity.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 60, 1));
    }
}
