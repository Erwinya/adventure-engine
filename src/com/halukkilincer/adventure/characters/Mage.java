package com.halukkilincer.adventure.characters;

public class Mage extends AbstractCharacter {
    private static final int BASE_DAMAGE = 40;
    private static final int BASE_HEALTH = 65;
    private static final int BASE_DEFENSE = 5;

    public Mage(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Büyücü";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║              🔮  BÜYÜCÜ SEÇİLDİ  🔮                      ║
               ║ Büyücü kadim rünleri fısıldayarak ellerinde              ║
               ║ alevler dans ettiriyordu. Gökyüzünü yaracak bir          ║
               ║ güçle, savaşın kaderini değiştirebilirdi.                ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Saldırı Gücü : %d                                     ║
               ║ ❤️  Can Değeri   : %d                                     ║
               ║ 🛡️  Savunma      : %d                                      ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 