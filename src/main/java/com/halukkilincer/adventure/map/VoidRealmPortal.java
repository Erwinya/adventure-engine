package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;
import com.halukkilincer.adventure.utils.BattleLoc;

public class VoidRealmPortal extends BattleLoc {
    private static final Enemy VOID_LORD = new Enemy("Void Lord", 25, 250, 100);
    private boolean hasWon = false;
    
    public VoidRealmPortal(AbstractCharacter player) {
        super(player, "Boşluk Diyarı Kapısı", "🌀", VOID_LORD, "Void Kristali", 1);
    }
 
    @Override
    public boolean getLocation() throws InterruptedException {
        if (!player.getInventory().isForestScroll() || !player.getInventory().isAncientStone()) {
            System.out.println("""
                    
                    ╔══════════════════════════════════════════════════════════╗
                    ║              ⚠️  ERİŞİM ENGELLENDİ  ⚠️                     ║
                    ╠══════════════════════════════════════════════════════════╣
                    ║ Boşluk Diyarı'nın kapısına ulaştın, ancak kapı mühürlü!  ║
                    ║ Önce diğer bölgelerdeki görevleri tamamlamalısın:        ║
                    ║ • Orman Parşömeni                                        ║
                    ║ • Kadim Taş                                              ║
                    ╚══════════════════════════════════════════════════════════╝
                    """);
            return true;
        }
        
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                BOŞLUK DİYARI KAPISI                      ║
                ╠══════════════════════════════════════════════════════════╣
                ║ Kapıdan sızan karanlık enerji dalgaları etrafı sarıyor. ║
                ║ İçeride seni Void Lord bekliyor...                       ║
                ║ Aetheria'nın kaderi senin ellerinde!                     ║
                ╚══════════════════════════════════════════════════════════╝
                """);
        
        Thread.sleep(2000);
        boolean battleResult = super.getLocation();
        
        if (battleResult && enemy.getHealth() <= 0) {
            System.out.println("""
                    
                    ╔══════════════════════════════════════════════════════════╗
                    ║                    ✨ ZAFER! ✨                          ║
                    ╠══════════════════════════════════════════════════════════╣
                    ║ TEBRİKLER! VOID LORD'U YENDİN!                          ║
                    ║ Aetheria kurtuldu! Kadim topraklar huzura kavuştu.      ║
                    ║ Senin kahramanlığın nesiller boyu anlatılacak.          ║
                    ╚══════════════════════════════════════════════════════════╝
                    """);
            Thread.sleep(5000);
            System.exit(0);
        }
        
        return true;
    }
} 