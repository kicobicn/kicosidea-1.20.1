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
    public static final EntityType<EnderArrowEntity> ENDER_ARROW_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Kicosidea.MOD_ID, "ender_pearl_arrow"),
            FabricEntityTypeBuilder
                    .<EnderArrowEntity>create(SpawnGroup.MISC, EnderArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeChunks(4)
                    .trackedUpdateRate(20)
                    .build()
    );

    public static void registerEntities() {
        Kicosidea.LOGGER.info("Registering entities for " + Kicosidea.MOD_ID);
    }
}