package kadai_12_1;

public class Hero extends Charactor {

	public Hero(String name, int hp, int at, int df) {
		super(name, hp, at, df);

		System.out.println("誇り高き勇者が今ここに誕生した");
		System.out.println("名前:"   + getName());
	//	printStatus();
	}
}
