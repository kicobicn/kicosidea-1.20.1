package com.kicobicn.mixin;

import com.kicobicn.handler.SharpeningHandler;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract boolean hasNbt();

    @Shadow public abstract NbtCompound getNbt();

    // 修改工具提示中的攻击伤害
    @Inject(method = "getTooltip", at = @At("RETURN"))
    private void modifyTooltipDamage(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> cir) {
        List<Text> tooltip = cir.getReturnValue();
        ItemStack stack = (ItemStack)(Object)this;

        // 检查是否有强化等级
        int sharpeningLevel = SharpeningHandler.getSharpeningLevel(stack);
        if (sharpeningLevel > 0) {
            // 新的伤害文本
            tooltip.add(Text.translatable("attribute.name.generic.attack_damage")
                    .append(Text.literal("+ " + sharpeningLevel)
                            .formatted(Formatting.DARK_GREEN)));

            // 添加强化等级提示
            tooltip.add(Text.translatable("tooltip.kicosidea.sharpened", sharpeningLevel)
                    .formatted(Formatting.BLUE));



        }
    }
}
