package com.halukkilincer.adventure.combat;

public class CombatResult {
    private final boolean victory;
    private final int damageDealt;
    private final int damageTaken;
    private final int goldEarned;
    private final String itemDropped;

    public CombatResult(boolean victory, int damageDealt, int damageTaken, int goldEarned, String itemDropped) {
        this.victory = victory;
        this.damageDealt = damageDealt;
        this.damageTaken = damageTaken;
        this.goldEarned = goldEarned;
        this.itemDropped = itemDropped;
    }

    public boolean isVictory() {
        return victory;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public String getItemDropped() {
        return itemDropped;
    }
} 