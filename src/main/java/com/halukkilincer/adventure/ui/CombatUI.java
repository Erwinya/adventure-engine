package com.halukkilincer.adventure.ui;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;
import com.halukkilincer.adventure.combat.CombatResult;

import java.util.Scanner;

public class CombatUI {
    public void displayEnemyEncounter(int count, String enemyName) {
        System.out.printf("\n%d adet %s burada!\n", count, enemyName);
    }

    public boolean askForFight(Scanner scanner) {
        System.out.print("\n<S>avaş veya <K>aç: ");
        String choice = scanner.nextLine().toUpperCase();
        return choice.equals("S");
    }

    public boolean askForAction(Scanner scanner) {
        System.out.print("\n<V>ur veya <K>aç: ");
        String choice = scanner.nextLine().toUpperCase();
        return choice.equals("V");
    }

    public void displayDeath() {
        System.out.println("\n💀 Öldün!");
    }

    public void displayRetreat() {
        System.out.println("\n🏃 Savaştan kaçtın!");
    }

    public void displayVictory(String locationName) {
        System.out.println("\n" + locationName + " bölgesindeki tüm düşmanları yendin!");
    }

    public void displayStats(AbstractCharacter player, Enemy enemy) {
        displayPlayerStats(player);
        displayEnemyStats(enemy);
    }

    public void displayCombatResult(CombatResult result) {
        if (result.isVictory()) {
            System.out.println("\n🎯 Saldırı başarılı!");
            System.out.println("🗡️ " + result.getDamageDealt() + " hasar verdin!");
            if (result.getDamageTaken() > 0) {
                System.out.println("⚔️ " + result.getDamageTaken() + " hasar aldın!");
            }
        } else {
            System.out.println("\n⚔️ " + result.getDamageTaken() + " hasar aldın!");
        }
    }

    public void displayGoldReward(int gold) {
        System.out.println("💰 " + gold + " altın kazandın!");
    }

    public void displayItemDrop(String item) {
        System.out.println("\nNADİR EŞYA BULDUN: " + item + "!");
        switch (item) {
            case "Kadim Taş" -> System.out.println("Bu antik taş, eski bir medeniyetin sırlarını barındırıyor...");
            case "Orman Parşömeni" -> System.out.println("Bu parşömende kadim ormanların gizli bilgelikleri yazılı...");
            case "Void Kristali" -> System.out.println("Bu kristal, boşluğun karanlık enerjisiyle dolup taşıyor...");
        }
    }

    public void displayReward(String reward) {
        System.out.println("\nÖDÜL KAZANDIN: " + reward + "!");
    }

    private void displayPlayerStats(AbstractCharacter player) {
        System.out.println("\n══════════ Oyuncu Değerleri ══════════");
        System.out.println("❤️ Can: " + player.getHealth());
        System.out.println("🗡️ Hasar: " + player.getDamage());
        System.out.println("🛡️ Zırh: " + player.getDefense());
        System.out.println("💰 Para: " + player.getInventory().getMoney());
    }

    private void displayEnemyStats(Enemy enemy) {
        System.out.println("\n══════════ " + enemy.getName() + " Değerleri ══════════");
        System.out.println("❤️ Can: " + enemy.getHealth());
        System.out.println("⚔️ Hasar: " + enemy.getDamage());
        System.out.println("🏆 Ödül: " + enemy.getGoldReward() + " Altın");
    }
} 