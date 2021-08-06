/*==============================================================================
 = Class: QuicksilverWeaponEffect
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2021.
 =============================================================================*/

package it.hurts.metallurgy_reforged.effect.weapon;

import it.hurts.metallurgy_reforged.capabilities.effect.ProgressiveDataBundle;
import it.hurts.metallurgy_reforged.effect.BaseMetallurgyEffect;
import it.hurts.metallurgy_reforged.effect.EnumEffectCategory;
import it.hurts.metallurgy_reforged.effect.IProgressiveEffect;
import it.hurts.metallurgy_reforged.material.ModMetals;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

public class QuicksilverWeaponEffect extends BaseMetallurgyEffect implements IProgressiveEffect {

	public QuicksilverWeaponEffect()
	{
		super(ModMetals.QUICKSILVER);
	}

	@Nonnull
	@Override
	public EnumEffectCategory getCategory()
	{
		return EnumEffectCategory.WEAPON;
	}

	@SubscribeEvent
	public void swiftStrike(LivingDamageEvent event)
	{
		if (event.isCanceled())
			return;

		if (event.getSource().getImmediateSource() instanceof EntityPlayer)
		{
			EntityPlayer attacker = (EntityPlayer) event.getSource().getImmediateSource();
			if (!canBeApplied(attacker))
				return;

			ProgressiveDataBundle bundle = getBundle(attacker, metal, getCategory());
			if (!bundle.isEffectInProgress())
				bundle.incrementStep(attacker);
		}
	}

	@Override
	public void onStep(World world, EntityPlayer entity, ItemStack effectStack, int maxSteps, int step)
	{
		if (step == 1)
		{
			EntityLivingBase lastAttackedEntity = entity.getLastAttackedEntity();

			if (lastAttackedEntity != null)
			{
				//Dash through the enemy
				Vec3d playerToEnemy = entity.getPositionVector().subtractReverse(lastAttackedEntity.getPositionVector()).scale(1.5);
				entity.motionX = playerToEnemy.x;
				entity.motionY = playerToEnemy.y * 0.25;
				entity.motionZ = playerToEnemy.z;
				entity.velocityChanged = true;


				//Remove enemy invulnerability from normal attack
				lastAttackedEntity.hurtResistantTime = 0;
				//Dash attack damage
				lastAttackedEntity.attackEntityFrom(DamageSource.causePlayerDamage(entity), 4F);

				//Make Player invulnerable for a bit
				entity.hurtResistantTime = entity.maxHurtResistantTime;

				for (int i = 0; i < 10; i++)
					spawnParticle(lastAttackedEntity, 2F, true, 5);
			}
		}
	}

}
