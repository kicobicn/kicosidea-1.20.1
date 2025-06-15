package com.kicobicn.entity;

import com.kicobicn.Kicosidea;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<TNTProjectileEntity> TNT_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Kicosidea.MOD_ID, "tnt_projectile"),
            FabricEntityTypeBuilder.<TNTProjectileEntity>create(SpawnGroup.MISC, TNTProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<TNTProjectileEntity> STONE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Kicosidea.MOD_ID, "stone_projectile"),
            FabricEntityTypeBuilder.<TNTProjectileEntity>create(SpawnGroup.MISC, TNTProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static void registerEntities(){
        Kicosidea.LOGGER.info("Registering Entities for " + Kicosidea.MOD_ID);
    }
}
