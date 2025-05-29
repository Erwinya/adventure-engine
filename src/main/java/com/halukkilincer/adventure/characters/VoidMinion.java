package com.halukkilincer.adventure.characters;

import java.util.Random;

public class VoidMinion extends Enemy {
    private static final Random random = new Random();
    
    public VoidMinion() {
        super("Void Minion", 10, 50, 10);
    }
} 