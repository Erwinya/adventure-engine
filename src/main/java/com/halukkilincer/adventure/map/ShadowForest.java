package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.VoidMinion;
import com.halukkilincer.adventure.utils.BattleLoc;

public class ShadowForest extends BattleLoc {
    private static final VoidMinion VOID_MINION = new VoidMinion();
    
    public ShadowForest(AbstractCharacter player) {
        super(player, "Gölgeler Ormanı", "🌲", VOID_MINION, "Orman Parşömeni", 3);
    }

    @Override
    public boolean getLocation() throws InterruptedException {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                  GÖLGELER ORMANI                         ║
                ╠══════════════════════════════════════════════════════════╣
                ║ Karanlık ağaçların arasında ilerliyorsun...             ║
                ║ Her adımda gölgeler daha da koyulaşıyor.                ║
                ║ Void Minyonları'nın varlığını hissedebiliyorsun...      ║
                ╚══════════════════════════════════════════════════════════╝
                """);
        
        Thread.sleep(2000);
        return super.getLocation();
    }
} 