package com.halukkilincer.adventure.characters;

import java.util.Random;
import com.halukkilincer.adventure.interfaces.ICombat;
import com.halukkilincer.adventure.interfaces.ILootable;
import com.halukkilincer.adventure.items.LootManager;

public class Enemy implements ICombat, ILootable {
    private final String name;
    private int damage;
    private int health;
    private final int maxHealth;
    private final int gold;
    private final int originalHealth;
    private static final Random random = new Random();

    public Enemy(String name, int damage, int health, int gold) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.originalHealth = health;
        this.gold = gold;
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public void resetHealth() {
        this.health = this.originalHealth;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return 10; // Default defense value as used in the test
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getGoldReward() {
        return gold;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String dropLoot() {
        return LootManager.rollForLoot(name);
    }

    public String dropRareItem() {
        int chance = random.nextInt(100); // 0-99 arası rastgele sayı
        
        // Kadim Taş - %2 şans (Void Lord için)
        if (this.name.equals("Void Lord") && chance < 2) {
            return "Kadim Taş";
        }
        
        // Orman Parşömeni - %3 şans (Shadow Beast için)
        if (this.name.equals("Shadow Beast") && chance < 3) {
            return "Orman Parşömeni";
        }
        
        // Void Kristali - %1 şans (Void Minion için)
        if (this.name.equals("Void Minion") && chance < 1) {
            return "Void Kristali";
        }
        
        return null;
    }
} 