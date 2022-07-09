package kadai_12_1;

public abstract class Actor {
	private String name;
	private      int hp;
	private      int at;
	private      int df;

	public Actor(String name, int hp, int at, int df) {
		setName(name);
		setHp  (hp);
		setAt  (at);
		setDf  (df);
	}

	public void printStatus() {
		System.out.println("体力:"   + this.hp);
		System.out.println("攻撃力:" + this.at);
		System.out.println("防御力:" + this.df);
	}

	public void defence() {
		System.out.println(this.name + "は守りを固めた");
		this.df = this.df + 10;
		System.out.println(this.name + "の防御力が１０ポイント上がった");
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("名前がnullです");
		}
		if ((name.length() < 3) || (name.length() > 10)) {
			throw new IllegalArgumentException("文字数は3文字以上、１０文字以下で入力してください");
		}
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
		if (this.hp < 0) {
			this.hp = 0;
		}
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		this.at = at;
		if (this.at < 0) {
			this.at = 0;
		}
	}

	public int getDf() {
		return this.df;
	}

	public void setDf(int df) {
		this.df = df;
		if (this.df < 0) {
			this.df = 0;
		}
	}

}
