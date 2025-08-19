package com.hwhw.duelmod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "hwhw", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    // Richtiger DeferredRegister
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "hwhw");

    // Beispiel-Entity (dein DuelBotEntity muss existieren!)
    public static final RegistryObject<EntityType<DuelBotEntity>> DUEL_BOT = ENTITIES.register("duel_bot",
            () -> EntityType.Builder.of(DuelBotEntity::new, MobCategory.MISC)
                    .sized(0.6f, 1.8f)
                    .build("duel_bot"));

    // Registrierungsmethode (wird in deinem Mod-Setup aufgerufen)
    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
