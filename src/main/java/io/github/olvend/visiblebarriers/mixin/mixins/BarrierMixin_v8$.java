package io.github.olvend.visiblebarriers.mixin.mixins;

import io.github.olvend.visiblebarriers.VisibleBarriers;
import net.minecraft.client.particle.Barrier;
import net.minecraft.client.particle.EntityFX;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Barrier.class)
public class BarrierMixin_v8$ extends EntityFX {
    protected BarrierMixin_v8$() {
        super(null, 0, 0, 0);
    }

    @Inject(method = "Lnet/minecraft/client/particle/Barrier;func_180434_a(Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/entity/Entity;FFFFFF)V", at = @At("HEAD"), cancellable = true, remap = false)
    public void removeParticle(CallbackInfo ci) {
        if (VisibleBarriers.isVisible) {
            this.particleMaxAge = Integer.MIN_VALUE;
            ci.cancel();
        }
    }
}
