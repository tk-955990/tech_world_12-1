package kadai_10_4;

import kadai_10_4.Monster;

public class SuperMonster extends Monster {

	private int p_at;
	private int poison;

	// �ōU��
	// �E�҂ւ̓ōU��
	public void poison_Attack1(SuperHero h2) {
		System.out.println(this.getName() + "�͍X�ɓŐj�ōU�������I");
		System.out.println("�E�҂�" + this.p_at + "�̃_���[�W��^����");
		this.poison = this.poison - 1;
		h2.setHp(h2.getHp() - this.getP_at());
		System.out.println("�Ɛj���P�{���" + this.poison + "�{�ɂȂ���");
	} // ���@�g���ւ̓ōU��

	public void poison_Attack2(SuperMagician mg2) {
		System.out.println(this.getName() + "�͍X�ɓŐj�ōU�������I");
		System.out.println("���@�g����" + this.p_at + "�̃_���[�W��^����");
		this.poison = this.poison - 1;
		mg2.setHp(mg2.getHp() - this.getP_at());
		System.out.println("�Ɛj���P�{���" + this.poison + "�{�ɂȂ���");
	}

	public void setP_at(int p_at) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		this.p_at = p_at;
	}

	public void setPoison(int poison) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		this.poison = poison;
	}

	public int getPoison() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return this.poison;
	}

	public int getP_at() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return this.p_at;
	}
}
