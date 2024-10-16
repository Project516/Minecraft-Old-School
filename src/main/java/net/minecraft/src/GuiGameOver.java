package net.minecraft.src;

import net.lax1dude.eaglercraft.EaglerAdapter;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class GuiGameOver extends GuiScreen {

	public GuiGameOver() {
	}

	public void initGui() {
		controlList.clear();
		controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 72, "Respawn"));
		controlList.add(new GuiButton(2, width / 2 - 100, height / 4 + 96, "Title menu"));
		controlList.add(new GuiButton(3, width / 2 - 100, height / 4 + 96, "Options"));
		if (mc.session == null) {
			((GuiButton) controlList.get(1)).enabled = false;
		}
	}

	protected void keyTyped(char c, int i) {
	}

	protected void actionPerformed(GuiButton guibutton) {
		if (guibutton.id != 0)
			;
		if (guibutton.id == 1) {
			mc.thePlayer.respawnPlayer();
			mc.displayGuiScreen(null);
		}
		if (guibutton.id == 2) {
			mc.changeWorld1(null);
			mc.displayGuiScreen(new GuiMainMenu());
		}
		if (guibutton.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
	}

	public void drawScreen(int i, int j, float f) {
		drawGradientRect(0, 0, width, height, 0x60500000, 0xa0803030);
		EaglerAdapter.glPushMatrix();
		EaglerAdapter.glScalef(2.0F, 2.0F, 2.0F);
		drawCenteredString(fontRenderer, "Game over!", width / 2 / 2, 30, 0xffffff);
		EaglerAdapter.glPopMatrix();
		drawCenteredString(fontRenderer,
				(new StringBuilder()).append("Score: ").append(mc.thePlayer.getScore()).toString(), width / 2, 100,
				0xffffff);
		super.drawScreen(i, j, f);
	}

	public boolean doesGuiPauseGame() {
		return false;
	}
}
