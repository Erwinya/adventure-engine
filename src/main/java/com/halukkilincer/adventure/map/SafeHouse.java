package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.NormalLoc;

public class SafeHouse extends NormalLoc {
	public SafeHouse(AbstractCharacter player) {
		super(player, "Güvenli Ev", "🏠");
	}
 
	@Override
	public boolean getLocation() {
		System.out.println("""
				
				╔══════════════════════════════════════════════════════════╗
				║                    GÜVENLİ EV                           ║
				╚══════════════════════════════════════════════════════════╝
				""");
		
		System.out.println("\nGüvenli eve hoşgeldin " + player.getName() + "!");
		System.out.println("Burada yaralarını sarabilir ve dinlenebilirsin.");
		
		if (player.getHealth() < player.getMaxHealth()) {
			int healAmount = player.getMaxHealth() - player.getHealth();
			player.heal(healAmount);
			System.out.println("\n✨ " + healAmount + " can yenilendi!");
		} else {
			System.out.println("\n✨ Zaten sağlıklısın, iyileşmeye ihtiyacın yok!");
		}
		
		return true;
	}
}
