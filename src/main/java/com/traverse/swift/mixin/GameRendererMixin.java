package com.traverse.swift.mixin;

import com.traverse.swift.Swift;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "getFov", at = @At("HEAD"), cancellable = true)
    private void modiftyFOV(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
        if(camera.getFocusedEntity() instanceof AbstractClientPlayerEntity player) {
            ItemStack stack = player.getEquippedStack(EquipmentSlot.FEET);
            if(EnchantmentHelper.getLevel(Swift.SWIFT_ENCHANTMENT, stack) >= 1) {
                MinecraftClient client = MinecraftClient.getInstance();
                double  baseFov = (double)client.options.getFov().getValue();
                cir.setReturnValue(baseFov);
            }
        }
    }
}
