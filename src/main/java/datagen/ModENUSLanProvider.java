package datagen;

import blocks.ModBlocks;
import items.ModItemGroups;
import items.ModItems;
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
        // items
        translationBuilder.add(ModItems.ORIGIN_STONE, "Origin Stone");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_BOOTS, "Origin Stone Boots");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_CHESTPLATE, "Origin Stone Chestplate");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_HELMET, "Origin Stone Helmet");
        translationBuilder.add(ModItems.ORIGIN_ARMOR_LEGGINGS, "Origin Stone Leggings");

        translationBuilder.add(ModBlocks.ORIGIN_BLOCK, "Origin Block");
        translationBuilder.add(ModBlocks.ORIGIN_ORE, "Origin Ore");

        translationBuilder.add(ModItemGroups.ORIGIN, "Origin");
        // blocks
    }
}
