/*==============================================================================
 = Class: CarmotToolEffect
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2021.
 =============================================================================*/

package it.hurts.metallurgy_reforged.effect.tool;

import it.hurts.metallurgy_reforged.capabilities.effect.BlockInfoDataBundle;
import it.hurts.metallurgy_reforged.capabilities.effect.EffectDataProvider;
import it.hurts.metallurgy_reforged.effect.BaseMetallurgyEffect;
import it.hurts.metallurgy_reforged.effect.EnumEffectCategory;
import it.hurts.metallurgy_reforged.effect.IProgressiveEffect;
import it.hurts.metallurgy_reforged.material.ModMetals;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

public class CarmotToolEffect extends BaseMetallurgyEffect implements IProgressiveEffect {

    public CarmotToolEffect()
    {
        super(ModMetals.CARMOT);
    }

    @Nonnull
    @Override
    public EnumEffectCategory getCategory()
    {
        return EnumEffectCategory.TOOL;
    }

    @SubscribeEvent
    public void harvestBlocks(BlockEvent.BreakEvent event)
    {
        if (!canBeApplied(event.getPlayer()))
            return;

        if (!event.getWorld().isRemote)
        {
            if (!event.getState().getBlock().canHarvestBlock(event.getWorld(), event.getPos(), event.getPlayer()))
                return;

            Item tool = event.getPlayer().getHeldItemMainhand().getItem();
            String blockToolClass = event.getState().getBlock().getHarvestTool(event.getState());
            if (blockToolClass == null || tool.getRegistryName().getPath().contains(blockToolClass))
            {
                //check passed because axe is contained in pickaxe
                if (blockToolClass != null && blockToolClass.equals("axe") && tool.getRegistryName().getPath().contains("pickaxe"))
                    return;

                EntityPlayer player = event.getPlayer();

                BlockInfoDataBundle effectBundle = player.getCapability(EffectDataProvider.PLAYER_EFFECT_DATA_CAPABILITY, null).carmotToolBundle;
                if (effectBundle.isEffectInProgress())
                    return;

                //Initializes the progressive effect
                effectBundle.setPos(event.getPos());
                effectBundle.setState(event.getState());
                effectBundle.incrementStep(event.getPlayer());
            }
        }
    }

    @Override
    public void onStep(World world, EntityPlayer player, int maxSteps, int step)
    {
        BlockInfoDataBundle blockBundle = player.getCapability(EffectDataProvider.PLAYER_EFFECT_DATA_CAPABILITY, null).carmotToolBundle;

        BlockPos pos = blockBundle.getPos();
        IBlockState state = blockBundle.getState();

        if (pos == null || state == null)
            return;

        if (!world.isRemote)
        {
            for (int x = -step - 1; x < step + 1; x++)
            {
                for (int y = -step - 1; y < step + 1; y++)
                {
                    for (int z = -step - 1; z < step + 1; z++)
                    {
                        BlockPos blockPos = pos.add(x, y, z);
                        IBlockState blockState = world.getBlockState(blockPos);

                        if (Math.ceil(blockPos.getDistance(pos.getX(), pos.getY(), pos.getZ())) == step)
                        {
                            if (Block.isEqualTo(blockState.getBlock(), state.getBlock()))
                                world.destroyBlock(blockPos, true);
                        }
                    }
                }
            }

            float pitch = ((8 - step) / 6F);
            world.playSound(null, pos, SoundEvents.ENTITY_BLAZE_HURT, SoundCategory.BLOCKS, 1.5F, pitch);
        }
    }

    @Deprecated
    private Vec3i roundVector(Vec3d vector)
    {

        double absX = Math.abs(vector.x);
        double absY = Math.abs(vector.y);
        double absZ = Math.abs(vector.z);

        if (absX > 0.75)
            return new Vec3i(Math.signum(vector.x), 0, 0);
        else if (absY > 0.75)
            return new Vec3i(0, Math.signum(vector.y), 0);
        else if (absZ > 0.75)
            return new Vec3i(0, 0, Math.signum(vector.z));
        else
        {
            if (absX + absY > 0.75)
                return new Vec3i(Math.signum(vector.x), Math.signum(vector.y), 0);
            else if (absX + absZ > 0.75)
                return new Vec3i(Math.signum(vector.x), 0, Math.signum(vector.z));
            else if (absY + absZ > 0.75)
                return new Vec3i(0, Math.signum(vector.y), Math.signum(vector.z));

            else
            {
                return new Vec3i(Math.signum(vector.x), Math.signum(vector.y), Math.signum(vector.z));
            }
        }
    }
}
