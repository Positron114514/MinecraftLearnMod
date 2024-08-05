package blocks;

import com.example.ExampleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ORIGIN_BLOCK = register("origin_block", new Block(AbstractBlock.Settings.create()
            .strength(1.5f, 6.0f)));

    public static final Block ORIGIN_ORE = register("origin_ore", new Block(AbstractBlock.Settings.create()
            .strength(3.0f, 3.0f)));

    public static Block register(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.modId, id), block);
    }

    public static void registerBlockItem(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, id), new BlockItem(block, new Item.Settings()));
        if(item instanceof BlockItem){
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item); // This is needed for the block to show up in creative mode
        }
    }

    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering ModBlocks for " + ExampleMod.modId);
    }
}
