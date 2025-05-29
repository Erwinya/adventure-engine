package com.halukkilincer.adventure.interfaces;

/**
 * Interface defining combat-related behaviors
 */
public interface ICombat {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    int getHealth();
    void heal(int amount);
} 