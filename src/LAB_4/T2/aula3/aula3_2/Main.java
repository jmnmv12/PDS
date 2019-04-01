package LAB_4.T2.aula3.aula3_2;

import java.io.File;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
	static ArrayList<Pessoa> people = new ArrayList<>();

	public static boolean isPerson(String name) {
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getName() == name) {
				return true;
			}
		}
		return false;
	}

	public static void readFile() {
		Pessoa p;
		try {
			File f = new File("../../../exemplo1.txt");
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String [] line = sc.nextLine().split("[- ]");
				if (!line[0].equals(">")) {
					if (!isPerson(line[2])) {
						p = new Pessoa(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]);

						// Cumprimento do requisito n� 3.

						Pattern pattern = Pattern.compile("[a-zA-Z0-9_.@]*");
						Matcher matcher = pattern.matcher(line[2]);

						// 3.e)
						if(line[2].length()>40) {
							System.err.println("O comprimento m�ximo de um nome � de 40 caracteres.\nA palavra '" + line[2] + 
									"' cont�m " + line[2].length() + " caracteres.");
							System.exit(1);
						}
						// 3.a) e 3.c)
						if (!matcher.matches()) {
							System.err.println("O ficheiro de texto tem um nome inv�lido: " + line[2]);
							System.exit(1);
						}

						// 3.b)						
						if(!Character.isLetter(line[2].charAt(0))) {
							System.err.println("O nome '" + line[2] + "' deve come�ar com uma letra.");
							System.exit(1);
						}

						// 3.d)
						String aux = "" + line[2].charAt(line[2].length()-1);
						if((aux).matches("[_.@]")) {
							System.err.println("O nome '" + line[2] + "' n�o pode acabar um s�mbolo.");
							System.exit(1);
						}
						// Fim do requisito n� 3.

						people.add(p);
					}
				}
			}
			sc.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> orderApart() {
		ArrayList<Integer> lista = new ArrayList<>();
		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < people.get(i).getApartements().length; j++) {
				int [] aux = people.get(i).getApartements();
				if (!lista.contains(aux[j])) {
					lista.add(aux[j]);
				}
			}
		}

		Collections.sort(lista);
		return lista;

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

	public static void addApartements(Printable p) {
		boolean b;
		int number = p.getNumber();
		for (int i = 0; i < people.size(); i++) {
			if (contains(number, people.get(i).getApartements())) {	
				b = false;
				for (int j = 0; j < p.getApartamentos().size(); j++) {  // Vai procurar nos apartamentos j� existentes daquele printable
					if (Arrays.equals(p.getApartamentos().get(j).getPessoas().get(0).getApartements(), people.get(i).getApartements())) {
						p.getApartamentos().get(j).getPessoas().add(people.get(i));
						b = true;
						break;
					}
				}
				if (!b) {
					p.addApartement(new Apartement(people.get(i)));
				}
			}
		}					
	}

	public static int[] convertIntegers(ArrayList<Integer> integers) {
		int[] ret = new int[integers.size()];
		for (int i=0; i < ret.length; i++) {
			ret[i] = integers.get(i).intValue();
		}
		return ret;
	}

	public static void main(String [] args) {
		ArrayList<Printable> buildings = new ArrayList<>();
		ArrayList<Integer> order = orderApart();
		int[] myArray = convertIntegers(order);
		Scanner sc = new Scanner(System.in);
		int check = 0;
		while (true) {
			System.out.println("1-Load\n2-Map\n3-Add\n4-Remove\n5-List\n6-Lookup name\n7-Clear\n8-Quit\nCommand: ");
			String option = sc.next();
			switch(option) {
			case "1":
				readFile();

				order = orderApart();
				if (order.size() == 0) {
					break;
				}

				myArray = convertIntegers(order);

				for (int i = 1; i <= order.get(order.size() - 1) ; i++) {
					if (contains(i, myArray)) {
						Printable p = new Printable(i);
						addApartements(p);
						p.orderApartements();
						buildings.add(p);
					}
				}	
				check = 1;
				break;

			case "2":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}

				int z = 0;
				for (int i = 1; i <= order.get(order.size() - 1) ; i++) {
					if (contains(i, myArray)) {
						System.out.println(buildings.get(z));
						z++;
					}
					else {
						// Cumprimento do requisito n� 1.
						System.out.println(i);
						// Fim do requisito n� 1.

						// O requisito n� 2 j� � automaticamente cumprido.
					}
				}
				break;

			case "3":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}
				buildings.clear();

				Scanner sc5 = new Scanner(System.in);
				System.out.print("Insira a pessoa: ");
				String [] arg = sc5.nextLine().split(" ");
				Pessoa p = new Pessoa(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]), arg[0]);
				people.add(p);

				order = orderApart();
				if (order.size() == 0) {
					break;
				}

				myArray = convertIntegers(order);

				for (int i = 1; i <= order.get(order.size() - 1) ; i++) {
					if (contains(i, myArray)) {
						Printable p2 = new Printable(i);
						addApartements(p2);
						p2.orderApartements();
						buildings.add(p2);
					}
				}	

				System.out.println("Pessoa criada com sucesso!");
				break;

			case "4":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}
				boolean remove = false;
				Scanner sc3 = new Scanner(System.in);
				System.out.print("insira o nome da pessoa: ");
				String nome = sc3.next();
				for (int i = 0; i < people.size(); i++) {
					if (people.get(i).getName().equals(nome)) {
						people.remove(i);
						remove = true;
						System.out.println("Utilizador removido com sucesso!!");
					}
				}

				for(int i = 0; i < buildings.size(); i++) {
					for(int j = 0; j < buildings.get(i).getApartamentos().size(); j++) {
						for (int k = 0; k < buildings.get(i).getApartamentos().get(j).getPessoas().size(); k++) {
							if (buildings.get(i).getApartamentos().get(j).getPessoas().get(k).getName().equals(nome)) {
								buildings.get(i).getApartamentos().get(j).getPessoas().remove(buildings.get(i).getApartamentos().get(j).getPessoas().get(k));
							}
						}
					}
				}

				if (!remove) {
					System.out.println("O utilizador n�o existe, por isso n�o � possivel remover!!");
				}
				break;

			case "5":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}
				ArrayList<String> nomesPessoa = new ArrayList<>();
				for (int i = 0; i < people.size(); i++) {
					nomesPessoa.add(people.get(i).getName());
				}

				Collections.sort(nomesPessoa);
				for (int i = 0; i < nomesPessoa.size(); i++) {
					for (int j = 0; j < people.size();j++) {
						if (nomesPessoa.get(i).equals(people.get(j).getName())) {
							System.out.println(people.get(j));
						}
					}
				}
				break;

			case "6":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}
				int n1 = 0, n2 = 0;
				Apartement ap = null;
				String print = "";
				Scanner sc4 = new Scanner(System.in);
				System.out.print("Introduza o nome de um habitante: ");
				String habitante = sc4.next();
				for(int i = 0; i < buildings.size(); i++) {
					for(int j = 0; j < buildings.get(i).getApartamentos().size(); j++){
						for(int k = 0; k < buildings.get(i).getApartamentos().get(j).getPessoas().size(); k++) {
							if(buildings.get(i).getApartamentos().get(j).getPessoas().get(k).getName().equals(habitante)) {
								Pessoa p1 = buildings.get(i).getApartamentos().get(j).getPessoas().get(k);
								n1 = p1.getApartements()[0];
								n2 = p1.getApartements()[p1.getApartements().length - 1];
								ap = buildings.get(i).getApartamentos().get(j);
								print = "";
								for (int i1 = 0; i1 < ap.getPessoas().size(); i1++) {
									print += ap.getPessoas().get(i1).getName() + " ";
								}
								break;
							}
						}
					}
				}
				System.out.println(n1 + " " + n2 + " : " + print);

				break;

			case "7":
				if(check == 0) {
					System.err.println("Primeiro deve selecionar a op��o '1-Load'.");
					break;
				}
				people.clear();
				buildings.clear();
				break;

			case "8":
				System.exit(0);
			}
		}
	}
}
