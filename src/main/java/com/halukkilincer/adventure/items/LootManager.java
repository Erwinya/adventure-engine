package com.halukkilincer.adventure.items;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class LootManager {
    private static final Random random = new Random();
    private static final Map<String, LootTable> lootTables = new HashMap<>();

    static {
        // Void Lord loot table
        lootTables.put("Void Lord", new LootTable()
            .addItem("Kadim Taş", 2)  // %2 şans
        );

        // Shadow Beast loot table
        lootTables.put("Shadow Beast", new LootTable()
            .addItem("Orman Parşömeni", 3)  // %3 şans
        );

        // Void Minion loot table
        lootTables.put("Void Minion", new LootTable()
            .addItem("Void Kristali", 1)  // %1 şans
        );
    }

    private static class LootTable {
        private final Map<String, Integer> items = new HashMap<>();

        public LootTable addItem(String item, int dropChance) {
            items.put(item, dropChance);
            return this;
        }

        public String rollLoot() {
            int roll = random.nextInt(100);
            int currentThreshold = 0;

            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                currentThreshold += entry.getValue();
                if (roll < currentThreshold) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }

    public static String rollForLoot(String enemyType) {
        LootTable table = lootTables.get(enemyType);
        return table != null ? table.rollLoot() : null;
    }
} 