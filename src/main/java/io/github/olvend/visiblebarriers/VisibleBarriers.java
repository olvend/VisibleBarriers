package io.github.olvend.visiblebarriers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid =
        VisibleBarriers.MODID,
        name = VisibleBarriers.NAME,
        version = VisibleBarriers.VERSION,
        clientSideOnly = true
)
public class VisibleBarriers {
    public static final String MODID = "visiblebarriers";
    public static final String NAME = "Visible Barrers";
    public static final String VERSION = "1.0.1";

    public static boolean isVisible = false;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        KeyBindings.register();
        MinecraftForge.EVENT_BUS.register(new KeyBindings());
    }
}
