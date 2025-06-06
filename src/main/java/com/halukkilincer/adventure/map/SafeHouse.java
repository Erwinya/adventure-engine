package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.NormalLoc;

public class SafeHouse extends NormalLoc {
	public SafeHouse(AbstractCharacter player) {
		super(player, "Güvenli Ev", "🏠");
	}
 
	@Override
	public boolean getLocation() {
		System.out.println("Guvenli eve gidiliyor...");
		try {
			Thread.sleep(2000); // Simulate travel time
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Restore interrupted status
			System.err.println("Güvenli eve giderken bir hata oluştu: " + e.getMessage());
		}
		
		System.out.println("""
				
				╔══════════════════════════════════════════════════════════╗
				║                    GÜVENLİ EV                            ║
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
			System.out.println("✨ Canın tam olarak " + player.getMaxHealth() + "!");
			System.out.println("Burada herhangi bir şey yapmana gerek yok. Anamenüye dönülüyor...");
			try {
				Thread.sleep(2000); // Simulate rest time
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Restore interrupted status
				System.err.println("Dinlenme sırasında bir hata oluştu: " + e.getMessage());
			}
		}
		
		return true;
	}
}
