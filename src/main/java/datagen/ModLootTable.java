package datagen;

import items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import blocks.ModBlocks;

public class ModLootTable extends FabricBlockLootTableProvider {
    public ModLootTable(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ORIGIN_BLOCK);
        // mine
        addDrop(ModBlocks.ORIGIN_ORE, varNumDrops(ModBlocks.ORIGIN_ORE, ModItems.ORIGIN_STONE, 2, 4));
    }

    public LootTable.Builder varNumDrops(Block drop, Item dropItem, float minimunNumber, float maximumNumber) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ItemEntry.builder(dropItem)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minimunNumber, maximumNumber)))
                .apply(ApplyBonusLootFunction
                        .oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
