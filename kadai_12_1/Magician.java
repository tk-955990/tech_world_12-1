package kadai_12_1;

public class Magician extends Charactor {

	private int mp;
	private int m_at;

	public Magician(String name, int hp, int at, int df, int mp, int m_at) {
		super(name, hp, at, df);
		setMp(mp);
		setM_at(m_at);
		System.out.println("魔法使いがここに誕生した");
		System.out.println("名前:"   + getName());
		printStatus();
	}

	@Override
	public void printStatus() {
		super.printStatus();
		System.out.println("MP:" + this.mp);
		System.out.println("攻撃魔法力:" + this.m_at);
	}
	// 魔法攻撃
	public void magic_Attack(Creature cre) { 
		System.out.println(getName() + "は魔法で攻撃した！");
		if(getMp() < 10) {
			System.out.println("しかし、MPが足りなかった・・・");
			return;
		}
		cre.setHp(cre.getHp() - this.m_at);
		System.out.println(cre.getName() + "に" + this.m_at + "のダメージを与えた");
		setMp(this.mp - 10);
		System.out.println("MPを１０ポイント消費し" + this.mp + "ポイントになった");
	}
	// 回復魔法
	public void magic_Recovery(Charactor[] chas) { 
		System.out.println(this.getName() + "は魔法で味方全員を回復した");
		if(getMp() < 5) {
			System.out.println("しかし、MPが足りなかった・・・");
			return;
		}
		for(int i = 0; i < chas.length; i++) {
			chas[i].setHp(chas[i].getHp() + 10);
			System.out.println(chas[i].getName() + "の体力が１０ポイント回復した");
		}
		setMp(this.mp - 5);
		System.out.println("MPを５ポイント消費し" + this.mp + "ポイントになった");
	}

	public int getMp() {
		return this.mp;
	}

	public void setMp(int mp) {
		if (mp < 0) {
			mp = 0;
		}
		this.mp = mp;
	}

	public int getM_at() {
		return this.m_at;
	}

	public void setM_at(int m_at) {
		if (m_at < 0) {
			m_at = 0;
		}
		this.m_at = m_at;
	}

}
