package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;

public abstract class NormalLoc extends Location {

<<<<<<< HEAD
	public NormalLoc(Player player, String name) {
		super(player);
		this.setName(name);
	}

	public boolean getLocation() throws InterruptedException {
=======
	public NormalLoc(AbstractCharacter player, String name, String locationEmoji) {
		super(player, name, locationEmoji);
	}

	@Override
	public boolean getLocation() {
>>>>>>> b4e5e80 (Refactor and reorganize game architecture)
		return true;
	}

}
