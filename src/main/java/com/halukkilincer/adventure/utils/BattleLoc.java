package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;
import com.halukkilincer.adventure.combat.BasicCombatStrategy;
import com.halukkilincer.adventure.combat.CombatResult;
import com.halukkilincer.adventure.interfaces.ICombatStrategy;
import com.halukkilincer.adventure.ui.CombatUI;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
	protected Enemy enemy;
	protected String reward;
	protected int maxEnemyCount;
	protected final Scanner scanner;
	protected final Random random;
	protected final ICombatStrategy combatStrategy;
	protected final CombatUI combatUI;

	public BattleLoc(AbstractCharacter player, String name, String locationEmoji, Enemy enemy, String reward, int maxEnemyCount) {
		super(player, name, locationEmoji);
		this.enemy = enemy;
		this.reward = reward;
		this.maxEnemyCount = maxEnemyCount;
		this.scanner = new Scanner(System.in);
		this.random = new Random();
		this.combatStrategy = new BasicCombatStrategy();
		this.combatUI = new CombatUI();
	}

	@Override
	public boolean getLocation() throws InterruptedException {
		int enemyCount = generateEnemyCount();
		combatUI.displayEnemyEncounter(enemyCount, enemy.getName());
		
		if (shouldFight()) {
			if (handleCombat(enemyCount)) {
				handleVictory();
				return true;
			}
		}
		
		return handleResult();
	}

	private boolean shouldFight() {
		return combatUI.askForFight(scanner);
	}

	private boolean handleResult() {
		if (!player.isAlive()) {
			combatUI.displayDeath();
			return false;
		}
		return true;
	}

	private void handleVictory() {
		combatUI.displayVictory(getName());
		earnReward();
	}

	protected boolean handleCombat(int enemyCount) throws InterruptedException {
		for (int i = 0; i < enemyCount; i++) {
			if (!executeSingleCombat()) {
				return false;
			}
		}
		return true;
	}

	private boolean executeSingleCombat() throws InterruptedException {
		enemy.resetHealth();
		combatUI.displayStats(player, enemy);
		
		while (bothCombatantsAlive()) {
			if (!executeCombatRound()) {
				return false;
			}
		}
		
		return processCombatResult();
	}

	private boolean bothCombatantsAlive() {
		return player.isAlive() && enemy.isAlive();
	}

	private boolean executeCombatRound() throws InterruptedException {
		if (combatUI.askForAction(scanner)) {
			CombatResult result = performCombat();
			combatUI.displayCombatResult(result);
			return true;
		}
		combatUI.displayRetreat();
		return false;
	}

	private CombatResult performCombat() throws InterruptedException {
		int initialPlayerHealth = player.getHealth();
		int initialEnemyHealth = enemy.getHealth();
		
		boolean survived = combatStrategy.executeCombat(player, enemy);
		
		int damageDealt = initialEnemyHealth - enemy.getHealth();
		int damageTaken = initialPlayerHealth - player.getHealth();
		
		if (enemy.getHealth() <= 0) {
			String droppedItem = enemy.dropLoot();
			return new CombatResult(true, damageDealt, damageTaken, enemy.getGoldReward(), droppedItem);
		}
		
		return new CombatResult(survived, damageDealt, damageTaken, 0, null);
	}

	private boolean processCombatResult() {
		if (!enemy.isAlive() && player.isAlive()) {
			collectRewards();
			return true;
		}
		return false;
	}

	private void collectRewards() {
		int goldReward = enemy.getGoldReward();
		player.getInventory().setMoney(player.getInventory().getMoney() + goldReward);
		combatUI.displayGoldReward(goldReward);
		
		String droppedItem = enemy.dropLoot();
		if (droppedItem != null) {
			player.getInventory().addRareItem(droppedItem);
			combatUI.displayItemDrop(droppedItem);
		}
	}

	protected void earnReward() {
		if (reward != null) {
			switch (reward) {
				case "Orman Parşömeni" -> player.getInventory().setForestScroll(true);
				case "Kadim Taş" -> player.getInventory().setAncientStone(true);
				case "Void Kristali" -> player.getInventory().setDungeonKey(true);
			}
			player.getInventory().addRareItem(reward);
			combatUI.displayReward(reward);
		}
	}

	protected int generateEnemyCount() {
		return random.nextInt(maxEnemyCount) + 1;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
}