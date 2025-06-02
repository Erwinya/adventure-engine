package com.halukkilincer.adventure.items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }
 
    @Test
    void testInitialState() {
        assertFalse(inventory.hasDungeonKey());
        assertFalse(inventory.hasForestScroll());
        assertFalse(inventory.hasAncientStone());
        assertEquals(0, inventory.getMoney());
        assertFalse(inventory.hasWeapon());
        assertFalse(inventory.hasArmor());
        assertEquals(0, inventory.getWeaponDamage());
        assertEquals(0, inventory.getArmorDefense());
        assertTrue(inventory.getRareItems().isEmpty());
    }

    @Test
    void testAddMoney() {
        inventory.addMoney(100);
        assertEquals(100, inventory.getMoney());
        inventory.addMoney(50);
        assertEquals(150, inventory.getMoney());
    }

    @Test
    void testSpendMoney() {
        inventory.addMoney(100);
        assertTrue(inventory.spendMoney(50));
        assertEquals(50, inventory.getMoney());
        assertFalse(inventory.spendMoney(100));
        assertEquals(50, inventory.getMoney());
    }

    @Test
    void testAddRareItem() {
        inventory.addRareItem("Legendary Sword");
        assertTrue(inventory.getRareItems().contains("Legendary Sword"));
        assertEquals(1, inventory.getRareItems().size());
    }

    @Test
    void testEquipWeapon() {
        inventory.equipWeapon("Iron Sword", 10);
        assertTrue(inventory.hasWeapon());
        assertEquals(10, inventory.getWeaponDamage());
    }

    @Test
    void testEquipArmor() {
        inventory.equipArmor("Leather Armor", 5);
        assertTrue(inventory.hasArmor());
        assertEquals(5, inventory.getArmorDefense());
    }

    @Test
    void testUpgradeWeapon() {
        inventory.equipWeapon("Iron Sword", 10);
        inventory.upgradeWeapon("Steel Sword", 20);
        assertEquals(20, inventory.getWeaponDamage());
    }

    @Test
    void testUpgradeArmor() {
        inventory.equipArmor("Leather Armor", 5);
        inventory.upgradeArmor("Chain Mail", 10);
        assertEquals(10, inventory.getArmorDefense());
    }

    @Test
    void testCollectQuestItems() {
        inventory.collectDungeonKey();
        assertTrue(inventory.hasDungeonKey());

        inventory.collectForestScroll();
        assertTrue(inventory.hasForestScroll());

        inventory.collectAncientStone();
        assertTrue(inventory.hasAncientStone());
    }

    @Test
    void testHasAllQuestItems() {
        assertFalse(inventory.hasAllQuestItems());

        inventory.collectDungeonKey();
        inventory.collectForestScroll();
        inventory.collectAncientStone();

        assertTrue(inventory.hasAllQuestItems());
    }
} 