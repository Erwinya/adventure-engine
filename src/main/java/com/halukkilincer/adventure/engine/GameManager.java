package com.halukkilincer.adventure.engine;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;

public class GameManager {
    private AbstractCharacter player;
    private Location currentLocation;
    private boolean gameRunning;

    public GameManager() {
        this.gameRunning = true;
    }

    public void setPlayer(AbstractCharacter player) {
        this.player = player;
    }

    public AbstractCharacter getPlayer() {
        return player;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void checkGameOver() {
        if (!player.isAlive()) {
            System.out.println("""
                    
                    ╔═════════════════════════════════════════════════════════════════════╗
                    ║                    OYUN SONU                                        ║
                    ╠═════════════════════════════════════════════════════════════════════╣
                    ║ Kahramanımız %s maalesef hayatını kaybetti...                      ║
                    ║ Aetheria'nın kaderi artık karanlığa düşecek.                       ║
                    ║                                                                     ║
                    ║                   OYUN BİTTİ! ☠️                                    ║
                    ╚═════════════════════════════════════════════════════════════════════╝
                    """.formatted(player.getName()));
            gameRunning = false;
        }
    }
} 