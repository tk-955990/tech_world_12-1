package kadai_12_1;

public class Monster extends Creature {

	

	public Monster(String name, int hp, int at, int df, int p_at, int poison) {
		super(name, hp, at, df);
		System.out.println("禍々しい怪物がここに誕生した");
		printStatus();
	}

	
	

}
