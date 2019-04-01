package LAB_4.T1.aula3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Rua rua = new Rua();
		
		
		if (args.length==0) { //No caso de n�o haver ficheiro de comandos como argumento executa comandos lidos do utilizador
			Scanner sc = new Scanner(System.in);
			String line="";
			do {
				line = sc.nextLine();
				String [] arguments = line.split(" ");
				if(arguments[0].toUpperCase().equals("ADD") && arguments.length==4) {
					rua.Add(Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("LOAD") && arguments.length==2) {
					rua.Load(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("REMOVE") && arguments.length==2) {
					rua.Remove(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("MAP")) {
					rua.map();
				}
				else if(arguments[0].toUpperCase().equals("LIST")) {
					System.out.println("LIST");
					rua.list();
				}
				else if(arguments[0].toUpperCase().equals("LOOKUP") && arguments.length==2) {
					rua.lookup(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("CLEAR")) {
					rua.clear();
				}
			}while(!line.toUpperCase().equals("QUIT"));
			System.out.println("END");
			sc.close();
		}
		else { //No caso de haver um argumento com um ficheiro de comandos, verifica a integridade desse ficheiro e l� um comando por linha desse ficheiro
			Path path = Paths.get(args[0]);
			
			if(!Files.exists(path)) {
				System.out.println("Ficheiro n�o existe.");
				System.exit(0);
			}
			
			List<String> list = Files.readAllLines(path);
			for(String line : list) {
				String [] arguments = line.split(" ");
				if(arguments[0].toUpperCase().equals("ADD") && arguments.length==4) {
					rua.Add(Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("LOAD") && arguments.length==2) {
					rua.Load(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("REMOVE") && arguments.length==2) {
					rua.Remove(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("MAP")) {
					rua.map();
				}
				else if(arguments[0].toUpperCase().equals("LIST")) {
					rua.list();
				}
				else if(arguments[0].toUpperCase().equals("LOOKUP") && arguments.length==2) {
					rua.lookup(arguments[1]);
				}
				else if(arguments[0].toUpperCase().equals("QUIT")) {
					System.out.println("END");
					break;
				}
				else if(arguments[0].toUpperCase().equals("CLEAR")) {
					rua.clear();
				}
			}
		}
	}

}
