package com.halukkilincer.adventure.characters;

import com.halukkilincer.adventure.items.Inventory;

public class Player {

	private int damage, health, defense, firstHealth;
	private String name, charName;
	private Inventory inventory = new Inventory();
	private int initialMoney = 10;
	private int Money = initialMoney;
	
	public void initializeCharacter() throws InterruptedException {
		switch (this.getCharName().toLowerCase()) {
		case "s" -> {
			setStats(25, 100, 15);
			setCharName("Savaşçı");
			System.out.println("\n══════════════════════════════════════════════════════════╗");
			System.out.println("║              ⚔️  SAVAŞÇI SEÇİLDİ  ⚔️                        ║");
			System.out.println("║ Savaşçı baltasını sıkıca kavradı. Gücü, sadece            ║");
			System.out.println("║ kaslarında değil, yüreğindeki sarsılmaz inançtaydı.       ║");
			System.out.println("╠═══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Saldırı Gücü : " + this.damage +"                                     ║");
			System.out.println(  "║ ❤️  Can Değeri   : " + this.health +"                                    ║");
			System.out.println(  "║ 🛡️  Savunma      : " + this.defense+"                                     ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "a" -> {
			setStats(35, 80, 8);
			setCharName("Suikastçı");
			System.out.println("\n═══════════════════════════════════════════════════════════╗");
			System.out.println("║              🗡️  SUİKASTÇI SEÇİLDİ  🗡️                     ║");
			System.out.println("║ Suikastçı sessizliği bir silah gibi kullanıyordu.        ║");
			System.out.println("║ Bir anlık tereddüt bile düşmanına ölüm getirebilirdi.    ║");
			System.out.println("╠══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Saldırı Gücü : " + this.damage +"                                     ║");
			System.out.println(  "║ ❤️  Can Değeri   : " + this.health +"                                     ║");
			System.out.println(  "║ 🛡️  Savunma      : " + this.defense+"                                      ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "b" -> {
			setStats(40, 65, 5);
			setCharName("Büyücü");
			System.out.println("\n═══════════════════════════════════════════════════════════╗");
			System.out.println("║              🔮  BÜYÜCÜ SEÇİLDİ  🔮                       ║");
			System.out.println("║ Büyücü kadim rünleri fısıldayarak ellerinde               ║");
			System.out.println("║ alevler dans ettiriyordu. Gökyüzünü yaracak bir           ║");
			System.out.println("║ güçle, savaşın kaderini değiştirebilirdi.                 ║");
			System.out.println("╠═══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Saldırı Gücü : " + this.damage +"                                     ║");
			System.out.println(  "║ ❤️  Can Değeri   : " + this.health +"                                     ║");
			System.out.println(  "║ 🛡️  Savunma      : " + this.defense+"                                      ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "h" -> {
			setStats(20, 120, 20);
			setCharName("Şifacı");
			System.out.println("\n══════════════════════════════════════════════════════════╗");
			System.out.println("║              💚  ŞİFACI SEÇİLDİ  💚                     ║");
			System.out.println("║ Şifacı müttefiklerinin son umudu olmuştu.               ║");
			System.out.println("║ Şifalı büyüleriyle yaraları sarıyor,                    ║");
			System.out.println("║ lanetleri yok ediyordu.                                 ║");
			System.out.println("╠═════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Saldırı Gücü : " + this.damage +"                                    ║");
			System.out.println(  "║ ❤️  Can Değeri   : " + this.health +"                                   ║");
			System.out.println(  "║ 🛡️  Savunma      : " + this.defense+"                                    ║");
			System.out.println("╚═════════════════════════════════════════════════════════╝");
		}
		case "q" -> {
			System.out.println("\n👋 Oyundan çıkış yapılıyor...");
			Thread.sleep(1500);
			System.exit(0);
		}
		default -> System.out.println("❌ Geçersiz karakter seçimi! Lütfen S, A, B, H veya Q (Çıkış) harflerinden birini seçin.");
		}
		Thread.sleep(3000);
	}

	public int getTotalDamage() {
		return getDamage() + getInventory().getWeaponDamage();
	}
	
	public int getTotalDefense() {
		return getDefense() + getInventory().getArmorDefense();
	}
	
	private void setStats(int damage, int health, int defense) {
		this.damage = damage;
		this.health = health;
		this.defense = defense;
		this.firstHealth = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String selectCharInput) {
		this.charName = selectCharInput;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getFirstHealth() {
		return firstHealth;
	}

	public void setFirstHealth(int firstHealth) {
		this.firstHealth = firstHealth;
	}

	public int getMoneyStart() {
		return initialMoney;
	}

	public void setMoneyStart(int moneyStart) {
		this.initialMoney = moneyStart;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

}
