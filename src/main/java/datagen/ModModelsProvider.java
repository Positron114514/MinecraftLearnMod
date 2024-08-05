package datagen;

import blocks.ModBlocks;
import items.ModItems;
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
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ORIGIN_ARMOR_LEGGINGS);
    }
}
