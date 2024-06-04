package sladki.tfc.Handlers;

import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import sladki.tfc.ModManager;

public class ChunkEventHandler {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onLoadWorld(WorldEvent.Load event) {
        if (event.world.provider.dimensionId == 0) {
            if (event.world.isRemote) {
                FMLCommonHandler.instance()
                    .bus()
                    .register(ModManager.getPlayerTickEventHandler());
            } else {
                ModManager.registerAnvilRecipes();
            }
        }
    }

}
