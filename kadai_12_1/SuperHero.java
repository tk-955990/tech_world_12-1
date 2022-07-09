package kadai_12_1;

public class SuperHero extends Hero {

	public SuperHero(String name, int hp, int at, int df) {
		super(name, hp, at, df);
	}
	
	@Override
	public void attack(Creature cre) {
		System.out.println(getName() + "は２回連続で切り付けた！");
		super.attack(cre);
		super.attack(cre);
	}
}
