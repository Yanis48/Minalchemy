package com.yanis48.minalchemy.container;

import com.mojang.blaze3d.platform.GlStateManager;
import com.yanis48.minalchemy.Minalchemy;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractContainerScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AlchemyTableScreen extends AbstractContainerScreen<AlchemyTableContainer> {
	private static final Identifier TEXTURE = new Identifier(Minalchemy.MOD_ID, "textures/gui/alchemy_table.png");

	public AlchemyTableScreen(AlchemyTableContainer container, int syncId, PlayerEntity player) {
		super(container, player.inventory, new TranslatableText("container.minalchemy.alchemy_table", new Object[0]));
	}
	
	@Override
	protected void drawForeground(int int_1, int int_2) {
		this.font.draw(this.title.asFormattedString(), 8.0F, 6.0F, 4210752);
		this.font.draw(this.playerInventory.getDisplayName().asFormattedString(), 8.0F, (float)(this.containerHeight - 96 + 2), 4210752);
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		this.drawBackground(partialTicks, mouseX, mouseY);
		super.render(mouseX, mouseY, partialTicks);
		this.drawMouseoverTooltip(mouseX, mouseY);
	}
	
	@Override
	protected void drawBackground(float float_1, int int_1, int int_2) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int int_3 = (this.width - this.containerWidth) / 2;
		int int_4 = (this.height - this.containerHeight) / 2;
		this.blit(int_3, int_4, 0, 0, this.containerWidth, this.containerHeight);
	}
}
