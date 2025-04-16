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
        modid = VisibleBarriers.MOD_ID,
        name = VisibleBarriers.MOD_NAME,
        version = VisibleBarriers.MOD_VERSION,
        acceptedMinecraftVersions = "@ACCEPTED_MINECRAFT_VERSIONS@",
        clientSideOnly = true
)
public class VisibleBarriers {
    public static final String MOD_ID = "@MOD_ID@";
    public static final String MOD_NAME = "@MOD_NAME@";
    public static final String MOD_VERSION = "@MOD_VERSION@";

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
