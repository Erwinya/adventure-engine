package com.halukkilincer.adventure.characters;

public class Warrior extends AbstractCharacter {
    private static final int BASE_DAMAGE = 25;
    private static final int BASE_HEALTH = 100;
    private static final int BASE_DEFENSE = 15;

    public Warrior(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Savaşçı";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║              ⚔️  SAVAŞÇI SEÇİLDİ  ⚔️                        ║
               ║ Savaşçı baltasını sıkıca kavradı. Gücü, sadece            ║
               ║ kaslarında değil, yüreğindeki sarsılmaz inançtaydı.       ║
               ╠═══════════════════════════════════════════════════════════╝
               ║ 🗡️  Saldırı Gücü : %d                                      ║
               ║ ❤️  Can Değeri   : %d                                     ║
               ║ 🛡️  Savunma      : %d                                      ║
               ╚═══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 