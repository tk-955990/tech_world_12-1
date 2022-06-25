package kadai_10_4;

public class Monster extends Creature {

	private int hp;
	private String name;
	private int at;
	private int df;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == "null") {
			throw new IllegalArgumentException("���O��null�ł�");
		}
		if ((name.length() < 3) || (name.length() > 10)) {
			throw new IllegalArgumentException("��������3�����ȏ�A�P�O�����ȉ��œ��͂��Ă�������");
		}
		this.name = name;
	}

	public int getHp() {

		return this.hp;
	}

	public void setHp(int hp) {
		if (hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		if (at < 0) {
			at = 0;
		}
		this.at = at;
	}

	public int getDf() {
		return this.df;
	}

	public void setDf(int df) {
		if (df < 0) {
			df = 0;
		}
		this.df = df;
	}

	@Override
	public void attack1(Hero h) {
		System.out.println(this.name + "�̍U���I�I�I");
		System.out.println("�E�҂�" + this.at + "�|�C���g�̃_���[�W���󂯂�");
		h.setHp(h.getHp() - this.getAt());
	}

	@Override
	public void attack2(Magician mg) {
		System.out.println(this.name + "�̍U���I�I�I");
		System.out.println("���@�g����" + this.at + "�|�C���g�̃_���[�W���󂯂�");
		mg.setHp(mg.getHp() - this.getAt());
	}

	@Override
	public void defence() {
		System.out.println(this.name + "�͎����ł߂�");
		this.df = this.df + 10;
		System.out.println(this.name + "�̖h��͂��P�O�|�C���g�オ����");
	}
}
