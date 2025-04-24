package io.github.olvend.visiblebarriers.mixin;

import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.*;

public class VersionedMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (!mixinClassName.endsWith("$")) {
            return true;
        }

        String className = mixinClassName.contains(".")
                ? mixinClassName.substring(mixinClassName.lastIndexOf('.') + 1)
                : mixinClassName;

        className = className.substring(0, className.length() - 1);

        Set<String> versions = className.contains("_v")
                ? new HashSet<>(Arrays.asList(className.substring(className.indexOf("_v") + 2).split("_")))
                : Collections.emptySet();

        return versions.isEmpty() || versions.contains(Loader.instance().getMinecraftModContainer().getVersion().split("\\.")[1]);
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
