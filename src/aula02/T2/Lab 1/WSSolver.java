
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.nio.file.Files;

public class WSSolver {
	

	public static void main(String[] args) throws IOException {
		
		if (args.length!=1) {
			System.out.println("Número de argumentos incorreto.");
			System.exit(0);
		}

		Path path = Paths.get(args[0]);
		
		if(!Files.exists(path)) {
			System.out.println("Ficheiro não existe.");
			System.exit(0);
		}
		
		List<String> list = Files.readAllLines(path);
		int comp = list.get(0).length();
		int height = list.size();

		if (comp>60) {
			System.out.println("Ficheiro não adequado (tamanho da sopa de letras maior que 60).");
			System.exit(0);
		}
		
		for(int i = 0;i<height;i++) {
			if (i<comp && !(!list.get(i).isEmpty() && list.get(i).toUpperCase().equals(list.get(i)) && list.get(i).length()==comp)) {
				System.out.println("Ficheiro não adequado (sopa de letras não é um quadrado).");
				System.exit(0);
			}
			else if (i>=comp && list.get(i).toUpperCase().equals(list.get(i)) && list.get(i).length()==comp && list.get(i).matches("[A-Z]+")) {
				System.out.println("Ficheiro não adequado (sopa de letras não é um quadrado).");
				System.exit(0);
			}
		}
		
		
		List<String> words = new ArrayList<String>();
		
		
		for(int i = comp;i<height;i++) {
			String[] line = list.get(i).split(",");
			
			for(String s : line) {
				s = s.trim();
				if(s.matches("[A-Z]+") || s.length()<3) {
					System.out.println("Ficheiro contém palavras invalidas.");
					System.exit(0);
				}
				else if(!s.isEmpty() && !s.matches("[A-Z]+") && s.length()>=3) {
					words.add(s.toUpperCase());
				}
			}
		}
		
		list = list.subList(0, comp);
		
		for(int i = 0; i<words.size();i++) {
			for(int c = i+1; c<words.size();c++) {
				if(words.get(i).contains(words.get(c)) || words.get(c).contains(words.get(i)) || words.get(i).equals(words.get(c))) {
					System.out.println("Ficheiro contém palavras repetidas ou redundantes.");
					System.exit(0);
				}
			}
		}
		
		Solver sol = new Solver(list,words);
				
		sol.Solve();
		
	}

}
