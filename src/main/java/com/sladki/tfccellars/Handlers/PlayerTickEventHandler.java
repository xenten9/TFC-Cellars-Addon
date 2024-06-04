package com.sladki.tfccellars.Handlers;

import com.sladki.tfccellars.ModManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class PlayerTickEventHandler {

    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
        ModManager.registerAnvilRecipes();
        FMLCommonHandler.instance()
            .bus()
            .unregister(ModManager.getPlayerTickEventHandler());
    }
}
