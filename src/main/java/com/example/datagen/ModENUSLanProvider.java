package com.example.datagen;

import com.example.blocks.ModBlocks;
import com.example.items.ModItemGroups;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // group
        translationBuilder.add(ModItemGroups.ORIGIN, "Origin");

        // items
        translationBuilder.add(ModItems.ORIGIN_STONE, "Origin Stone");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_BOOTS, "Origin Stone Boots");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_CHESTPLATE, "Origin Stone Chestplate");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_HELMET, "Origin Stone Helmet");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_LEGGINGS, "Origin Stone Leggings");

        // tools
        translationBuilder.add(ModItems.ORIGIN_SWORD, "Origin Stone Sword");
        translationBuilder.add(ModItems.ORIGIN_PICKAXE, "Origin Stone Pickaxe");
        translationBuilder.add(ModItems.ORIGIN_AXE, "Origin Stone Axe");
        translationBuilder.add(ModItems.ORIGIN_SHOVEL, "Origin Stone Shovel");
        translationBuilder.add(ModItems.ORIGIN_HOE, "Origin Stone Hoe");

        // blocks
        translationBuilder.add(ModBlocks.ORIGIN_BLOCK, "Origin Block");
        translationBuilder.add(ModBlocks.ORIGIN_ORE, "Origin Ore");



    }
}
