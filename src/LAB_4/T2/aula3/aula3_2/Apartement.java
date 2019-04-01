package LAB_4.T2.aula3.aula3_2;

import java.util.ArrayList;

public class Apartement implements Comparable<Apartement>{
	private ArrayList<Pessoa> pessoas;

	public ArrayList<Pessoa> getPessoas(){
		return this.pessoas;
	}

	public Apartement(Pessoa p) {
		this.pessoas = new ArrayList<>();
		pessoas.add(p);
	}

	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < pessoas.size(); i++) {
			aux += pessoas.get(i).getName();
		}

		return aux;
	}

	@Override
	public int compareTo(Apartement t) {
		if (this.pessoas.get(0).getSpace() > t.getPessoas().get(0).getSpace()) {
			return -1;
		}
		return 1;
	}
}