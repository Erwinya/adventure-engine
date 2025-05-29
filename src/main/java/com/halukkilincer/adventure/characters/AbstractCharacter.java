package com.halukkilincer.adventure.characters;

import com.halukkilincer.adventure.interfaces.ICombat;
import com.halukkilincer.adventure.items.Inventory;

public abstract class AbstractCharacter implements ICombat {
    protected String name;
    protected int damage;
    protected int health;
    protected int maxHealth;
    protected int defense;
    protected Inventory inventory;

    public AbstractCharacter(String name, int damage, int health, int defense) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.defense = defense;
        this.inventory = new Inventory();
    }

    @Override
    public int attack() {
        return damage + inventory.getWeaponDamage();
    }

    @Override
    public void takeDamage(int incomingDamage) {
        int totalDefense = defense + inventory.getArmorDefense();
        int actualDamage = Math.max(1, incomingDamage - (totalDefense / 3)); // Zırh hasarın 1/3'ünü azaltır
        health = Math.max(0, health - actualDamage);
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

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage + inventory.getWeaponDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense + inventory.getArmorDefense();
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public abstract String getCharacterType();

    public void setHealth(int health) {
        this.health = Math.min(maxHealth, health);
    }
} 