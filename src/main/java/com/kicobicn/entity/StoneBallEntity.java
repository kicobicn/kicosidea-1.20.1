package com.kicobicn.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class StoneBallEntity extends SnowballEntity {

    public StoneBallEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public StoneBallEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        if (!this.getWorld().isClient()) {
            // 自定义造成 4 点伤害（可自定义）
            entityHitResult.getEntity().damage(
                    getDamageSource(),
                    2.0F
            );
        }
    }

    private DamageSource getDamageSource() {
        return this.getWorld().getDamageSources().thrown(this, this.getOwner());
    }
}