package com.kicobicn.entity;

import com.kicobicn.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class EnderArrowEntity extends ArrowEntity {

    public EnderArrowEntity(EntityType<? extends EnderArrowEntity> type, World world) {
        super(type, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld() instanceof ServerWorld serverWorld) {
            // 计算上一帧与当前帧的箭矢位置
            double prevX = this.prevX, prevY = this.prevY, prevZ = this.prevZ;
            double currX = this.getX(), currY = this.getY(), currZ = this.getZ();
            double dx = currX - prevX, dy = currY - prevY, dz = currZ - prevZ;
            double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
            // 根据距离计算插值点数量（此处每移动 0.5 个方块生成一个粒子，可按需调整）
            int steps = Math.max(1, (int) (dist * 4));
            for (int i = 0; i <= steps; i++) {
                double t = (double) i / steps;
                double x = prevX + dx * t;
                double y = prevY + dy * t;
                double z = prevZ + dz * t;
                // 在计算出的点上生成粒子
                serverWorld.spawnParticles(ParticleTypes.PORTAL, x, y, z, 3, 0, 0, 0, 0);
            }
        }
    }

    public EnderArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.ENDER_PEARL_ARROW);
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        teleportShooter();
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        teleportShooter();
    }

    private void teleportShooter() {
        if (!this.getWorld().isClient() && this.getOwner() instanceof ServerPlayerEntity player) {
            ServerWorld targetWorld = (ServerWorld) this.getWorld();
            player.teleport(targetWorld, this.getX(), this.getY(), this.getZ(), player.getYaw(), player.getPitch());
            ServerWorld world = player.getServerWorld();
            // 播放传送音效
            world.playSound(
                    null, // 所有附近玩家都能听见
                    this.getX(), this.getY(), this.getZ(),
                    SoundEvents.ENTITY_ENDERMAN_TELEPORT,
                    player.getSoundCategory(),
                    1.0f, 1.0f
            );

            // 生成传送门粒子
            world.spawnParticles(
                    ParticleTypes.REVERSE_PORTAL, // 传送门粒子
                    this.getX(), this.getY(), this.getZ(),
                    150,       // 粒子数量
                    0.0, 0.0, 0.0, // 范围
                    1.5        // 速度
            );
            player.fallDistance = 0.0f;
            this.discard();
        }
    }
}