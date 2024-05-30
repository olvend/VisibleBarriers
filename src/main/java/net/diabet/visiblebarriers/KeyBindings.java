package net.diabet.visiblebarriers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindings {
    private static KeyBinding TOGGLE_KEY;

    public static void register() {
        TOGGLE_KEY = new KeyBinding("key.toggle_barrier_visibility", Keyboard.KEY_B, "key.category.visible_barriers");
        ClientRegistry.registerKeyBinding(TOGGLE_KEY);
    }

    @SubscribeEvent
    public void toggleKey(InputEvent event) {
        if (TOGGLE_KEY.isPressed()) {
            VisibleBarriers.isVisible = !VisibleBarriers.isVisible;
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
        }
    }
}
