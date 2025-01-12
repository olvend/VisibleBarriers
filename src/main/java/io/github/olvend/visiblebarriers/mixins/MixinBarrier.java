package io.github.olvend.visiblebarriers.mixins;

import io.github.olvend.visiblebarriers.VisibleBarriers;
import net.minecraft.client.particle.Barrier;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Barrier.class)
public class MixinBarrier {
    @Inject(method = "renderParticle", at = @At("HEAD"), cancellable = true)
    public void removeParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ, CallbackInfo ci) {
        if (VisibleBarriers.isVisible) ci.cancel();
    }
}
