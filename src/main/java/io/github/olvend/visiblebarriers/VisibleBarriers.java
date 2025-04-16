package io.github.olvend.visiblebarriers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
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

    private final KeyBinding toggleKey = new KeyBinding(
            "key.toggle_visibility",
            Keyboard.KEY_B,
            "key.category.visiblebarriers"
    );

    private boolean wasPressed = false;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        ClientRegistry.registerKeyBinding(this.toggleKey);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent event) {
        if (this.toggleKey.isKeyDown() && !this.wasPressed) {
            VisibleBarriers.isVisible = !VisibleBarriers.isVisible;
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
        }
        this.wasPressed = this.toggleKey.isKeyDown();
    }
}
