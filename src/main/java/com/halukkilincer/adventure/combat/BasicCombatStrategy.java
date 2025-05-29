package com.halukkilincer.adventure.combat;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;
import com.halukkilincer.adventure.interfaces.ICombatStrategy;
import com.halukkilincer.adventure.utils.GameLogger;

public class BasicCombatStrategy implements ICombatStrategy {
    @Override
    public boolean executeCombat(AbstractCharacter player, Enemy enemy) throws InterruptedException {
        int playerDamage = player.attack();
        enemy.takeDamage(playerDamage);
        
        if (enemy.getHealth() > 0) {
            int enemyDamage = enemy.attack();
            player.takeDamage(enemyDamage);
        }
        
        GameLogger.logBattle(player.getName(), enemy.getName(), player.getHealth(), enemy.getHealth());
        return player.isAlive();
    }

    @Override
    public String getStrategyName() {
        return "Temel Savaş";
    }
} 