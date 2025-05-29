package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import java.io.*;
import java.util.Properties;

public class GameSaveManager {
    private static final String SAVE_FILE = "savegame.properties";

    private GameSaveManager() {} // Prevent instantiation

    public static void saveGame(AbstractCharacter player) {
        Properties props = new Properties();
        
        try (FileOutputStream out = new FileOutputStream(SAVE_FILE)) {
            // Save player stats
            props.setProperty("player.name", player.getName());
            props.setProperty("player.health", String.valueOf(player.getHealth()));
            props.setProperty("player.damage", String.valueOf(player.getDamage()));
            props.setProperty("player.defense", String.valueOf(player.getDefense()));
            
            // Save inventory
            props.setProperty("inventory.money", String.valueOf(player.getInventory().getMoney()));
            props.setProperty("inventory.weaponDamage", String.valueOf(player.getInventory().getWeaponDamage()));
            props.setProperty("inventory.armorDefense", String.valueOf(player.getInventory().getArmorDefense()));
            props.setProperty("inventory.forestScroll", String.valueOf(player.getInventory().isForestScroll()));
            props.setProperty("inventory.ancientStone", String.valueOf(player.getInventory().isAncientStone()));
            
            props.store(out, "Game Save Data");
            GameLogger.log("Game saved successfully for player: " + player.getName());
        } catch (IOException e) {
            GameLogger.logError("Failed to save game", e);
            throw new GameException("Failed to save game", e);
        }
    }

    public static void loadGame(AbstractCharacter player) {
        Properties props = new Properties();
        
        try (FileInputStream in = new FileInputStream(SAVE_FILE)) {
            props.load(in);
            
            // Load player stats
            player.setName(props.getProperty("player.name"));
            player.setHealth(Integer.parseInt(props.getProperty("player.health")));
            player.setDamage(Integer.parseInt(props.getProperty("player.damage")));
            player.setDefense(Integer.parseInt(props.getProperty("player.defense")));
            
            // Load inventory
            player.getInventory().setMoney(Integer.parseInt(props.getProperty("inventory.money")));
            player.getInventory().setWeaponDamage(Integer.parseInt(props.getProperty("inventory.weaponDamage")));
            player.getInventory().setArmorDefense(Integer.parseInt(props.getProperty("inventory.armorDefense")));
            player.getInventory().setForestScroll(Boolean.parseBoolean(props.getProperty("inventory.forestScroll")));
            player.getInventory().setAncientStone(Boolean.parseBoolean(props.getProperty("inventory.ancientStone")));
            
            GameLogger.log("Game loaded successfully for player: " + player.getName());
        } catch (IOException | NumberFormatException e) {
            GameLogger.logError("Failed to load game", e);
            throw new GameException("Failed to load game", e);
        }
    }

    public static boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }
} 