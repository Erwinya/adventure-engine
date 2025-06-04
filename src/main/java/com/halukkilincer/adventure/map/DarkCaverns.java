package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.ShadowBeast;
import com.halukkilincer.adventure.utils.BattleLoc;

public class DarkCaverns extends BattleLoc {
    private static final ShadowBeast SHADOW_BEAST = new ShadowBeast();
    
    public DarkCaverns(AbstractCharacter player) {
        super(player, "Karanlık Mağaralar", "🏔️", SHADOW_BEAST, "Kadim Taş", 2);
    }
 
    @Override
    public boolean getLocation() throws InterruptedException {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                 KARANLIK MAĞARALAR                       ║
                ╠══════════════════════════════════════════════════════════╣
                ║ Mağaranın derinliklerinden gelen uğultular...           ║
                ║ Karanlıkta parlayan gözler seni izliyor.                ║
                ║ Gölge Canavarları'nın kokusu havada asılı...           ║
                ╚══════════════════════════════════════════════════════════╝
                """);
        
        Thread.sleep(2000);
        return super.getLocation();
    }
} 