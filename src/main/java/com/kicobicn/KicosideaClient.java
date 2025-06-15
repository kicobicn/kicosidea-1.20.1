package com.kicobicn;

import com.kicobicn.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class KicosideaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //投掷物注册
        EntityRendererRegistry.register(ModEntities.TNT_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.STONE_PROJECTILE, FlyingItemEntityRenderer::new);


    }
}
