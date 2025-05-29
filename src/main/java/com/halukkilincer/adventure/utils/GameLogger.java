package com.halukkilincer.adventure.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameLogger {
    private static final String LOG_FILE = "game.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private GameLogger() {} // Prevent instantiation

    public static void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.println(String.format("[%s] %s", timestamp, message));
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

    public static void logBattle(String playerName, String enemyName, int playerHealth, int enemyHealth) {
        log(String.format("Battle: %s (HP: %d) vs %s (HP: %d)", 
            playerName, playerHealth, enemyName, enemyHealth));
    }

    public static void logPurchase(String playerName, String itemName, int cost) {
        log(String.format("Purchase: %s bought %s for %d gold", 
            playerName, itemName, cost));
    }

    public static void logError(String message, Throwable error) {
        log(String.format("ERROR: %s - %s", message, error.getMessage()));
    }
} 