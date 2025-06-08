package com.halukkilincer.adventure.utils;

import java.util.Random;

public abstract class Obstacle {
	private String monsterName;
	private int monsterDamage,awardCoin,health,spawn;
	public Obstacle(String monsterName, int monsterDamage, int awardCoin, int health, int spawn) {
	
		this.monsterName = monsterName;
		this.monsterDamage = monsterDamage;
		this.awardCoin = awardCoin;
		this.health = health;
		this.spawn = spawn;
	}
	
	public int spawnMonsterCount() {
		
		Random random = new Random();
		return random.nextInt(this.spawn)+1;
		
	}
	
	
	public String getMonsterName() {
		return monsterName;
	}
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	public int getMonsterDamage() {
		return monsterDamage;
	}
	public void setMonsterDamage(int monsterDamage) {
		this.monsterDamage = monsterDamage;
	}
	public int getAwardCoin() {
		return awardCoin;
	}
	public void setAwardCoin(int award) {
		this.awardCoin = award;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getSpawn() {
		return spawn;
	}
	public void setSpawn(int spawn) {
		this.spawn = spawn;
	}
	

}
