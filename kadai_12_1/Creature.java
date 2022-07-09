package kadai_12_1;

public abstract class Creature extends Actor {

	public Creature(String name, int hp, int at, int df) {
		super(name, hp, at, df);
	}

	public void attack(Charactor cha) {
		System.out.println(this.getName() + "の攻撃！！！");
		System.out.println(cha.getName() + "は" + this.getAt() + "ポイントのダメージを受けた");
		cha.setHp(cha.getHp() - this.getAt());
	}
}