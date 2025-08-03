package com.kicobicn.block;

import com.kicobicn.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

public class LuckyBlock extends Block {
    public LuckyBlock(FabricBlockSettings strength) {
        super(AbstractBlock.Settings.create()
                .mapColor(net.minecraft.block.MapColor.GOLD)
                .strength(1.5f)
                .nonOpaque()
        );
    }

    @Override
    public void afterBreak(World world, net.minecraft.entity.player.PlayerEntity player,
                           BlockPos pos, BlockState state, net.minecraft.block.entity.BlockEntity blockEntity, ItemStack tool) {
        if (!world.isClient) {
            Random random = world.getRandom();
            int outcome = random.nextInt(16);

            switch (outcome) {
                case 0 -> Block.dropStack(world, pos, new ItemStack(Items.DIAMOND, 2));
                case 1 -> {
                    ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, world);
                    zombie.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                    world.spawnEntity(zombie);
                }
                case 2 -> world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, World.ExplosionSourceType.BLOCK);
                case 3 -> Block.dropStack(world, pos, new ItemStack(ModItems.SHIT, 2));
                case 4 -> {
                    // 生成虚假的钻石矿石（掉落石头）
                    BlockPos diamondPos = pos.up();
                    world.setBlockState(diamondPos, Blocks.DIAMOND_ORE.getDefaultState());
                    world.scheduleBlockTick(diamondPos, Blocks.STONE, 60); // 之后玩家挖了只掉石头（你可以自定义掉落）
                }
                case 5 ->
                    // 播放雷电但不造成伤害
                    world.playSound(null, pos, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 10.0f, 1.0f);

                case 6 -> {
                    // 玩家原地传送 5 格高空（摔一下）
                    if (player != null) {
                        player.requestTeleport(player.getX(), player.getY() + 5, player.getZ());
                    }
                }
                case 7 -> {
                    // 生成 5 个苦力怕（但不引爆）
                    for (int i = 0; i < 5; i++) {
                        CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER, world);
                        creeper.refreshPositionAndAngles(pos.add(world.random.nextBetween(-2, 2), 0, world.random.nextBetween(-2, 2)), 0, 0);
                        world.spawnEntity(creeper);
                    }
                }
                case 8 ->
                    // 播放“TNT点燃”的声音，吓玩家
                    world.playSound(null, pos, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                case 9 -> {
                    // 在脚下生成水 + 黏液块组合（让人乱跳）
                    world.setBlockState(pos.down(), Blocks.SLIME_BLOCK.getDefaultState());
                    world.setBlockState(pos, Blocks.WATER.getDefaultState());
                }
                case 10 -> {
                    // 创建并生成点燃的 TNT 实体（立刻开始燃烧）
                    TntEntity tnt = new TntEntity(EntityType.TNT, world);
                    tnt.setFuse(60); // 60 tick 约 3 秒后爆炸
                    tnt.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
                    world.spawnEntity(tnt);
                    world.playSound(null, pos, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                }
                case 11 -> {
                    if (player != null) {
                        List<Item> foods = List.of(
                                Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.APPLE,
                                Items.BAKED_POTATO, Items.BREAD, Items.CARROT,
                                Items.GOLDEN_CARROT, Items.MELON_SLICE, Items.MUSHROOM_STEW,
                                Items.COOKED_MUTTON, Items.COOKED_PORKCHOP, Items.COOKED_SALMON
                        );

                        int amount = 3 + world.random.nextInt(3); // 3~5 个
                        for (int i = 0; i < amount; i++) {
                            Item food = foods.get(world.random.nextInt(foods.size()));
                            Block.dropStack(world, pos, new ItemStack(food));
                        }
                    }
                }
                case 12 -> {
                    if (player != null) {
                        List<StatusEffect> allEffects = new java.util.ArrayList<>(List.of(
                                // 增益
                                StatusEffects.SPEED,
                                StatusEffects.JUMP_BOOST,
                                StatusEffects.HASTE,
                                StatusEffects.STRENGTH,
                                StatusEffects.REGENERATION,
                                StatusEffects.RESISTANCE,
                                StatusEffects.FIRE_RESISTANCE,
                                StatusEffects.WATER_BREATHING,
                                StatusEffects.NIGHT_VISION,
                                StatusEffects.HEALTH_BOOST,
                                StatusEffects.LUCK,
                                StatusEffects.SATURATION,
                                // 减益
                                StatusEffects.SLOWNESS,
                                StatusEffects.MINING_FATIGUE,
                                StatusEffects.NAUSEA,
                                StatusEffects.BLINDNESS,
                                StatusEffects.HUNGER,
                                StatusEffects.WEAKNESS,
                                StatusEffects.UNLUCK,
                                StatusEffects.WITHER,
                                StatusEffects.POISON,
                                // 中立或稀有
                                StatusEffects.LEVITATION,
                                StatusEffects.GLOWING,
                                StatusEffects.DARKNESS
                        ));

                        // 打乱效果列表，选出前两个不同的效果
                        Collections.shuffle(allEffects);
                        StatusEffect effect1 = allEffects.get(0);
                        StatusEffect effect2 = allEffects.get(1);

                        // 给玩家添加两个效果，默认15秒，1级
                        player.addStatusEffect(new StatusEffectInstance(effect1, 15 * 20, 0));
                        player.addStatusEffect(new StatusEffectInstance(effect2, 15 * 20, 0));

                        // 播放神秘音效
                        world.playSound(null, pos, SoundEvents.ENTITY_WITCH_CELEBRATE, SoundCategory.PLAYERS, 1.0f, 1.0f);
                    }
                }
                case 13 -> {
                    if (random.nextBoolean()) {
                        world.setBlockState(pos, ModBlocks.KICO_LUCKY_BLOCK.getDefaultState());
                        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 1.0f, 1.2f);
                    }
                }
                case 14 -> {
                    if (player != null) {
                        float damage = 4 + random.nextInt(5); // 4 ~ 8 的随机 float 值
                        player.damage(world.getDamageSources().generic(), damage);
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_HURT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                }
                case 15 ->
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20, 19));
            }
        }

        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }
}