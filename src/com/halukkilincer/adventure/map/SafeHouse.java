package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;
import java.util.Scanner;

public class SafeHouse extends Location {
	private final Scanner scanner = new Scanner(System.in);

	public SafeHouse(AbstractCharacter player) {
		super(player, "Güvenli Ev", "🏠");
	}

	@Override
	public boolean getLocation() {
		getPlayer().setHealth(getPlayer().getMaxHealth());
		System.out.println("\n✨ Canınız yenilendi!");
		return true;
	}
}
