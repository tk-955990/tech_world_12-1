package kadai_12_1;

public class Monster extends Creature {

	public Monster(String name, int hp, int at, int df) {
		super(name, hp, at, df);
		System.out.println("禍々しい怪物がここに誕生した");
		System.out.println("名前:"   + getName());
	//	printStatus();
	}
}
