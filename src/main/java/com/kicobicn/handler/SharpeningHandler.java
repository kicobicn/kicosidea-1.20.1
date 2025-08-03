package com.kicobicn.handler;

import com.kicobicn.Kicosidea;
import com.kicobicn.item.ModItems;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;

public class SharpeningHandler {
    // NBT标签定义
    private static final String SHARPENING_TAG = "kicosidea_sharpening_level";

    public static void register() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stackInHand = player.getStackInHand(hand);

            // 确保是主手持磨刀石
            if (hand == Hand.MAIN_HAND && stackInHand.getItem() == ModItems.SHARPENING_STONE) {
                ItemStack offhandStack = player.getOffHandStack();

                // 检查副手是否有物品
                if (!offhandStack.isEmpty()) {
                    // 获取当前强化等级
                    int currentLevel = getSharpeningLevel(offhandStack);
                    int newLevel = currentLevel + 1;

                    // 创建副本避免修改原始堆栈
                    ItemStack result = offhandStack.copy();

                    // 更新强化等级
                    setSharpeningLevel(result, newLevel);

                    // 设置副手物品为强化后的物品
                    player.setStackInHand(Hand.OFF_HAND, result);

                    // 消耗1个磨刀石（除非是创造模式）
                    if (!player.isCreative()) {
                        stackInHand.decrement(1);
                    }

                    // 播放强化音效
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE, 1.0F, 1.0F);

                    // 显示强化成功消息
                    player.sendMessage(Text.translatable("message.kicosidea.sharpened", newLevel)
                            .formatted(Formatting.GREEN), true);

                    Kicosidea.LOGGER.info("成功强化副手物品! 新等级: " + newLevel);

                    return TypedActionResult.success(stackInHand);
                }
            }
            return TypedActionResult.pass(stackInHand);
        });
    }

    // 获取强化等级
    public static int getSharpeningLevel(ItemStack stack) {
        if (stack.hasNbt() && stack.getNbt().contains(SHARPENING_TAG)) {
            return stack.getNbt().getInt(SHARPENING_TAG);
        }
        return 0;
    }

    // 设置强化等级
    public static void setSharpeningLevel(ItemStack stack, int level) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(SHARPENING_TAG, level);
    }
}