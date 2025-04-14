package io.github.olvend.visiblebarriers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(
        modid = VisibleBarriers.MODID,
        name = VisibleBarriers.NAME,
        version = VisibleBarriers.VERSION,
        clientSideOnly = true,
        acceptedMinecraftVersions = "[1.8,1.12.2]"
)
public class VisibleBarriers {
    public static final String MODID = "visiblebarriers";
    public static final String NAME = "Visible Barriers";
    public static final String VERSION = "1.1.0";

    public static boolean isVisible = false;

    private final KeyBinding TOGGLE_KEY = new KeyBinding("key.toggle_visibility", Keyboard.KEY_B, "key.category.visiblebarriers");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientRegistry.registerKeyBinding(this.TOGGLE_KEY);
    }

    @SubscribeEvent
    public void toggleKey(InputEvent event) {
        if (this.TOGGLE_KEY.isPressed()) {
            VisibleBarriers.isVisible = !VisibleBarriers.isVisible;
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
        }
    }
}
