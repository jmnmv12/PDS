package LAB_4.T2.aula3.aula3_2;

public class Pessoa {
	private int [] apartements;
	private String name;
	private int space;

	public String getName() {
		return this.name;
	}

	public int [] getApartements() {
		return this.apartements;
	}

	public int getSpace() {
		return this.space;
	}

	public Pessoa(int min, int max, String name) {
		this.apartements = new int[max - min + 1];
		for (int i = min; i <= max; i++) {
			this.apartements[i - min] = i;
		}

		this.name = name;
		this.space = max - min;
	}

	@Override
	public String toString() {
		String a = "";
		for (int i = 0; i < apartements.length; i++) {
			a += apartements[i] + " ";
		}
		return this.name + " " + a;
	}

	public static boolean contains(int number, int [] list) {
		boolean bool = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == number) {
				bool = true;
			}
		}
		return bool;
	}

	public float order(String name) {
		float n = 0;
		for (int i = 0; i < name.length(); i++) {
			n += name.charAt(i) * 10000 / (10 ^ i);
		}
		return n;
	}
}
