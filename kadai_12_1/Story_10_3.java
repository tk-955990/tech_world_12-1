package kadai_12_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Story_10_3 {
	public static void main(String[] args) {

		// 勇者の生成
		SuperHero      h = new SuperHero    ("roto", 500, 50, 80);
		h.printStatus();
		// 怪物の生成
		SuperMonster   m = new SuperMonster ("kaiju", 1000, 100, 120, 50, 5);
		m.printStatus();
		// 魔法使いの生成
		SuperMagician mg = new SuperMagician("medeia", 500, 30, 100, 50, 100);
		mg.printStatus();
		System.out.println("========= Game Start !! ================");

		battle(h, mg, m);
	}

	public static void battle(Hero h, Magician mg, Monster m) {
		Charactor[] chas = new Charactor[2];
		chas[0] = h;
		chas[1] = mg;

		Creature[] cres  = new Creature[1];
		cres[0] = m;

		Scanner scanner  = new Scanner(System.in);
		while (true) {
			// 勇者のターン
			if(chas[0].getHp()<= 0) {
				System.out.println(chas[0].getName() + "は死んでいる");
			} else {
				System.out.println("<<   　勇者の作戦は？   >>");
				System.out.println("攻撃:1 防御:2 休憩:3 終了:4");

				String commandLine;
				int get_hCommand;

				try {	
					commandLine = scanner.nextLine();
					get_hCommand = Integer.parseInt(commandLine);
				} catch(InputMismatchException e){
					get_hCommand = 0;
				}catch(NumberFormatException e){
					get_hCommand = 0;
				}

				switch (get_hCommand) {
				case 1:
					chas[0].attack(cres[0]);
					break;
				case 2:
					chas[0].defence();
					break;
				case 3:
					chas[0].heal();
					break;
				case 4:
					System.out.println("勇者は様子を見ている");
					break;
				default:
					System.out.println("勇者は踊っている！");
				}

				deadCheck(cres[0]);
				// ステータス表示
				printStatus(chas, cres);
				// 終了判定
				if(endCheck(chas, cres)) {
					break;
				}
			}
			System.out.println("勇者のターン終了");
			System.out.println("----------------------------------------");

			if (((Magician) chas[1]).getHp()<= 0) {
				System.out.println("魔法使いは死んでる");
			}
			else {
				// 魔法使いのターン
				System.out.println("<<   魔法使いの作戦は？   >>");
				System.out.println("攻撃:1 攻撃魔法:2 超攻撃魔法:3");
				System.out.println("回復魔法:4 防御:5 休憩:6 終了:7");

				String commandLine;
				int get_mgCommand;

				try {	
					commandLine = scanner.nextLine();
					get_mgCommand = Integer.parseInt(commandLine);
				} catch(InputMismatchException e){
					get_mgCommand = 0;
				}catch(NumberFormatException e){
					get_mgCommand = 0;
				}

				switch (get_mgCommand) {
				case 1:
					chas[1].attack(cres[0]);
					break;
				case 2:
					((Magician) chas[1]).magic_Attack(cres[0]);
					break;
				case 3:
					((SuperMagician) chas[1]).super_magic_Attack(cres[0]);
					break;
				case 4:
					((Magician) chas[1]).magic_Recovery(chas);
					break;
				case 5:
					chas[1].defence();
					break;
				case 6:
					chas[1].heal();
					break;
				case 7:
					System.out.println("魔法使いは様子を見ている");
					break;
				default:
					System.out.println("魔法使いは踊っている！");
				}
				deadCheck(cres[0]);
				// ステータス表示
				printStatus(chas, cres);
				// 終了判定
				if(endCheck(chas, cres)) {
					break;
				}
			}
			System.out.println("魔法使いのターン終了");
			System.out.println("----------------------------------------");			

			// モンスターのターン
			if ((((Magician) chas[1]).getHp() > 0) && (((Hero) chas[0]).getHp() > 0)) {
				int random = (int) (Math.random() * 5);

				switch (random) {
				case 0:
				case 1:
					cres[0].attack(chas[random % 2]);
					deadCheck(chas[random % 2]);
					break;
				case 2:
				case 3:
					cres[0].attack(chas[random % 2]);
					((SuperMonster) cres[0]).poison_Attack(chas[random % 2]);
					deadCheck(chas[random % 2]);
					break;
				case 4:
					cres[0].defence();
					break;
				}
			}

			// 魔法使いが死んでいる時
			else if( (chas[1].getHp()<= 0) && (chas[0].getHp() > 0) ) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					cres[0].attack(chas[0]);
					break;
				case 1:
					cres[0].attack(chas[0]);
					((SuperMonster) cres[0]).poison_Attack(chas[0]);
					break;
				case 2:
					cres[0].defence();
					break;
				}
	//			printStatus(chas, cres);
				if(endCheck(chas, cres)) {
					break;
				}
				// 勇者が死んでいる時
			}
			else if ( (((Magician) chas[1]).getHp() > 0) && (((Hero) chas[0]).getHp() <= 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					cres[0].attack(chas[1]);
					break;
				case 1:
					cres[0].attack(chas[1]);
					((SuperMonster) cres[0]).poison_Attack(chas[1]);
					break;
				case 2:
					cres[0].defence();
					break;
				}
			}

			printStatus(chas, cres);
			if(endCheck(chas, cres)) {
				break;
			}
			System.out.println("モンスターのターン終了");
			System.out.println("----------------------------------------");
		}
	}

	public static void printStatus(Charactor chas[], Creature cres[]) {
		System.out.println("");
		for(int i = 0; i < chas.length; i++) {
			System.out.println("【"      + chas[i].getName() + ":ステータス】");
			chas[i].printStatus();
		System.out.println("");
		}

		for(int i = 0; i < cres.length; i++) {
			System.out.println("【"      + cres[i].getName() + ":ステータス】");
			cres[i].printStatus();
		System.out.println("");
		}
	}

	public static void deadCheck(Actor act) {
		if (act.getHp() <= 0) {
			System.out.println("@@@@@@@@@@@  " + act.getName() + "  は死んだ  @@@@@@@@@@");
		}
	}

	public static boolean endCheck(Charactor[] chas, Creature[] cres) {
		//全滅判定
		//1キャラでも生きていたら継続
		boolean checkFlg = true;
		for(int i = 0; i < chas.length; i++) {
			if(checkFlg && chas[i].getHp() > 0) {
				checkFlg = false;
				break;
			}
		}
		if(checkFlg) {
			printStatus(chas, cres);
			System.out.println("@@@@@@@@@@@  " + chas[0].getName() + "  達は全滅した・・・  @@@@@@@@@@");
			return checkFlg;
		}
		//殲滅判定
		//1キャラでも生きていたら継続
		checkFlg = true;
		for(int i = 0; i < cres.length; i++) {
			if(checkFlg && cres[i].getHp() > 0) {
				checkFlg = false;
				break;
			}
		}
		if(checkFlg) {
			System.out.println("@@@@@@@@@@@  " + chas[0].getName() + "  達は戦いに勝利した！  @@@@@@@@@@");
			return checkFlg;
		}
		return checkFlg;
	}
}  