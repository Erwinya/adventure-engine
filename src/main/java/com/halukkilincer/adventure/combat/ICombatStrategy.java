package com.halukkilincer.adventure.combat;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;

/**
 * The ICombatStrategy interface defines the contract for implementing different combat strategies
 * in the game. This follows the Strategy pattern, allowing for different combat implementations
 * while maintaining a consistent interface.
 *
 * @author Haluk Kilincer
 * @version 1.0
 * @since 2024-02-20
 */
public interface ICombatStrategy {
    
    /**
     * Executes a combat sequence between a player character and an enemy.
     *
     * @param player The player character participating in combat
     * @param enemy The enemy character participating in combat
     * @return true if the player wins the combat, false if the player loses or retreats
     * @throws IllegalArgumentException if either player or enemy is null
     */
    boolean executeCombat(AbstractCharacter player, Enemy enemy) throws InterruptedException;

    /**
     * Gets the name of the combat strategy.
     *
     * @return A string representing the name of the combat strategy
     */
    String getStrategyName();
} 