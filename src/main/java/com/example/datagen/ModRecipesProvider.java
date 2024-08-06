package com.example.datagen;

import com.example.blocks.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.ArrayList;
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

        offerSingleMaterialRecipe(exporter, RecipeCategory.COMBAT, ModItems.ORIGIN_ARMOR_BOOTS,
                RecipeCategory.COMBAT, ModItems.ORIGIN_STONE, SingleMaterialPattern.BOOTS_PATTERN, 1);

        offerSingleMaterialRecipe(exporter, RecipeCategory.COMBAT, ModItems.ORIGIN_ARMOR_CHESTPLATE,
                RecipeCategory.COMBAT, ModItems.ORIGIN_STONE, SingleMaterialPattern.CHESTPLATE_PATTERN, 1);

        offerSingleMaterialRecipe(exporter, RecipeCategory.COMBAT, ModItems.ORIGIN_ARMOR_HELMET,
                RecipeCategory.COMBAT, ModItems.ORIGIN_STONE, SingleMaterialPattern.HELMET_PATTERN, 1);

        offerSingleMaterialRecipe(exporter, RecipeCategory.COMBAT, ModItems.ORIGIN_ARMOR_LEGGINGS,
                RecipeCategory.COMBAT, ModItems.ORIGIN_STONE, SingleMaterialPattern.LEGGINGS_PATTERN, 1);

        // 熔炉
        offerSmelting(exporter, ORIGIN, RecipeCategory.BUILDING_BLOCKS, ModItems.ORIGIN_STONE,
                0.7f, 200, "origin");

        offerSmelting(exporter, List.of(ModItems.ORIGIN_STONE), RecipeCategory.FOOD, ModItems.ORIGIN_COOKIE,
                1.0f, 200, "origin");
    }

    public static void offerSingleMaterialRecipe(RecipeExporter exporter, RecipeCategory outputCategory, ItemConvertible output,
                                                 RecipeCategory inputCategory, ItemConvertible input,
                                                 SingleMaterialPattern pattern, int outputCount) {
        var builder = ShapedRecipeJsonBuilder.create(outputCategory, output, outputCount);
        builder.input(pattern.getMark(), input);
        for(var row : pattern.getPattern()) {
            builder.pattern(row);
        }
        builder.group(inputCategory.getName())
                .criterion("has_" + inputCategory.getName(), conditionsFromItem(input))
                .offerTo(exporter);
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

    // single material
    public static class SingleMaterialPattern{
        private List<String> pattern;

        public static SingleMaterialPattern HELMET_PATTERN = new SingleMaterialPattern("###", "# #", '#');
        public static SingleMaterialPattern CHESTPLATE_PATTERN = new SingleMaterialPattern("# #", "###", "###", '#');
        public static SingleMaterialPattern LEGGINGS_PATTERN = new SingleMaterialPattern("###", "# #", "# #", '#');
        public static SingleMaterialPattern BOOTS_PATTERN = new SingleMaterialPattern("# #", "# #", '#');

        private Character mark;

        public SingleMaterialPattern(String row1, String row2, String row3, Character mark){
            this.pattern = new ArrayList<>();
            this.mark = mark;
            if(row1 != null) this.pattern.add(row1);
            if(row2 != null) this.pattern.add(row2);
            if(row3 != null) this.pattern.add(row3);
        }

        public SingleMaterialPattern(String row1, String row2, Character mark){
            this.pattern = new ArrayList<>();
            this.mark = mark;
            if(row1 != null) this.pattern.add(row1);
            if(row2 != null) this.pattern.add(row2);
        }

        public SingleMaterialPattern(String row1, Character mark){
            this.pattern = new ArrayList<>();
            this.mark = mark;
            if(row1 != null) this.pattern.add(row1);
        }

        public List<String> getPattern() {
            return pattern;
        }

        public Character getMark() {
            return mark;
        }
    }
}