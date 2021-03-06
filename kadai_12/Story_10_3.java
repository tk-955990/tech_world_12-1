package kadai_12;

import java.util.Scanner;
import kadai.Story;

public class Story_10_3 {
	public static void main(String[] args) {

		

		// 勇者の生成

		SuperHero h2 = new SuperHero();
		h2.setName("roto");
		h2.setHp     (500);
		h2.setAt      (50);
		h2.setDf      (80);

		System.out.println("誇り高き勇者が今ここに誕生した");
		System.out.println("名前:"   + h2.getName());
		System.out.println("体力:"   + h2.getHp());
		System.out.println("攻撃力:" + h2.getAt());
		System.out.println("防御力:" + h2.getDf());

		// 怪物の生成

		SuperMonster m2 = new SuperMonster();
		m2.setName("kaiju");
		m2.setHp     (1000);
		m2.setAt      (100);
		m2.setDf      (120);
		m2.setP_at     (50);
		m2.setPoison    (5);

		System.out.println("禍々しい怪物がここに誕生した");
		System.out.println("名前:"     + m2.getName());
		System.out.println("体力:"     + m2.getHp());
		System.out.println("攻撃力:"   + m2.getAt());
		System.out.println("防御力:"   + m2.getDf());
		System.out.println("毒攻撃力:" + m2.getP_at());
		System.out.println("独針の数:" + m2.getPoison());

		// 魔法使いの生成

		SuperMagician mg2 = new SuperMagician();
		mg2.setName("medeia");
		mg2.setHp       (500);
		mg2.setAt        (30);
		mg2.setMp        (50);
		mg2.setM_at      (50);
		mg2.setDf       (100);

		System.out.println("魔法使いがここに誕生した");
		System.out.println("名前:"       + mg2.getName());
		System.out.println("体力:"       + mg2.getHp());
		System.out.println("攻撃力:"     + mg2.getAt());
		System.out.println("MP:"         + mg2.getMp());
		System.out.println("攻撃魔法力:" + mg2.getM_at());

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
				System.out.println(((Hero) cha[0]).getHp() + "は死んでいる");
			else {

				// 勇者のターン
				System.out.println("<<   　勇者の作戦は？   >>");
				System.out.println("攻撃:1 防御:2 休憩:3 終了:4");

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
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  を倒した  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else
				System.out.println("勇者のターン終了");
			System.out.println("----------------------------------------");

			if (((Magician) cha[1]).getHp()<= 0)
				System.out.println("魔法使いは死んでる");
			else {

				// 魔法使いのターン
				System.out.println("<<   魔法使いの作戦は？   >>");

				if (((Magician) cha[1]).getHp() >= 20) {
					System.out.println("攻撃:1 攻撃魔法:2 超攻撃魔法:3");
					System.out.println("回復魔法:4 防御:5 休憩:6 終了:7");
				}
				if ((((Magician) cha[1]).getHp()< 20) && (((Magician) cha[1]).getHp()>= 10)) {
					System.out.println("攻撃:1 攻撃魔法:2 回復魔法:4");
					System.out.println(" 防御:5 休憩:6 終了:7");
				}
				if ((((Magician) cha[1]).getHp()< 10) && (((Magician) cha[1]).getHp() >= 5)) {
					System.out.println("攻撃:1 回復魔法:4 防御:5 休憩:6 終了:7");
				}
				if (((Magician) cha[1]).getHp()< 5) {
					System.out.println("攻撃:1 防御:5 休憩:6 終了:7");
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
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  を倒した  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else {
				System.out.println("魔法使いのターン終了");
				System.out.println("----------------------------------------");
			}

			// モンスターのターン
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
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;

				// 魔法使いが死んでいる時

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
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;

				// 勇者が死んでいる時

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
					System.out.println("モンスターのターン終了");
				System.out.println("----------------------------------------");
				continue;
			}
		}
	}
		
	
	public static void status(Charactor cha[], Creature cre[]) {
		System.out.println("【"      + ((Hero) cha[0]).getName() + ":ステータス】");
		System.out.println("体力:"   + ((Hero) cha[0]).getHp());
		System.out.println("攻撃力:" + ((Hero) cha[0]).getAt());
		System.out.println("防御力:" + ((Hero) cha[0]).getDf());

		System.out.println("【"      + ((Magician) cha[1]).getName() + ":ステータス】");
		System.out.println("体力:"   + ((Magician) cha[1]).getHp());
		System.out.println("攻撃力:" + ((Magician) cha[1]).getAt());
		System.out.println("防御力:" + ((Magician) cha[1]).getDf());
		System.out.println("MP:"     + ((Magician) cha[1]).getMp());

		System.out.println("【"        + ((Monster) cre[0]).getName() + ":ステータス】");
		System.out.println("体力:"     + ((Monster) cre[0]).getHp());
		System.out.println("攻撃力:"   + ((Monster) cre[0]).getAt());
		System.out.println("防御力:"   + ((Monster) cre[0]).getDf());
		System.out.println("独針の数:" + ((SuperMonster) cre[0]).getPoison());
	}

	public static void attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  は死んだ  @@@@@@@@@@");
	}
	public static void attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  は死んだ  @@@@@@@@@@");
	}

	public static void p_attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack1(cha);
		}
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  は死んだ  @@@@@@@@@@");
	}

	public static void p_attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack2(cha);
		}
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  は死んだ  @@@@@@@@@@");
	}

}