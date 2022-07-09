package kadai_12_1;

public class SuperMonster extends Monster {

	private int p_at;
	private int poison;
	
	public SuperMonster(String name, int hp, int at, int df, int p_at, int poison) {
		super(name, hp, at, df, p_at, poison);
		setP_at(p_at);
		setPoison(poison);
	}

	
	@Override
	public void printStatus() {
		super.printStatus();
		System.out.println("毒攻撃力:" + this.getP_at());
		System.out.println("毒針の数:" + this.getPoison());
	}

	public void poison_Attack(Charactor cha) {
		if(getPoison() <= 0) {
			System.out.println(this.getName() + "は毒針を発射しようとした！");
			System.out.println("だが、毒針は尽きている！");
			return;
		}
		System.out.println(this.getName() + "は毒針を発射した！");
		System.out.println(cha.getName() + "は" + this.getAt() + "ポイントのダメージを受けた");
		cha.setHp(cha.getHp() - this.p_at);
		this.poison = this.poison - 1;
		System.out.println(this.getName() + "は毒針を１本消費し" + this.poison + "本になった");
	}
	
	public int getP_at() {
		return p_at;
	}

	public void setP_at(int p_at) {
		this.p_at = p_at;
		if (this.p_at < 0) {
			this.p_at = 0;
		}
	}

	public int getPoison() {
		return poison;
	}

	public void setPoison(int poison) {
		this.poison = poison;
		if (this.poison < 0) {
			this.poison = 0;
		}
	}

}