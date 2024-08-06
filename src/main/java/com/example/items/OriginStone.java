package com.example.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class OriginStone extends Item {
    public OriginStone(Settings settings) {
        super(settings);
    }

    /**
     * each time the player uses the item, the OriginStone will give the player 1000 experience points and
     * be consumed
     * @param world the world the item was used in
     * @param player the player who used the item
     * @param hand the hand used
     * @return
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        player.addExperience(1000);
        player.playSound(SoundEvents.BLOCK_GLASS_BREAK);
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("A fantastic stone."));
    }
}
