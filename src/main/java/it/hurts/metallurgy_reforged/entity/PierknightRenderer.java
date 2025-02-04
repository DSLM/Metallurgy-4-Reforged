/*==============================================================================
 = Class: PierknightRenderer
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2021.
 =============================================================================*/

package it.hurts.metallurgy_reforged.entity;

import it.hurts.metallurgy_reforged.Metallurgy;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PierknightRenderer extends RenderLiving<EntityPierKnight> {

	private static final ResourceLocation PIERKNIGHT_SKIN = new ResourceLocation(Metallurgy.MODID, "textures/models/pierknight_skin.png");

	public PierknightRenderer(RenderManager renderManager)
	{
		super(renderManager, new ModelPlayer(0, false), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerArrow(this));
	}

	@Override
	public void doRender(@Nonnull EntityPierKnight entity, double x, double y, double z, float entityYaw, float partialTicks)
	{

		float time = entity.deathTime > 0 ? entity.deathTime : entity.vanishTime;

		float alpha = 1F - (partialTicks + time) / 40.0F;
		if (alpha > 1.0F)
			alpha = 1.0F;

		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		GlStateManager.alphaFunc(516, 0.003921569F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);


		super.doRender(entity, x, y, z, entityYaw, partialTicks);

		GlStateManager.disableBlend();
		GlStateManager.alphaFunc(516, 0.1F);
	}

	@Override
	protected boolean setBrightness(@Nonnull EntityPierKnight entitylivingbaseIn, float partialTicks, boolean combineTextures)
	{
		return entitylivingbaseIn.deathTime <= 0 && super.setBrightness(entitylivingbaseIn, partialTicks, combineTextures);
	}

	@Override
	protected float getDeathMaxRotation(@Nonnull EntityPierKnight entityLivingBaseIn)
	{
		return 0F;
	}

	@Override
	protected void preRenderCallback(@Nonnull EntityPierKnight entitylivingbaseIn, float partialTickTime)
	{
		if (entitylivingbaseIn.getDataManager().get(EntityPierKnight.IS_PUTIN))
			GlStateManager.scale(3, 1, 1);

		super.preRenderCallback(entitylivingbaseIn, partialTickTime);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(@Nonnull EntityPierKnight entity)
	{
		return PIERKNIGHT_SKIN;
	}

	public static class Factory implements IRenderFactory<EntityPierKnight> {

		@Override
		public Render<? super EntityPierKnight> createRenderFor(RenderManager manager)
		{
			return new PierknightRenderer(manager);
		}

	}

}
