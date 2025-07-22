package com.kicobicn.entity;

import com.kicobicn.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class EnderArrowEntity extends ArrowEntity {

    public EnderArrowEntity(EntityType<? extends EnderArrowEntity> type, World world) {
        super(type, world);
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
            player.requestTeleport(this.getX(), this.getY(), this.getZ());
            player.fallDistance = 0.0f;
            this.discard();
        }
    }
}