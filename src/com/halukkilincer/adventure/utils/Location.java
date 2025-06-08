package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;

import java.util.Scanner;

public abstract class Location {
	protected AbstractCharacter player;
	protected String name;
	protected String locationEmoji;

	Scanner scanner = new Scanner(System.in);

	public Location(AbstractCharacter player, String name, String locationEmoji) {
		this.player = player;
		this.name = name;
		this.locationEmoji = locationEmoji;
	}

	public abstract boolean getLocation() throws InterruptedException;

	public AbstractCharacter getPlayer() {
		return player;
	}

	public void setPlayer(AbstractCharacter player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationEmoji() {
		return locationEmoji;
	}

	public void setLocationEmoji(String locationEmoji) {
		this.locationEmoji = locationEmoji;
	}
}
