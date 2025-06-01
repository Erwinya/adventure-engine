package com.halukkilincer.adventure.combat;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicCombatStrategyTest {
    private ICombatStrategy strategy;
    private AbstractCharacter player;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        strategy = new BasicCombatStrategy();
        // Create test doubles (mocks) for player and enemy
        player = new TestCharacter("Test Player", 100, 20, 10);
        enemy = new Enemy("Test Enemy", 50, 10, 5);
    }

    @Test
    void testExecuteCombat_PlayerWins() {
        // Given a strong player and weak enemy
        player = new TestCharacter("Strong Player", 100, 30, 15);
        enemy = new Enemy("Weak Enemy", 20, 5, 2);

        // When combat is executed
        boolean result = strategy.executeCombat(player, enemy);

        // Then player should win
        assertTrue(result);
        assertTrue(player.isAlive());
        assertFalse(enemy.isAlive());
    }

    @Test
    void testExecuteCombat_PlayerLoses() {
        // Given a weak player and strong enemy
        player = new TestCharacter("Weak Player", 20, 5, 2);
        enemy = new Enemy("Strong Enemy", 100, 30, 15);

        // When combat is executed
        boolean result = strategy.executeCombat(player, enemy);

        // Then player should lose
        assertFalse(result);
        assertFalse(player.isAlive());
        assertTrue(enemy.isAlive());
    }
 
    @Test
    void testGetStrategyName() {
        assertEquals("Basic Combat Strategy", strategy.getStrategyName());
    }

    // Test double for AbstractCharacter
    private static class TestCharacter extends AbstractCharacter {
        public TestCharacter(String name, int health, int damage, int defense) {
            super(name, health, damage, defense);
        }

        @Override
        public String getDescription() {
            return "Test Character";
        }

        @Override
        public String getCharacterType() {
            return "Test";
        }
    }
} 