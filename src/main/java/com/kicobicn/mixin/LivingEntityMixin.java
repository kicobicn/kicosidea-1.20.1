package com.kicobicn.mixin;

import com.kicobicn.handler.SharpeningHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    // 修改实际攻击伤害
    @ModifyVariable(method = "applyDamage", at = @At("HEAD"), argsOnly = true)
    private float modifyActualDamage(float amount, DamageSource source) {
        if (source.getAttacker() instanceof PlayerEntity player) {
            ItemStack stack = player.getMainHandStack();

            // 获取强化等级
            int sharpeningLevel = SharpeningHandler.getSharpeningLevel(stack);
            if (sharpeningLevel > 0) {
                // 增加伤害值
                return amount + sharpeningLevel;
            }
        }
        return amount;
    }
}