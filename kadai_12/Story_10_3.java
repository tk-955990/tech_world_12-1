package kadai_12;

import java.util.Scanner;
import kadai.Story;

public class Story_10_3 {
	public static void main(String[] args) {

		

		// —EÒ‚Ì¶¬

		SuperHero h2 = new SuperHero();
		h2.setName("roto");
		h2.setHp     (500);
		h2.setAt      (50);
		h2.setDf      (80);

		System.out.println("ŒÖ‚è‚‚«—EÒ‚ª¡‚±‚±‚É’a¶‚µ‚½");
		System.out.println("–¼‘O:"   + h2.getName());
		System.out.println("‘Ì—Í:"   + h2.getHp());
		System.out.println("UŒ‚—Í:" + h2.getAt());
		System.out.println("–hŒä—Í:" + h2.getDf());

		// ‰ö•¨‚Ì¶¬

		SuperMonster m2 = new SuperMonster();
		m2.setName("kaiju");
		m2.setHp     (1000);
		m2.setAt      (100);
		m2.setDf      (120);
		m2.setP_at     (50);
		m2.setPoison    (5);

		System.out.println("‰ĞX‚µ‚¢‰ö•¨‚ª‚±‚±‚É’a¶‚µ‚½");
		System.out.println("–¼‘O:"     + m2.getName());
		System.out.println("‘Ì—Í:"     + m2.getHp());
		System.out.println("UŒ‚—Í:"   + m2.getAt());
		System.out.println("–hŒä—Í:"   + m2.getDf());
		System.out.println("“ÅUŒ‚—Í:" + m2.getP_at());
		System.out.println("“Æj‚Ì”:" + m2.getPoison());

		// –‚–@g‚¢‚Ì¶¬

		SuperMagician mg2 = new SuperMagician();
		mg2.setName("medeia");
		mg2.setHp       (500);
		mg2.setAt        (30);
		mg2.setMp        (50);
		mg2.setM_at      (50);
		mg2.setDf       (100);

		System.out.println("–‚–@g‚¢‚ª‚±‚±‚É’a¶‚µ‚½");
		System.out.println("–¼‘O:"       + mg2.getName());
		System.out.println("‘Ì—Í:"       + mg2.getHp());
		System.out.println("UŒ‚—Í:"     + mg2.getAt());
		System.out.println("MP:"         + mg2.getMp());
		System.out.println("UŒ‚–‚–@—Í:" + mg2.getM_at());

		System.out.println("========= Game Start !! ================");
		
	    battle(h2,mg2,m2);	
	}
	
	public static void battle(SuperHero h2, SuperMagician mg2, SuperMonster m2) {
		Charactor[] cha = new Charactor[2];
		cha[0] = new Hero();
		cha[1] = new Magician();

		Creature[] cre = new Creature[1];
		cre[0] = new Monster();
		
		
		boolean b1 = (((Hero) cha[0]).getHp() <= 0);
		boolean b2 = (((Magician) cha[1]).getHp() <= 0);
		boolean b3 = (((Monster) cre[0]).getHp() <= 0);
		b1 = true;
		b2 = true;
		b3 = true;

		while ((b1 && b2) || b3) {

			if ( ((Hero) cha[0]).getHp()<= 0)
				System.out.println(((Hero) cha[0]).getHp() + "‚Í€‚ñ‚Å‚¢‚é");
			else {

				// —EÒ‚Ìƒ^[ƒ“
				System.out.println("<<   @—EÒ‚Ììí‚ÍH   >>");
				System.out.println("UŒ‚:1 –hŒä:2 ‹xŒe:3 I—¹:4");

				int get_hCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_hCommand) {
				case 1:
					cha[0].attack();
					((Monster) cre[0]).setHp(((Monster) cre[0]).getHp() - (((Hero) cha[0]).getHp()) * 2);
					break;
				case 2:
					cha[0].defence();
					break;
				case 3:
					((Hero) cha[0]).heal();
					break;
				case 4:
				}
				status(cha, cre);
			}

			if (((Magician) cha[1]).getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  ‚ğ“|‚µ‚½  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else
				System.out.println("—EÒ‚Ìƒ^[ƒ“I—¹");
			System.out.println("----------------------------------------");

			if (((Magician) cha[1]).getHp()<= 0)
				System.out.println("–‚–@g‚¢‚Í€‚ñ‚Å‚é");
			else {

				// –‚–@g‚¢‚Ìƒ^[ƒ“
				System.out.println("<<   –‚–@g‚¢‚Ììí‚ÍH   >>");

				if (((Magician) cha[1]).getHp() >= 20) {
					System.out.println("UŒ‚:1 UŒ‚–‚–@:2 ’´UŒ‚–‚–@:3");
					System.out.println("‰ñ•œ–‚–@:4 –hŒä:5 ‹xŒe:6 I—¹:7");
				}
				if ((((Magician) cha[1]).getHp()< 20) && (((Magician) cha[1]).getHp()>= 10)) {
					System.out.println("UŒ‚:1 UŒ‚–‚–@:2 ‰ñ•œ–‚–@:4");
					System.out.println(" –hŒä:5 ‹xŒe:6 I—¹:7");
				}
				if ((((Magician) cha[1]).getHp()< 10) && (((Magician) cha[1]).getHp() >= 5)) {
					System.out.println("UŒ‚:1 ‰ñ•œ–‚–@:4 –hŒä:5 ‹xŒe:6 I—¹:7");
				}
				if (((Magician) cha[1]).getHp()< 5) {
					System.out.println("UŒ‚:1 –hŒä:5 ‹xŒe:6 I—¹:7");
				}

				int get_mgCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_mgCommand) {
				case 1:
					cha[1].attack();
					((Monster) cre[0]).setHp(((Monster) cre[0]).getHp() - ((Magician) cha[1]).getAt());
					break;
				case 2:
					((Magician) cha[1]).magic_Attack();
					((Monster) cre[0]).setHp(((Monster) cre[0]).getHp() - ((Magician) cha[1]).getM_at());
					break;
				case 3:
					((SuperMagician) cha[1]).super_magic_Attack();
					((Monster) cre[0]).setHp(((Monster) cre[0]).getHp() - (((Magician) cha[1]).getM_at()) * 2);
					break;
				case 4:
					((Magician) cha[1]).magic_Recovery();
					break;
				case 5:
					cha[1].defence();
					break;
				case 6:
					((Magician) cha[1]).heal();
					break;
				case 7:
					break;

				}
				status(cha, cre);
			}
			if (((Monster) cre[0]).getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  ‚ğ“|‚µ‚½  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else {
				System.out.println("–‚–@g‚¢‚Ìƒ^[ƒ“I—¹");
				System.out.println("----------------------------------------");
			}

			// ƒ‚ƒ“ƒXƒ^[‚Ìƒ^[ƒ“
			if ((((Magician) cha[1]).getHp() > 0) && (((Hero) cha[0]).getHp() > 0)) {
				int random = (int) (Math.random() * 5);
				switch (random) {
				case 0:
					attack_h2(cha,cre);
					break;
				case 1:
					attack_mg2(cha, cre);
					break;
				case 2:
					p_attack_h2(cha,cre);
					break;
				case 3:
					p_attack_mg2(cha,cre);
					break;
				case 4:
					cre[0].defence();
					break;
				}
				status(cha, cre);
				if ((((Magician) cha[1]).getHp()<= 0) && (((Hero) cha[0]).getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("ƒ‚ƒ“ƒXƒ^[‚Ìƒ^[ƒ“I—¹");
				System.out.println("----------------------------------------");
				continue;

				// –‚–@g‚¢‚ª€‚ñ‚Å‚¢‚é

			}
			if ( (((Magician) cha[1]).getHp()<= 0) && (((Hero) cha[0]).getHp() > 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_h2(cha,cre);
					break;
				case 1:
					p_attack_h2(cha,cre);
					break;
				case 2:
					cre[0].defence();
					break;
				}
				status(cha,cre);
				if ((((Magician) cha[1]).getHp() <= 0) && (((Hero) cha[0]).getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("ƒ‚ƒ“ƒXƒ^[‚Ìƒ^[ƒ“I—¹");
				System.out.println("----------------------------------------");
				continue;

				// —EÒ‚ª€‚ñ‚Å‚¢‚é

			}
			if ( (((Magician) cha[1]).getHp() > 0) && (((Hero) cha[0]).getHp() <= 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_mg2(cha,cre);
					break;
				case 1:
					p_attack_mg2(cha,cre);
					break;
				case 2:
					cre[0].defence();
					break;
				}
				status(cha,cre);
				if ( (((Magician) cha[1]).getHp() <= 0) && (((Hero) cha[0]).getHp() <=0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("ƒ‚ƒ“ƒXƒ^[‚Ìƒ^[ƒ“I—¹");
				System.out.println("----------------------------------------");
				continue;
			}
		}
	}
		
	
	public static void status(Charactor cha[], Creature cre[]) {
		System.out.println("y"      + ((Hero) cha[0]).getName() + ":ƒXƒe[ƒ^ƒXz");
		System.out.println("‘Ì—Í:"   + ((Hero) cha[0]).getHp());
		System.out.println("UŒ‚—Í:" + ((Hero) cha[0]).getAt());
		System.out.println("–hŒä—Í:" + ((Hero) cha[0]).getDf());

		System.out.println("y"      + ((Magician) cha[1]).getName() + ":ƒXƒe[ƒ^ƒXz");
		System.out.println("‘Ì—Í:"   + ((Magician) cha[1]).getHp());
		System.out.println("UŒ‚—Í:" + ((Magician) cha[1]).getAt());
		System.out.println("–hŒä—Í:" + ((Magician) cha[1]).getDf());
		System.out.println("MP:"     + ((Magician) cha[1]).getMp());

		System.out.println("y"        + ((Monster) cre[0]).getName() + ":ƒXƒe[ƒ^ƒXz");
		System.out.println("‘Ì—Í:"     + ((Monster) cre[0]).getHp());
		System.out.println("UŒ‚—Í:"   + ((Monster) cre[0]).getAt());
		System.out.println("–hŒä—Í:"   + ((Monster) cre[0]).getDf());
		System.out.println("“Æj‚Ì”:" + ((SuperMonster) cre[0]).getPoison());
	}

	public static void attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  ‚Í€‚ñ‚¾  @@@@@@@@@@");
	}
	public static void attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  ‚Í€‚ñ‚¾  @@@@@@@@@@");
	}

	public static void p_attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack1(cha);
		}
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  ‚Í€‚ñ‚¾  @@@@@@@@@@");
	}

	public static void p_attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack2(cha);
		}
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  ‚Í€‚ñ‚¾  @@@@@@@@@@");
	}

}