package com.example;

import com.example.datagen.*;
import com.example.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModENUSLanProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModLootTable::new);
        pack.addProvider(ModModelsProvider::new);
        pack.addProvider(ModRecipesProvider::new);
    }
}
