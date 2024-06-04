package sladki.tfc.Handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import sladki.tfc.ModManager;

public class PlayerTickEventHandler {

    @SubscribeEvent
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
        ModManager.registerAnvilRecipes();
        FMLCommonHandler.instance()
            .bus()
            .unregister(ModManager.getPlayerTickEventHandler());
    }
}
