package kadai_12;

import kadai_12.Monster;

public class SuperMonster extends Monster {

	private int p_at;
	private int poison;

	// �ōU��
	// �E�҂ւ̓ōU��
	public void poison_Attack1(Charactor[] cha) {
		System.out.println(this.getName() + "�͍X�ɓŐj�ōU�������I");
		System.out.println("�E�҂�" + this.p_at + "�̃_���[�W��^����");
		this.poison = this.poison - 1;
		((Hero) cha[0]).setHp(((Hero) cha[0]).getHp() - this.getP_at());
		System.out.println("�Ɛj���P�{���" + this.poison + "�{�ɂȂ���");
	} 
	// ���@�g���ւ̓ōU��

	public void poison_Attack2(Charactor[] cha) {
		System.out.println(this.getName() + "�͍X�ɓŐj�ōU�������I");
		System.out.println("���@�g����" + this.p_at + "�̃_���[�W��^����");
		this.poison = this.poison - 1;
		((Magician) cha[1]).setHp(((Magician) cha[1]).getHp() - this.getP_at());
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
