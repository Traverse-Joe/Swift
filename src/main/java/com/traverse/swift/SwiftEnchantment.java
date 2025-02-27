package com.traverse.swift;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;

public class SwiftEnchantment extends Enchantment {

    public SwiftEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinLevel() {
        return Swift.CONFIG.minEnchantLevelRequirement;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return Swift.CONFIG.canBeAppliedFromEnchantTable;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        if(other instanceof SoulSpeedEnchantment || other instanceof FrostWalkerEnchantment) {
            return false;
        }
        return super.canAccept(other);
    }

    @Override
    public int getMaxLevel() {
        return Swift.CONFIG.maxEnchantLevel;
    }

}

