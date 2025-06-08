package com.halukkilincer.adventure.interfaces;

public interface ICombat {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    int getHealth();
    void heal(int amount);
} 