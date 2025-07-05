package com.kicobicn.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodCompenents {
    public static final FoodComponent SHIT = new FoodComponent.Builder().hunger(2).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,400),1f).build();
}
