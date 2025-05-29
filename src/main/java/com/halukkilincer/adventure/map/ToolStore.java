package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;

import java.util.Scanner;

public class ToolStore extends Location {

    Scanner scanner = new Scanner(System.in);

    public ToolStore(AbstractCharacter player) {
        super(player, "Ghua Pazarı", "🛒");
    }

    @Override
    public boolean getLocation() throws InterruptedException {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    GHUA PAZARI                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║                    MAĞAZA MENÜSÜ                         ║");
            System.out.println("╠══════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. ⚔️  SİLAHLAR                                         ║");
            System.out.println("║ 2. 🛡️  ZIRHLAR                                          ║");
            System.out.println("║ 3. 🔙 ÇIKIŞ YAP                                         ║");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("\n💰 Mevcut Altın: " + player.getInventory().getMoney());

            System.out.print("\nSeçiminiz: ");
            String inputToolChoice = scanner.nextLine();

            switch (inputToolChoice) {
                case "1" -> {
                    printWeapons();
                    buyWeapon();
                }
                case "2" -> {
                    printArmors();
                    buyArmor();
                }
                case "3" -> {
                    System.out.println("\n🔙 Mağazadan çıkılıyor...");
                    showMenu = false;
                }
                default -> System.out.println("\n❌ Geçersiz seçim! Lütfen 1-3 arası bir sayı girin.");
            }
        }
        return true;
    }

    private void printWeapons() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                      SİLAHLAR                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. 🗡️  Demir Kılıç   | Hasar: +2  | Fiyat: 25 Altın     ║");
        System.out.println("║ 2. ⚔️  Çelik Kılıç   | Hasar: +3  | Fiyat: 35 Altın     ║");
        System.out.println("║ 3. 🗡️  Mitril Kılıç  | Hasar: +7  | Fiyat: 45 Altın     ║");
        System.out.println("║ 4. 🔙 GERİ DÖN                                           ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    private void printArmors() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                      ZIRHLAR                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. 🛡️  Hafif Zırh    | Defans: +1 | Fiyat: 15 Altın     ║");
        System.out.println("║ 2. 🛡️  Orta Zırh     | Defans: +3 | Fiyat: 25 Altın     ║");
        System.out.println("║ 3. 🛡️  Ağır Zırh     | Defans: +5 | Fiyat: 40 Altın     ║");
        System.out.println("║ 4. 🔙 GERİ DÖN                                           ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    private void buyWeapon() {
        System.out.print("\nBir silah seçin: ");
        String inputWeaponChoice = scanner.nextLine();

        int damage = 0, price = 0;
        String weaponName = "";

        switch (inputWeaponChoice) {
            case "1" -> {
                damage = 2;
                price = 25;
                weaponName = "Demir Kılıç";
            }
            case "2" -> {
                damage = 3;
                price = 35;
                weaponName = "Çelik Kılıç";
            }
            case "3" -> {
                damage = 7;
                price = 45;
                weaponName = "Mitril Kılıç";
            }
            case "4" -> {
                System.out.println("\n🔙 Silah menüsünden çıkılıyor...");
                return;
            }
            default -> {
                System.out.println("\n❌ Geçersiz silah seçimi!");
                return;
            }
        }

        if (price > player.getInventory().getMoney()) {
            System.out.println("\n❌ Yeterli altınınız yok!");
            return;
        }

        player.getInventory().setMoney(player.getInventory().getMoney() - price);
        player.getInventory().setWeaponDamage(damage);
        System.out.println("\n✨ " + weaponName + " başarıyla satın alındı!");
        System.out.println("💰 Kalan altın: " + player.getInventory().getMoney());
    }

    private void buyArmor() {
        System.out.print("\nBir zırh seçin: ");
        String inputArmorChoice = scanner.nextLine();

        int defense = 0, price = 0;
        String armorName = "";

        switch (inputArmorChoice) {
            case "1" -> {
                defense = 1;
                price = 15;
                armorName = "Hafif Zırh";
            }
            case "2" -> {
                defense = 3;
                price = 25;
                armorName = "Orta Zırh";
            }
            case "3" -> {
                defense = 5;
                price = 40;
                armorName = "Ağır Zırh";
            }
            case "4" -> {
                System.out.println("\n🔙 Zırh menüsünden çıkılıyor...");
                return;
            }
            default -> {
                System.out.println("\n❌ Geçersiz zırh seçimi!");
                return;
            }
        }

        if (price > player.getInventory().getMoney()) {
            System.out.println("\n❌ Yeterli altınınız yok!");
            return;
        }

        player.getInventory().setMoney(player.getInventory().getMoney() - price);
        player.getInventory().setArmorDefense(defense);
        System.out.println("\n✨ " + armorName + " başarıyla satın alındı!");
        System.out.println("💰 Kalan altın: " + player.getInventory().getMoney());
    }
}
