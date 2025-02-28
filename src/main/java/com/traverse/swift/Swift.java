package com.traverse.swift;

import com.traverse.swift.config.ConfigHandler;
import com.traverse.swift.enchantment.SwiftEnchantment;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        addToCreativeTab();
    }

    private static ItemStack createEnchantedBook(Enchantment enchantment, int level) {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
        EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentLevelEntry(enchantment, level));
        return enchantedBook;
    }

    private static void addToCreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            for(int level = SWIFT_ENCHANTMENT.getMinLevel(); level <= SWIFT_ENCHANTMENT.getMaxLevel(); level++) {
                entries.add(createEnchantedBook(SWIFT_ENCHANTMENT, level));
            }
        });
    }
}
