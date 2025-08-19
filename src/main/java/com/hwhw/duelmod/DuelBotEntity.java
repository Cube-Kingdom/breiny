package com.hwhw.duelmod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class DuelBotEntity extends Mob {
    public DuelBotEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
        this.setCustomNameVisible(true);
        this.setCustomName(net.minecraft.network.chat.Component.literal("DuelBot"));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new DuelBotAI(this));
    }
}
