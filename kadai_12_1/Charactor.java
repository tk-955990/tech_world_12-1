package kadai_12_1;

public abstract class Charactor extends Actor {

	public Charactor(String name, int hp, int at, int df) {
		super(name, hp, at, df);
	}

	
	public void attack(Creature cre) {
		System.out.println(getName() + "の攻撃！！");
		cre.setHp(cre.getHp() - getAt());
		System.out.println(cre.getName() + "に" + getAt() + "ポイントのダメージを与えた！！");
	}

	public void heal() {
		System.out.println(getName() + "は休憩をした");
		setHp(getHp() + 10);
		System.out.println(getName() + "の体力が１０ポイント回復し、" + getHp() + "ポイントになった");
	}

}
