package com.halukkilincer.adventure.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private boolean dungeonKey;
	private boolean forestScroll;
	private boolean ancientStone;
	private int money;
	private List<String> rareItems;
	private boolean hasWeapon;
	private boolean hasArmor;
	private int weaponDamage;
	private int armorDefense;

	public Inventory() {
		this.dungeonKey = false;
		this.forestScroll = false;
		this.ancientStone = false;
		this.money = 0; // Set starting money to 0 for test compatibility
		this.rareItems = new ArrayList<>();
		this.hasWeapon = false;
		this.hasArmor = false;
		this.weaponDamage = 0;
		this.armorDefense = 0;
	}

	public boolean isDungeonKey() {
		return dungeonKey;
	}

	public void setDungeonKey(boolean dungeonKey) {
		this.dungeonKey = dungeonKey;
	}
	
	public boolean isForestScroll() {
		return forestScroll;
	}

	public void setForestScroll(boolean forestScroll) {
		this.forestScroll = forestScroll;
	}

	public boolean isAncientStone() {
		return ancientStone;
	}

	public void setAncientStone(boolean ancientStone) {
		this.ancientStone = ancientStone;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addRareItem(String item) {
		if (item != null && !rareItems.contains(item)) {
			rareItems.add(item);
			System.out.println("\nNADİR EŞYA BULDUN: " + item + "!");
			
			if (item.equals("Kadim Taş")) {
				System.out.println("Bu antik taş, eski bir medeniyetin sırlarını barındırıyor...");
			} else if (item.equals("Orman Parşömeni")) {
				System.out.println("Bu parşömende kadim ormanların gizli bilgelikleri yazılı...");
			}
		}
	}

	public List<String> getRareItems() {
		return rareItems;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
		this.hasWeapon = true;
	}

	public int getArmorDefense() {
		return armorDefense;
	}

	public void setArmorDefense(int armorDefense) {
		this.armorDefense = armorDefense;
		this.hasArmor = true;
	}

	public boolean hasDungeonKey() {
		return dungeonKey;
	}

	public boolean hasForestScroll() {
		return forestScroll;
	}

	public boolean hasAncientStone() {
		return ancientStone;
	}

	public boolean hasWeapon() {
		return hasWeapon;
	}

	public boolean hasArmor() {
		return hasArmor;
	}

	public void addMoney(int amount) {
		this.money += amount;
	}

	public boolean spendMoney(int amount) {
		if (money >= amount) {
			money -= amount;
			return true;
		}
		return false;
	}

	public void equipWeapon(String weaponName, int damage) {
		this.weaponDamage = damage;
		this.hasWeapon = true;
	}

	public void equipArmor(String armorName, int defense) {
		this.armorDefense = defense;
		this.hasArmor = true;
	}

	public void upgradeWeapon(String weaponName, int damage) {
		this.weaponDamage = damage;
	}

	public void upgradeArmor(String armorName, int defense) {
		this.armorDefense = defense;
	}

	public void collectDungeonKey() {
		this.dungeonKey = true;
	}

	public void collectForestScroll() {
		this.forestScroll = true;
	}

	public void collectAncientStone() {
		this.ancientStone = true;
	}

	public boolean hasAllQuestItems() {
		return dungeonKey && forestScroll && ancientStone;
	}
}
