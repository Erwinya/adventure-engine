package com.halukkilincer.adventure.interfaces;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;

public interface ICombatStrategy {
    boolean executeCombat(AbstractCharacter player, Enemy enemy) throws InterruptedException;
    String getStrategyName();
} 