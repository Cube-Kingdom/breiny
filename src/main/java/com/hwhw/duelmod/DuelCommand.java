package com.hwhw.duelmod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DuelCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("duel")
                .executes(context -> {
                    Player player = context.getSource().getPlayerOrException();
                    DuelBotEntity bot = new DuelBotEntity(ModEntities.DUEL_BOT.get(), player.level());
                    bot.moveTo(player.getX()+2, player.getY(), player.getZ()+2, 0,0);
                    player.level().addFreshEntity(bot);

                    // Heldenausrüstung
                    equipHeroGear(bot);
                    equipHeroGear(player);

                    return 1;
                }));
    }

    private static void equipHeroGear(LivingEntity entity) {
        entity.setItemSlot(EquipmentSlot.HEAD, enchantedStack(Items.DIAMOND_HELMET));
        entity.setItemSlot(EquipmentSlot.CHEST, enchantedStack(Items.DIAMOND_CHESTPLATE));
        entity.setItemSlot(EquipmentSlot.LEGS, enchantedStack(Items.DIAMOND_LEGGINGS));
        entity.setItemSlot(EquipmentSlot.FEET, enchantedStack(Items.DIAMOND_BOOTS));
        entity.setItemSlot(EquipmentSlot.MAINHAND, enchantedSword());
        entity.setItemSlot(EquipmentSlot.OFFHAND, enchantedShield());
    }

    private static ItemStack enchantedStack(Item item) {
        ItemStack stack = new ItemStack(item);
        stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
        stack.enchant(Enchantments.BINDING_CURSE, 3);
        return stack;
    }

    private static ItemStack enchantedSword() {
        ItemStack sword = new ItemStack(Items.DIAMOND_SWORD);
        sword.enchant(Enchantments.SHARPNESS, 5);
        sword.enchant(Enchantments.FIRE_ASPECT, 2);
        return sword;
    }

    private static ItemStack enchantedShield() {
        ItemStack shield = new ItemStack(Items.SHIELD);
        shield.enchant(Enchantments.UNBREAKING, 3);
        return shield;
    }
}
