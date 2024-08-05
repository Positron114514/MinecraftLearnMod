package com.example.items;

import com.example.items.armors.ModArmorMaterials;
import com.example.ExampleMod;
import com.example.items.tools.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ORIGIN_STONE = register("origin_stone",
            new OriginStone(new Item.Settings()));

    public static final Item ORIGIN_ARMOR_HELMET = register("origin_helmet", new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));

    public static final Item ORIGIN_ARMOR_CHESTPLATE = register("origin_chestplate" ,
            new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));

    public static final Item ORIGIN_ARMOR_BOOTS = register("origin_boots",
            new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static final Item ORIGIN_ARMOR_LEGGINGS = register( "origin_leggings",
            new ArmorItem(ModArmorMaterials.ORIGIN_ARMOR, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));

    public static final Item ORIGIN_SWORD = register("origin_sword",
            new SwordItem(ModToolMaterials.ORIGIN_STONE,
            new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.ORIGIN_STONE, 12, -2.0f))));

    public static Item ORIGIN_SHOVEL = register("origin_shovel",
            new ShovelItem(ModToolMaterials.ORIGIN_STONE,
            new Item.Settings().attributeModifiers(
                    ShovelItem.createAttributeModifiers(ModToolMaterials.ORIGIN_STONE, 6, -1.5f))));

    public static Item ORIGIN_PICKAXE = register("origin_pickaxe",
            new PickaxeItem(ModToolMaterials.ORIGIN_STONE,
                    new Item.Settings().attributeModifiers(
                            PickaxeItem.createAttributeModifiers(ModToolMaterials.ORIGIN_STONE, 6, -2.0f))));

    public static Item ORIGIN_AXE = register("origin_axe",
            new AxeItem(ModToolMaterials.ORIGIN_STONE,
                    new Item.Settings().attributeModifiers(
                            AxeItem.createAttributeModifiers(ModToolMaterials.ORIGIN_STONE, 18, -3.0f))));

    public static Item ORIGIN_HOE = register("origin_hoe",
            new HoeItem(ModToolMaterials.ORIGIN_STONE,
                     new Item.Settings().attributeModifiers(
                            HoeItem.createAttributeModifiers(ModToolMaterials.ORIGIN_STONE, 6, -1.0f))));

    public static void registerModItems(){
        // register
         ExampleMod.LOGGER.info("Registering Mod Items");
    }

    public static Item register(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.modId, id), item);
    }
}
