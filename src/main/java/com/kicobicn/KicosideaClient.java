package com.kicobicn;

import com.kicobicn.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class KicosideaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ENDER_ARROW_ENTITY,
                ArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_BALL,
                FlyingItemEntityRenderer::new);

    }
}
