package com.traverse.swift.config;

import com.traverse.swift.Swift;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Swift.MODID)
public class ConfigHandler implements ConfigData {

    @Comment("Max Enchant Level")
    public int maxEnchantLevel = 2;

    @Comment("Min Enchantment Level Requirement")
    public int minEnchantLevelRequirement = 30;

   @Comment("Damage Chance To Equipment")
    public double damageChanceToEquipment = 0.05;

   @Comment("Can Be Applied From Enchantment Table")
    public boolean canBeAppliedFromEnchantTable = true;

   @Comment("Has Villager Trade")
    public boolean hasVillagerTrade = true;
}
