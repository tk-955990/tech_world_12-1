package kadai_12_1;

public class SuperMagician extends Magician {

	public SuperMagician(String name, int hp, int at, int df, int mp, int m_at) {
		super(name, hp, at, df, mp, m_at);
	}
	// 超魔法攻撃
	public void super_magic_Attack(Creature cre) {
		System.out.println(this.getName() + "は超攻撃魔法で攻撃した！");
		if(getMp() < 20) {
			System.out.println("しかし、MPが足りなかった・・・");
			return;
		}
		cre.setHp(cre.getHp() - this.getM_at() * 2);
		System.out.println(cre.getName() + "に" + this.getM_at() * 2 + "のダメージを与えた");
		setMp(this.getMp() - 20);
		System.out.println("MPを２０ポイント消費し" + this.getMp() + "ポイントになった");
	}


}
