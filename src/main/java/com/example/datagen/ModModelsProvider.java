package com.example.datagen;

import com.example.blocks.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {

    public ModModelsProvider(FabricDataOutput op){
        super(op);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORIGIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORIGIN_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.ORIGIN_STONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ORIGIN_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORIGIN_SOUP, Models.GENERATED);

        itemModelGenerator.register(ModItems.ORIGIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ORIGIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ORIGIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ORIGIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ORIGIN_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_LEGGINGS);
    }
}
