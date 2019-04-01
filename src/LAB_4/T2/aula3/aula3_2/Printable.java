package LAB_4.T2.aula3.aula3_2;

import java.util.ArrayList;
import java.util.Collections;

public class Printable {
	private int number;
	private ArrayList<Apartement> apartamentos;

	public int getNumber() {
		return this.number;
	}

	public ArrayList<Apartement> getApartamentos(){
		return this.apartamentos;
	}

	public Printable(int number) {
		this.number = number;
		this.apartamentos = new ArrayList<>();
	}

	public void addApartement(Apartement a) {
		this.apartamentos.add(a);
	}

	public void orderApartements() {
		Collections.sort(apartamentos);
	}

	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < this.apartamentos.size(); i++) {
			for (int j = 0; j < this.apartamentos.get(i).getPessoas().size(); j++) {
				aux += this.apartamentos.get(i).getPessoas().get(j).getName() + "  ";
			}
			if (i != this.apartamentos.size() - 1) {
				aux += " : ";
			}
		}

		return this.number + " : " + aux;
	}
}
