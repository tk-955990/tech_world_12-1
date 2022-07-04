package kadai_12;

import java.util.Scanner;
import kadai.Story;

public class Story_10_3 {
	public static void main(String[] args) {

		

		// �E�҂̐���

		SuperHero h2 = new SuperHero();
		h2.setName("roto");
		h2.setHp     (500);
		h2.setAt      (50);
		h2.setDf      (80);

		System.out.println("�ւ荂���E�҂��������ɒa������");
		System.out.println("���O:"   + h2.getName());
		System.out.println("�̗�:"   + h2.getHp());
		System.out.println("�U����:" + h2.getAt());
		System.out.println("�h���:" + h2.getDf());

		// �����̐���

		SuperMonster m2 = new SuperMonster();
		m2.setName("kaiju");
		m2.setHp     (1000);
		m2.setAt      (100);
		m2.setDf      (120);
		m2.setP_at     (50);
		m2.setPoison    (5);

		System.out.println("�ЁX���������������ɒa������");
		System.out.println("���O:"     + m2.getName());
		System.out.println("�̗�:"     + m2.getHp());
		System.out.println("�U����:"   + m2.getAt());
		System.out.println("�h���:"   + m2.getDf());
		System.out.println("�ōU����:" + m2.getP_at());
		System.out.println("�Ɛj�̐�:" + m2.getPoison());

		// ���@�g���̐���

		SuperMagician mg2 = new SuperMagician();
		mg2.setName("medeia");
		mg2.setHp       (500);
		mg2.setAt        (30);
		mg2.setMp        (50);
		mg2.setM_at      (50);
		mg2.setDf       (100);

		System.out.println("���@�g���������ɒa������");
		System.out.println("���O:"       + mg2.getName());
		System.out.println("�̗�:"       + mg2.getHp());
		System.out.println("�U����:"     + mg2.getAt());
		System.out.println("MP:"         + mg2.getMp());
		System.out.println("�U�����@��:" + mg2.getM_at());

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
				System.out.println(((Hero) cha[0]).getHp() + "�͎���ł���");
			else {

				// �E�҂̃^�[��
				System.out.println("<<   �@�E�҂̍��́H   >>");
				System.out.println("�U��:1 �h��:2 �x�e:3 �I��:4");

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
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  ��|����  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else
				System.out.println("�E�҂̃^�[���I��");
			System.out.println("----------------------------------------");

			if (((Magician) cha[1]).getHp()<= 0)
				System.out.println("���@�g���͎���ł�");
			else {

				// ���@�g���̃^�[��
				System.out.println("<<   ���@�g���̍��́H   >>");

				if (((Magician) cha[1]).getHp() >= 20) {
					System.out.println("�U��:1 �U�����@:2 ���U�����@:3");
					System.out.println("�񕜖��@:4 �h��:5 �x�e:6 �I��:7");
				}
				if ((((Magician) cha[1]).getHp()< 20) && (((Magician) cha[1]).getHp()>= 10)) {
					System.out.println("�U��:1 �U�����@:2 �񕜖��@:4");
					System.out.println(" �h��:5 �x�e:6 �I��:7");
				}
				if ((((Magician) cha[1]).getHp()< 10) && (((Magician) cha[1]).getHp() >= 5)) {
					System.out.println("�U��:1 �񕜖��@:4 �h��:5 �x�e:6 �I��:7");
				}
				if (((Magician) cha[1]).getHp()< 5) {
					System.out.println("�U��:1 �h��:5 �x�e:6 �I��:7");
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
				System.out.println("@@@@@@@@@@@  " + ((Monster) cre[0]).getName() + "  ��|����  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else {
				System.out.println("���@�g���̃^�[���I��");
				System.out.println("----------------------------------------");
			}

			// �����X�^�[�̃^�[��
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
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;

				// ���@�g��������ł��鎞

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
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;

				// �E�҂�����ł��鎞

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
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;
			}
		}
	}
		
	
	public static void status(Charactor cha[], Creature cre[]) {
		System.out.println("�y"      + ((Hero) cha[0]).getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"   + ((Hero) cha[0]).getHp());
		System.out.println("�U����:" + ((Hero) cha[0]).getAt());
		System.out.println("�h���:" + ((Hero) cha[0]).getDf());

		System.out.println("�y"      + ((Magician) cha[1]).getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"   + ((Magician) cha[1]).getHp());
		System.out.println("�U����:" + ((Magician) cha[1]).getAt());
		System.out.println("�h���:" + ((Magician) cha[1]).getDf());
		System.out.println("MP:"     + ((Magician) cha[1]).getMp());

		System.out.println("�y"        + ((Monster) cre[0]).getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"     + ((Monster) cre[0]).getHp());
		System.out.println("�U����:"   + ((Monster) cre[0]).getAt());
		System.out.println("�h���:"   + ((Monster) cre[0]).getDf());
		System.out.println("�Ɛj�̐�:" + ((SuperMonster) cre[0]).getPoison());
	}

	public static void attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  �͎���  @@@@@@@@@@");
	}
	public static void attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  �͎���  @@@@@@@@@@");
	}

	public static void p_attack_h2(Charactor[] cha, Creature[] cre) {
		cre[0].attack1(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack1(cha);
		}
		if (((Hero) cha[0]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Hero) cha[0]).getName() + "  �͎���  @@@@@@@@@@");
	}

	public static void p_attack_mg2(Charactor[] cha, Creature[] cre) {
		cre[0].attack2(cha);
		if (((SuperMonster) cre[0]).getPoison() > 0) {
			((SuperMonster) cre[0]).poison_Attack2(cha);
		}
		if (((Magician) cha[1]).getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + ((Magician) cha[1]).getName() + "  �͎���  @@@@@@@@@@");
	}

}