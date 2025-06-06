package com.halukkilincer.adventure.characters;

public class Healer extends AbstractCharacter {
    private static final int BASE_DAMAGE = 20;
    private static final int BASE_HEALTH = 120;
    private static final int BASE_DEFENSE = 20;

    public Healer(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Şifacı";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║              💚  ŞİFACI SEÇİLDİ  💚                       ║
               ║ Şifacı müttefiklerinin son umudu olmuştu.                 ║
               ║ Şifalı büyüleriyle yaraları sarıyor,                      ║
               ║ lanetleri yok ediyordu.                                   ║
               ╠═══════════════════════════════════════════════════════════╝
               ║ 🗡️  Saldırı Gücü : %d                                      ║
               ║ ❤️  Can Değeri   : %d                                     ║
               ║ 🛡️  Savunma      : %d                                      ║
               ╚═══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 