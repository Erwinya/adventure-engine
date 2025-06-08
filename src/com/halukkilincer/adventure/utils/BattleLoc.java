package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
	protected Enemy enemy;
	protected String reward;
	protected int maxEnemyCount;
	protected Scanner scanner = new Scanner(System.in);
	protected Random random = new Random();

	public BattleLoc(AbstractCharacter player, String name, String locationEmoji, Enemy enemy, String reward, int maxEnemyCount) {
		super(player, name, locationEmoji);
		this.enemy = enemy;
		this.reward = reward;
		this.maxEnemyCount = maxEnemyCount;
	}

	@Override
	public boolean getLocation() throws InterruptedException {
		int enemyCount = generateEnemyCount();
		System.out.printf("\n%d adet %s burada!\n", enemyCount, enemy.getName());
		System.out.print("\n<S>avaş veya <K>aç: ");
		String selectCase = scanner.nextLine().toUpperCase();
		
		if (selectCase.equals("S") && combat(enemyCount)) {
			System.out.println("\n" + this.getName() + " bölgesindeki tüm düşmanları yendin!");
			earnReward();
			return true;
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("\n💀 Öldün!");
			return false;
		}
		
		return true;
	}
<<<<<<< HEAD
	
	/*
	public boolean choiceRandomBM() {
    try {
        if (MONSTER_LIST.isEmpty()) {
            System.out.println("Canavar listesi boş!");
            return false;
        }
        
        int randomIndex = RANDOM.nextInt(MONSTER_LIST.size());
        EasyLevelMonster selectedMonster = MONSTER_LIST.get(randomIndex);
        System.out.println("Rastgele seçilen canavar: " + selectedMonster.getMonsterName());
        this.obstacle = selectedMonster;
        return true;
    } catch (Exception e) {
        System.out.println("Canavar seçiminde bir hata oluştu: " + e.getMessage());
        return false;
    }
}
	*/
	public void introBattle () {
		String introBattleStory = "Aetheria'nın Efsane Yolculuğu"
				+ "Bir zamanlar Aetheria topraklarında, kadim kehanetler ve unutulmuş mitler arasında, "
				+ "dörtlü kahraman – Savaşçı, Suikastçı, Büyücü ve Şifacı – kutsal Ebedi Kristal’in gücünü korumak için yola çıktı. "
				+ "Fakat yolculuk, yalnızca dostluk ve cesaretle değil, aynı zamanda her adımda karanlık güçlerin direndiği şaşırtıcı engellerle doluydu."
				+ "İlk durakları, uçurumun kenarında yankılanan korkunç çığlıklarla anılan Abyssal Kâbus’un hüküm sürdüğü derin vadiydi. Kahramanlarımız, "
				+ "bu dehşetin pençesinden sıyrılarak yola devam etti. Gece çöktüğünde, ormanın karanlıklıklarında sinsice adım atan Kara Pençe Kurt’un gölgesi peşlerini bırakmadı."

				+ "Harabelerin küllerinin arasında yükselen Kül Ruhu, geçmişin kayıplarını anlatan sessiz bir şahit gibi belirdi. "
				+ "Dağların sivri zirvelerinde, buz gibi saldırılarla aniden ortaya çıkan Donmuş Kılıç, düşmanlarına acımasızca hükmetti. "
				+ "Sis perdesi gibi yayılan ormanlarda, ansızın beliren Gölge Sürüngeni kahramanlarımızı sürpriz bir saldırıya hazırladı."

				+ "Yolculukları, rüzgârın hızlı adımlarını andıran Fırtına Zağar Geyik ve çevresine korku saçan Kanlı Rüzgâr Şabril ile daha da zorlu hale geldi. "
				+ "Sisli vadilerde, sessiz adımlarla iz süren Sisli Ruh Avcısı’nın tehdidi altında, kahramanlarımız yer altı geçitlerine sığınmak zorunda kaldılar."

				+ "Mağaraların derinliklerinde, unutulmuş dehşetin vücut bulmuş hali Yeraltı Kâbusu ile karşılaştılar; zamanın akışını bozan acı dolu bir mücadele verildi. "
				+ "Öte yandan, kaderin cilvesi gibi gelen Kaderin Çivisi, nihai düşmanlarının üzerine ölümcül darbeler indirebilme gücüyle durumu özetledi."

				+ "Yolculuğun son aşamasında, karanlık sırların çağına şahitlik eden Aetheria'nın Lanetlisi nihai engel olarak ortaya çıktı. "
				+ "Ve sonunda, göklerde dolanan, alev ve duman içinde yükselen Göksel Yıkım Ejderhası ile nihai savaş başladı. "
				+ "Void Lord’un karanlık hizmetkarı olan bu devasa ejderha, kahramanların en zorlu sınavıydı."

				+ "Dörtlü kahraman, her bir canavarı yırtıcı güçleri ve sarsılmaz inançlarıyla alt ederken, Aetheria toprakları adım adım aydınlığa kavuştu. "
				+ "Bu büyük efsane, sadece kutsal kristalin korunmasının değil, aynı zamanda birlik, cesaret ve fedakarlık ile şekillenen bir medeniyetin dirilişinin öyküsüne dönüştü.";

		String MapsStory = "Karanlık Uçurum Hikaye: Uçurumun derinliklerinde, kadim enerjiler ve karanlık güçler iç içe geçmiş. Abyssal Kâbus’un esrarengiz varlığı bu yarığın her köşesini sarmış durumda. "
				+ "Kahramanlar, bu uçurumdan geçerken, yerçekiminin ve acımasız düşman saldırılarının etkisini hissetmek, her adımda hayat ve ölüm arasında ince çizgide yürümek zorundalar.\r\n"
				+ "\r\n"
				+ "Sislerin Gölgeler Ormanı Hikaye: Yoğun sisin perdeleri altında, ağaçların arasında kaybolmuş eski medeniyetlerin izleri kalan bu ormanda, düşman gölgeleri sessizce pusuda bekler. "
				+ "Gölge Sürüngeni ve Sisli Ruh Avcısı’nın sinsice düzenlediği pusu, kahramanların dikkatini sürekli olarak test eder. Ormanın uğursuz atmosferinde, her adım hem keşif hem de hayatta kalma mücadelesine dönüşür.\r\n"
				+ "\r\n"
				+ "Donmuş Yıkım Düzlüğü Hikaye: Aetheria’nın kuzeyinde, sonbaharın bile yetersiz kaldığı aşırı soğuk rüzgarların estiği bu buzla kaplı düzlük, doğanın acımasız yüzünü gözler önüne serer. "
				+ "Donmuş Kılıç’ın efsanevi soğuğu ve buz kristallerinin keskin yüzü arasında, kahramanlar hem düşman canavarlarıyla hem de doğanın yıkıcı gücüyle mücadele etmek zorunda kalırlar. Her adım, ölümcül fırtınaların altında atılan bir meydan okuma gibidir.\r\n"
				+ "\r\n"
				+ "Göksel Kristal Kalesi Hikaye: Gökyüzüne asılı devasa kayaların üzerinde inşa edilmiş bu kutsal kale, Ebedi Kristal’in ve Aetheria’nın umudunun sembolüdür."
				+ "Void Lord’un karanlık hizmetkarları ve Göksel Yıkım Ejderhası’nın pençesi altında, kale son direnişi temsil eder. Kahramanlarımız, bu efsanevi kaledeki nihai savaşta, kutsal ışığın gücüyle karanlığa son vermek için bütün yeteneklerini ortaya koyar. "
				+ "Işık ile karanlık arasındaki bu destansı hesaplaşma, evrenin kaderini nihai olarak belirleyecektir.\r\n"
				+ "\r\n"
				+ "Bu dört savaş haritası, Aetheria’nın dört bir yanında sizi bekleyen benzersiz meydan okumaları ve destansı mücadeleleri simgeliyor. "
				+ "Her biri, kahramanların yükseleceği, fedakarlık yapacağı ve kaderi yeniden yazacağı unutulmaz birer sahne sunuyor.";
=======

	protected boolean combat(int enemyCount) throws InterruptedException {
		for (int i = 0; i < enemyCount; i++) {
			enemy.setHealth(enemy.getMaxHealth());
			playerStats();
			enemyStats();
			
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {
				System.out.print("\n<V>ur veya <K>aç: ");
				String selectCombat = scanner.nextLine().toUpperCase();
				
				if (selectCombat.equals("V")) {
					System.out.println("\nSen vurdun!");
					enemy.takeDamage(player.attack());
					Thread.sleep(1000);
					
					if (enemy.getHealth() > 0) {
						System.out.println("\nCanavar sana vurdu!");
						player.takeDamage(enemy.attack());
						Thread.sleep(1000);
					}
				} else {
					System.out.println("\n🏃 Savaştan kaçtın!");
					return false;
				}
			}
			
			if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("\n🎯 Düşmanı yendin!");
				player.getInventory().setMoney(player.getInventory().getMoney() + enemy.getGold());
				System.out.println("💰 " + enemy.getGold() + " altın kazandın!");
			} else {
				return false;
			}
		}
		return true;
	}

	protected void earnReward() {
		if (reward.equals("Orman Parşömeni")) {
			player.getInventory().setForestScroll(true);
			player.getInventory().addRareItem("Orman Parşömeni");
		} else if (reward.equals("Kadim Taş")) {
			player.getInventory().setAncientStone(true);
			player.getInventory().addRareItem("Kadim Taş");
		} else if (reward.equals("Void Kristali")) {
			player.getInventory().setDungeonKey(true);
			player.getInventory().addRareItem("Void Kristali");
		}
	}

	protected void playerStats() {
		System.out.println("\n══════════ Oyuncu Değerleri ══════════");
		System.out.println("❤️ Can: " + player.getHealth());
		System.out.println("🗡️ Hasar: " + player.getDamage());
		System.out.println("🛡️ Zırh: " + player.getDefense());
		System.out.println("💰 Para: " + player.getInventory().getMoney());
	}

	protected void enemyStats() {
		System.out.println("\n══════════ " + enemy.getName() + " Değerleri ══════════");
		System.out.println("❤️ Can: " + enemy.getHealth());
		System.out.println("⚔️ Hasar: " + enemy.getDamage());
		System.out.println("🏆 Ödül: " + enemy.getGold() + " Altın");
	}

	protected int generateEnemyCount() {
		return (int) (Math.random() * maxEnemyCount) + 1;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
>>>>>>> b4e5e80 (Refactor and reorganize game architecture)
	}
}