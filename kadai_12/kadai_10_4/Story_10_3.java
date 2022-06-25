package kadai_10_4;

import java.util.Scanner;
import kadai.Story;

public class Story_10_3 {
	public static void main(String[] args) {

		Charactor[] cha = new Charactor[2];
		cha[0] = new Hero();
		cha[1] = new Magician();
		
		Creature[] cre = new Creature[1];
		cre[0] = new Monster();
		
		// �E�҂̐���

		SuperHero h2 = new SuperHero();
		h2.setName("roto");
		h2.setHp     (500);
		h2.setAt      (50);
		h2.setDf      (80);

		System.out.println("�ւ荂���E�҂��������ɒa������");
		System.out.println("���O:" + h2.getName());
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
		Scanner scanner = new Scanner(System.in);

		boolean b1 = (h2.getHp() <= 0);
		boolean b2 = (mg2.getHp() <= 0);
		boolean b3 = (m2.getHp() <= 0);
		b1 = true;
		b2 = true;
		b3 = true;

		while ((b1 && b2) || b3) {

			if (h2.getHp() <= 0)
				System.out.println(h2.getName() + "�͎���ł���");
			else {

				// �E�҂̃^�[��

				System.out.println("<<   �@�E�҂̍��́H   >>");
				System.out.println("�U��:1 �h��:2 �x�e:3 �I��:4");

				int get_hCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_hCommand) {
				case 1:
					h2.attack();
					m2.setHp(m2.getHp() - (h2.getAt()) * 2);
					break;
				case 2:
					h2.defence();
					break;
				case 3:
					h2.heal();
					break;
				case 4:
				}
				status(h2, mg2, m2);
			}
			if (m2.getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + m2.getName() + "  ��|����  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else
				System.out.println("�E�҂̃^�[���I��");
			System.out.println("----------------------------------------");

			if (mg2.getHp() <= 0)
				System.out.println("���@�g���͎���ł�");
			else {

				// ���@�g���̃^�[��
				System.out.println("<<   ���@�g���̍��́H   >>");

				if (mg2.getMp() >= 20) {
					System.out.println("�U��:1 �U�����@:2 ���U�����@:3");
					System.out.println("�񕜖��@:4 �h��:5 �x�e:6 �I��:7");
				}
				if ((mg2.getMp() < 20) && (mg2.getMp() >= 10)) {
					System.out.println("�U��:1 �U�����@:2 �񕜖��@:4");
					System.out.println(" �h��:5 �x�e:6 �I��:7");
				}
				if ((mg2.getMp() < 10) && (mg2.getMp() >= 5)) {
					System.out.println("�U��:1 �񕜖��@:4 �h��:5 �x�e:6 �I��:7");
				}
				if (mg2.getMp() < 5) {
					System.out.println("�U��:1 �h��:5 �x�e:6 �I��:7");
				}

				int get_mgCommand = new java.util.Scanner(System.in).nextInt();

				switch (get_mgCommand) {
				case 1:
					mg2.attack();
					m2.setHp(m2.getHp() - mg2.getAt());
					break;
				case 2:
					mg2.magic_Attack();
					m2.setHp(m2.getHp() - mg2.getM_at());
					break;
				case 3:
					mg2.super_magic_Attack();
					m2.setHp(m2.getHp() - (mg2.getM_at()) * 2);
					break;
				case 4:
					mg2.magic_Recovery();
					break;
				case 5:
					mg2.defence();
					break;
				case 6:
					mg2.heal();
					break;
				case 7:
					break;

				}
				status(h2, mg2, m2);
			}
			if (m2.getHp() <= 0) {
				System.out.println("@@@@@@@@@@@  " + m2.getName() + "  ��|����  @@@@@@@@@@");
				System.out.println("========= You Winn !! ==================");
				break;
			} else {
				System.out.println("���@�g���̃^�[���I��");
				System.out.println("----------------------------------------");
			}

			// �����X�^�[�̃^�[��
			if ((mg2.getHp() > 0) && (h2.getHp() > 0)) {
				int random = (int) (Math.random() * 5);
				switch (random) {
				case 0:
					attack_h2(h2, m2);
					break;
				case 1:
					attack_mg2(mg2, m2);
					break;
				case 2:
					p_attack_h2(m2, h2);
					break;
				case 3:
					p_attack_mg2(m2, mg2, h2);
					break;
				case 4:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;

				// ���@�g��������ł��鎞

			}
			if ((mg2.getHp() <= 0) && (h2.getHp() > 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_h2(h2, m2);
					break;
				case 1:
					p_attack_h2(m2, h2);
					break;
				case 2:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;

				// �E�҂�����ł��鎞

			}
			if ((mg2.getHp() > 0) && (h2.getHp() <= 0)) {
				int random = (int) (Math.random() * 3);
				switch (random) {
				case 0:
					attack_mg2(mg2, m2);
					break;
				case 1:
					p_attack_mg2(m2, mg2, h2);
					break;
				case 2:
					m2.defence();
					break;
				}
				status(h2, mg2, m2);
				if ((mg2.getHp() <= 0) && (h2.getHp() <= 0)) {
					System.out.println("============= game over ================");
					break;
				} else
					System.out.println("�����X�^�[�̃^�[���I��");
				System.out.println("----------------------------------------");
				continue;
			}
		}
	}

	public static void status(SuperHero h2, SuperMagician mg2, SuperMonster m2) {
		System.out.println("�y"      + h2.getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"   + h2.getHp());
		System.out.println("�U����:" + h2.getAt());
		System.out.println("�h���:" + h2.getDf());

		System.out.println("�y"      + mg2.getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"   + mg2.getHp());
		System.out.println("�U����:" + mg2.getAt());
		System.out.println("�h���:" + mg2.getDf());
		System.out.println("MP:"     + mg2.getMp());

		System.out.println("�y"        + m2.getName() + ":�X�e�[�^�X�z");
		System.out.println("�̗�:"     + m2.getHp());
		System.out.println("�U����:"   + m2.getAt());
		System.out.println("�h���:"   + m2.getDf());
		System.out.println("�Ɛj�̐�:" + m2.getPoison());
	}

	public static void attack_h2(SuperHero h2, SuperMonster m2) {
		m2.attack1(h2);
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  �͎���  @@@@@@@@@@");
	}

	public static void attack_mg2(SuperMagician mg2, SuperMonster m2) {
		m2.attack2(mg2);
		if (mg2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + mg2.getName() + "  �͎���  @@@@@@@@@@");
	}

	public static void p_attack_h2(SuperMonster m2, SuperHero h2) {
		m2.attack1(h2);
		if (m2.getPoison() > 0) {
			m2.poison_Attack1(h2);
		}
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  �͎���  @@@@@@@@@@");
	}

	public static void p_attack_mg2(SuperMonster m2, SuperMagician mg2, SuperHero h2) {
		m2.attack2(mg2);
		if (m2.getPoison() > 0) {
			m2.poison_Attack2(mg2);
		}
		if (h2.getHp() <= 0)
			System.out.println("@@@@@@@@@@@  " + h2.getName() + "  �͎���  @@@@@@@@@@");
	}

}