package com.halukkilincer.adventure.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Enemy enemy;
 
    @BeforeEach
    void setUp() {
        enemy = new Enemy("Test Enemy", 20, 100, 10);
    }

    @Test
    void testInitialization() {
        assertEquals("Test Enemy", enemy.getName());
        assertEquals(100, enemy.getHealth());
        assertEquals(20, enemy.getDamage());
        assertEquals(10, enemy.getDefense());
        assertTrue(enemy.isAlive());
    }

    @ParameterizedTest
    @CsvSource({
        "30, 70",  // Normal damage
        "0, 100",  // No damage
        "150, 0"   // Fatal damage
    })
    void testTakeDamage(int damage, int expectedHealth) {
        enemy.takeDamage(damage);
        assertEquals(expectedHealth, enemy.getHealth());
    }

    @Test
    void testResetHealth() {
        enemy.takeDamage(50);
        assertEquals(50, enemy.getHealth());
        enemy.resetHealth();
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void testDropLoot() {
        String loot = enemy.dropLoot();
        if (loot != null) {
            assertTrue(loot.length() > 0, "Loot string should not be empty when present");
        }
    }

    @Test
    void testGetGoldReward() {
        int gold = enemy.getGoldReward();
        assertTrue(gold >= 0);
    }

    @Test
    void testIsAliveAfterFatalDamage() {
        enemy.takeDamage(200);
        assertFalse(enemy.isAlive());
        assertEquals(0, enemy.getHealth());
    }

    @Test
    void testHeal() {
        enemy.takeDamage(50);
        assertEquals(50, enemy.getHealth(), "Health should be 50 after taking damage");
        enemy.heal(30);
        assertEquals(80, enemy.getHealth(), "Health should be 80 after healing");
    }

    @Test
    void testHealNotExceedingMaxHealth() {
        enemy.takeDamage(20);
        assertEquals(80, enemy.getHealth());
        enemy.heal(30);
        assertEquals(100, enemy.getHealth(), "Health should not exceed max health");
    }

    @Test
    void testAttack() {
        int damage = enemy.attack();
        assertTrue(damage > 0);
        assertTrue(damage <= enemy.getDamage());
    }
}