package kadai_12;

import kadai_12.Monster;

public class SuperMonster extends Monster {

	private int p_at;
	private int poison;

	// 毒攻撃
	// 勇者への毒攻撃
	public void poison_Attack1(Charactor[] cha) {
		System.out.println(this.getName() + "は更に毒針で攻撃した！");
		System.out.println("勇者に" + this.p_at + "のダメージを与えた");
		this.poison = this.poison - 1;
		((Hero) cha[0]).setHp(((Hero) cha[0]).getHp() - this.getP_at());
		System.out.println("独針を１本消費し" + this.poison + "本になった");
	} 
	// 魔法使いへの毒攻撃

	public void poison_Attack2(Charactor[] cha) {
		System.out.println(this.getName() + "は更に毒針で攻撃した！");
		System.out.println("魔法使いに" + this.p_at + "のダメージを与えた");
		this.poison = this.poison - 1;
		((Magician) cha[1]).setHp(((Magician) cha[1]).getHp() - this.getP_at());
		System.out.println("独針を１本消費し" + this.poison + "本になった");
	}

	public void setP_at(int p_at) {
		// TODO 自動生成されたメソッド・スタブ
		this.p_at = p_at;
	}

	public void setPoison(int poison) {
		// TODO 自動生成されたメソッド・スタブ
		this.poison = poison;
	}

	public int getPoison() {
		// TODO 自動生成されたメソッド・スタブ
		return this.poison;
	}

	public int getP_at() {
		// TODO 自動生成されたメソッド・スタブ
		return this.p_at;
	}

}
