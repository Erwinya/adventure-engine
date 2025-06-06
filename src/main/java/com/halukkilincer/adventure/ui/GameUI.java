package com.halukkilincer.adventure.ui;

import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static String showMainMenu() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                    ANA MENÜ                              ║
                ╚══════════════════════════════════════════════════════════╝
                
                Gecenin derin sessizliği, kadim topraklarda yankılanıyor.
                Fırtına yaklaşırken, savaşın gölgesi giderek büyüyor.
                Ancak kaderin yazılacağı bu anda, seçim senin ellerinde…

                ╔════════════════════════════════════════════════════════╗
                ║ 1. 🏠 GÜVENLİ EV                                       ║
                ╠════════════════════════════════════════════════════════╣
                ║   Dinlen ve yaralarını iyileştir                       ║
                ║   Evin sıcaklığında güç topla                          ║
                ╠════════════════════════════════════════════════════════╣
                ║ 2. 🛒 GHUA PAZARI                                      ║
                ╠════════════════════════════════════════════════════════╣
                ║   Silah ve zırh satın al                               ║
                ║   Efsanevi ekipmanları keşfet                          ║
                ╠════════════════════════════════════════════════════════╣
                ║ 3. 🌲 GÖLGELER ORMANI                                  ║
                ╠════════════════════════════════════════════════════════╣
                ║   Orman Parşömenini bul                                ║
                ║   Void Lord'un minyonlarıyla savaş                     ║
                ╠════════════════════════════════════════════════════════╣
                ║ 4. 🏔️ KARANLIK MAĞARALAR                                ║
                ╠════════════════════════════════════════════════════════╣
                ║   Kadim Taşı ele geçir                                 ║
                ║   Gölge Canavarlarıyla yüzleş                          ║
                ╠════════════════════════════════════════════════════════╣
                ║ 5. 🌀 BOŞLUK DİYARI KAPISI                             ║
                ╠════════════════════════════════════════════════════════╣
                ║   Void Lord ile son savaş                              ║
                ║   Aetheria'nın kaderini belirle                        ║
                ╠════════════════════════════════════════════════════════╣
                ║ [Q] ÇIKIŞ YAP                                          ║
                ╚════════════════════════════════════════════════════════╝
                """);

        System.out.print("\nSeçiminiz: ");
        return scanner.nextLine().toLowerCase();
    }

    public static String showCharacterSelection() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                 KARAKTER SEÇME MENÜSÜ                    ║
                ╚══════════════════════════════════════════════════════════╝
                
                Bir zamanlar Aetheria adlı kadim topraklarda, dört kahraman,
                dünyanın kaderini değiştirecek bir yolculuğa çıkmaya ant içmişti.

                ╔════════════════════════════════════════════════════════╗
                ║                     [S] SAVAŞÇI                        ║
                ╠════════════════════════════════════════════════════════╣
                ║  Sağlık: 100  |  Savunma: 15  |  Saldırı: 25           ║
                ║  • Demir zırhı ve devasa baltasıyla güçlü              ║
                ║  • Savaş meydanında yankılanan öfkeli kükreyiş         ║
                ╠════════════════════════════════════════════════════════╣
                ║                    [A] SUİKASTÇI                       ║
                ╠════════════════════════════════════════════════════════╣
                ║  Sağlık: 80   |  Savunma: 8   |  Saldırı: 35           ║
                ║  • Gölgelerin ustası, hızlı ve sessiz                  ║
                ║  • Dagger'ları ile ölümcül darbeler                    ║
                ╠════════════════════════════════════════════════════════╣
                ║                     [B] BÜYÜCÜ                         ║
                ╠════════════════════════════════════════════════════════╣
                ║  Sağlık: 65   |  Savunma: 5   |  Saldırı: 40           ║
                ║  • Kadim büyülerin ustası                              ║
                ║  • Ateş fırtınaları ve buz büyüleri                    ║
                ╠════════════════════════════════════════════════════════╣
                ║                     [H] ŞİFACI                         ║
                ╠════════════════════════════════════════════════════════╣
                ║  Sağlık: 120  |  Savunma: 20  |  Saldırı: 20           ║
                ║  • Kutsal ışığın savaşçısı                             ║
                ║  • İyileştirme ve koruma büyüleri                      ║
                ╚════════════════════════════════════════════════════════╝
                """);

        System.out.print("\nKarakterini seç (S/A/B/H): ");
        return scanner.nextLine().toLowerCase();
    }

    public static String getPlayerName() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║           YÜCE AETHERIA TOPRAKLARINA HOŞGELDİN           ║
                ╚══════════════════════════════════════════════════════════╝
                """);
        System.out.print("\nKahramanın adını gir: ");
        return scanner.nextLine();
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showError(String message) {
        System.out.println("❌ " + message);
    }

    public static void close() {
        scanner.close();
    }
} 