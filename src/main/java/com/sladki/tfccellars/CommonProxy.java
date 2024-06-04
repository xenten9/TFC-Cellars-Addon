package com.sladki.tfccellars;

import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {

    public void registerGuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Cellars.instance, new com.sladki.tfccellars.Gui.GuiHandler());
    }

    public void registerRenderInformation() {}

    public boolean isRemote() {
        return false;
    }

    public void hideItemsNEI() {}

}
