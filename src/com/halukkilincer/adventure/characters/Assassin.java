package com.halukkilincer.adventure.characters;

public class Assassin extends AbstractCharacter {
    private static final int BASE_DAMAGE = 35;
    private static final int BASE_HEALTH = 80;
    private static final int BASE_DEFENSE = 8;

    public Assassin(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Suikastçı";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║              🗡️  SUİKASTÇI SEÇİLDİ  🗡️                     ║
               ║ Suikastçı sessizliği bir silah gibi kullanıyordu.        ║
               ║ Bir anlık tereddüt bile düşmanına ölüm getirebilirdi.    ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Saldırı Gücü : %d                                     ║
               ║ ❤️  Can Değeri   : %d                                     ║
               ║ 🛡️  Savunma      : %d                                      ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 