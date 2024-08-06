package com.example.items.foods;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent ORIGIN_COOKIE =
            (new FoodComponent.Builder()).nutrition(3).saturationModifier(1.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 0), 0.8F)
                    .build();

    public static final FoodComponent ORIGIN_SOUP =
            ModFoodComponents.createStew(8, 1.5f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 0), 0.8F)
                    .build();

    public static FoodComponent.Builder createStew(int hunger, float saturation) {
        return new FoodComponent.Builder().nutrition(hunger).saturationModifier(saturation).usingConvertsTo(Items.BOWL);
    }
}
