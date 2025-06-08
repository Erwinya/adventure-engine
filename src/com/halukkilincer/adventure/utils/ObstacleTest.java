package com.halukkilincer.adventure.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObstacleTest {

    /**
     * ObstacleTest is a test class for the Obstacle class, specifically focusing on testing
     * the spawnMonsterCount method. This method generates a random number between 1 and the
     * spawn value of the obstacle, where the spawn value is defined during object creation.
     * <p>
     * These test cases validate the correct behavior of spawnMonsterCount by ensuring the
     * generated number falls in the expected range for given inputs.
     */

    abstract class TestObstacle extends Obstacle {
        public TestObstacle(String monsterName, int monsterDamage, int awardCoin, int health, int spawn) {
            super(monsterName, monsterDamage, awardCoin, health, spawn);
        }
    }

    @Test
    void testSpawnMonsterCountWithinRange() {
        // Arrange
        int spawnLimit = 5;
        Obstacle obstacle = new TestObstacle("TestMonster", 10, 50, 100, spawnLimit) {
        };

        // Act
        int monsterCount = obstacle.spawnMonsterCount();

        // Assert
        assertTrue(monsterCount >= 1 && monsterCount <= spawnLimit, "The monster count should be between 1 and the spawn limit.");
    }

    @Test
    void testSpawnMonsterCountMinimumValueIsOne() {
        // Arrange
        int spawnLimit = 1;
        Obstacle obstacle = new TestObstacle("TestMonster", 10, 50, 100, spawnLimit) {
        };

        // Act
        int monsterCount = obstacle.spawnMonsterCount();

        // Assert
        assertTrue(monsterCount == 1, "The spawn count should always be 1 when spawn limit is 1.");
    }

    @Test
    void testSpawnMonsterCountLargeSpawnLimit() {
        // Arrange
        int spawnLimit = 100;
        Obstacle obstacle = new TestObstacle("TestMonster", 10, 50, 100, spawnLimit) {
        };

        // Act
        int monsterCount = obstacle.spawnMonsterCount();

        // Assert
        assertTrue(monsterCount >= 1 && monsterCount <= spawnLimit, "The monster count should be between 1 and the spawn limit for large spawn values.");
    }
}