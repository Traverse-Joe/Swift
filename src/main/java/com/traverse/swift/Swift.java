package com.traverse.swift;

import com.traverse.swift.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Swift implements ModInitializer {

    public static final String MODID = "swift";
    public static final Enchantment SWIFT_ENCHANTMENT = Registry.register(Registries.ENCHANTMENT, new Identifier(MODID, "swift"), new SwiftEnchantment());
    public static ConfigHandler CONFIG;

    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigHandler.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
        AutoConfig.getConfigHolder(ConfigHandler.class).save();
    }
}
