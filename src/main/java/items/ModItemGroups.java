package items;

import blocks.ModBlocks;
import com.example.ExampleMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> ORIGIN = register("origin");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ExampleMod.modId, id));
    }

    public static void registerModItemGroups(){
        Registry.register(Registries.ITEM_GROUP, ORIGIN,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                                .displayName(Text.translatable("itemGroup.origin"))
                                        .icon(() -> new ItemStack(ModItems.ORIGIN_STONE))
                        .entries(((displayContext, entries) -> {
                            entries.add(ModItems.ORIGIN_STONE);
                            entries.add(ModItems.ORIGIN_ARMOR_BOOTS);
                            entries.add(ModItems.ORIGIN_ARMOR_CHESTPLATE);
                            entries.add(ModItems.ORIGIN_ARMOR_HELMET);
                            entries.add(ModItems.ORIGIN_ARMOR_LEGGINGS);
                            entries.add(Items.DIAMOND);

                            entries.add(ModBlocks.ORIGIN_BLOCK);
                            entries.add(ModBlocks.ORIGIN_ORE);
                        })).build());

        ExampleMod.LOGGER.info("registering mod items: ");
    }
}
