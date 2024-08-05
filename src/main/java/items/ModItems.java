package items;

import armors.ModArmorMaterials;
import com.example.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ORIGIN_STONE = new OriginStone(new Item.Settings());

    public static final Item ORIGIN_ARMOR_HELMET = new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37)));

    public static final Item ORIGIN_ARMOR_CHESTPLATE = new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)));

    public static final Item ORIGIN_ARMOR_BOOTS = new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)));

    public static final Item ORIGIN_ARMOR_LEGGINGS = new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)));

    public static void register(){
        // register
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, "origin_stone"), ORIGIN_STONE);
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, "origin_helmet"), ORIGIN_ARMOR_HELMET);
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, "origin_boots"), ORIGIN_ARMOR_BOOTS);
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, "origin_leggings"), ORIGIN_ARMOR_LEGGINGS);
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, "origin_chestplate"), ORIGIN_ARMOR_CHESTPLATE);

        // add to functional group
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.ORIGIN).register(content -> {
            content.add(ORIGIN_STONE);
        });

        // add to combat group
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.ORIGIN).register(content ->{
            content.addAfter(Items.NETHERITE_BOOTS, ORIGIN_ARMOR_BOOTS);
            content.addAfter(ORIGIN_ARMOR_BOOTS, ORIGIN_ARMOR_HELMET);
            content.addAfter(ORIGIN_ARMOR_HELMET, ORIGIN_ARMOR_CHESTPLATE);
            content.addAfter(ORIGIN_ARMOR_CHESTPLATE, ORIGIN_ARMOR_LEGGINGS);
        });
    }
}
