package io.github.olvend.visiblebarriers.mixin;

import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class VersionedMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        String minecraftVersion = Loader.instance().getMCVersionString().substring(10);
        if (mixinClassName.endsWith("v1_8")) {
            return minecraftVersion.startsWith("1.8");
        }
        if (mixinClassName.endsWith("v1_9")) {
            if (mixinClassName.startsWith("io.github.olvend.visiblebarriers.mixin.mixins.BarrierMixin") && minecraftVersion.startsWith("1.12")) {
                return false;
            }
            return !minecraftVersion.startsWith("1.8");
        }
        if (mixinClassName.endsWith("v1_12")) {
            return minecraftVersion.startsWith("1.12");
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
