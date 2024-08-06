package com.example.datagen;

import com.example.blocks.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ORIGIN = List.of(ModBlocks.ORIGIN_ORE);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ORIGIN_STONE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORIGIN_BLOCK);

        offerMultipleObjectShapelessRecipe(exporter, ModItems.ORIGIN_SOUP, RecipeCategory.FOOD, 1,
                List.of(Items.BOWL, ModItems.ORIGIN_STONE));

        // 熔炉
        offerSmelting(exporter, ORIGIN, RecipeCategory.BUILDING_BLOCKS, ModItems.ORIGIN_STONE,
                0.7f, 200, "origin");

        offerSmelting(exporter, List.of(ModItems.ORIGIN_STONE), RecipeCategory.FOOD, ModItems.ORIGIN_COOKIE,
                1.0f, 200, "origin");
    }

    public static void offerMultipleObjectShapelessRecipe(RecipeExporter exporter,
                                                     ItemConvertible result, RecipeCategory inputCategory,
                                                     int resultNum, List<ItemConvertible> inputs) {
        var builder =  ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, result, resultNum);
        for (var input : inputs) {
            builder.input(input);
        }
        builder.criterion("has_" + inputCategory.getName(), conditionsFromItem(inputs.getFirst()))
                .offerTo(exporter);
    }
}