package com.hwhw.duelmod;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.EnumSet;

public class DuelBotAI extends Goal {

    private final DuelBotEntity bot;

    public DuelBotAI(DuelBotEntity bot) {
        this.bot = bot;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return true; // Immer aktiv
    }

    @Override
    public void tick() {
        if (bot.level().players().isEmpty()) return;

        Player target = bot.level().players().get(0); // Kämpft gegen den ersten Spieler
        bot.getLookControl().setLookAt(target, 30, 30);

        // TODO: Hier KI-Logik einfügen (Nahkampf/Bogen/Goldapfel/Lava etc.)
        // Für MVP einfach Schwert ziehen:
        bot.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }
}
