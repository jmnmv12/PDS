
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WSGenerator {
	

	public static void main(String[] args) throws IOException {
		
		if (args.length!=1 && args.length!=2) {
			System.out.println("Número de argumentos incorreto.");
			System.exit(0);
		}
		
		Path path = Paths.get(args[0]);
		
		if(!Files.exists(path)) {
			System.out.println("Ficheiro não existe.");
			System.exit(0);
		}
		
		List<String> list = Files.readAllLines(path);
		
		List<String> words =new ArrayList<String>();
		int minComp=0;
		
		for(String s:list) {
			if(s.split(",").length==1) {
				//System.out.println("s = " +s);
				s = s.trim();
				if(s.length()>minComp) {
					minComp=s.length();
				}
				if(s.matches("[A-Z]+") || s.length()<3) {
					System.out.println("Ficheiro contém palavras invalidas.");
					System.exit(0);
				}
				else if(!s.isEmpty() && !s.matches("[A-Z]+") && s.length()>=3) {
					words.add(s.toUpperCase());
				}
			}
			else {
				for(String word:s.split(",")) {
					//System.out.println("word = " +word);
					word = word.trim();
					if(word.length()>minComp) {
						minComp=word.length();
					}
					if(word.matches("[A-Z]+") || word.length()<3) {
						System.out.println("Ficheiro contém palavras invalidas.");
						System.exit(0);
					}
					else if(!word.isEmpty() && !word.matches("[A-Z]+") && word.length()>=3) {
						words.add(word.toUpperCase());
					}
				}
			}
		}
		
		int comp = (int)(minComp+Math.random()*55);
		
		Generator g = new Generator(comp);
		
		for(String word:words) {
			boolean b = g.addWord(word);
			if(b == false) {
				System.out.println("Não foi possivel adicionar a palavra: "+word);
			}
		}
		
		List<String> soup = g.GenerateSoup();
		
		for(String s:soup) {
			System.out.println(s);
		}
		
		for(String word:words) {
			System.out.println(word);
		}
		
		if(args.length==2) {
			Path pathw = Paths.get(args[1]);
			Charset charset = Charset.forName("US-ASCII");
			BufferedWriter writer = Files.newBufferedWriter(pathw, charset);
			for(String s:soup) {
				System.out.println(s);
				writer.write(s+"\n");
			}
			
			for(String word:words) {
				System.out.println(word);
				writer.write(word.toLowerCase()+"\n");
			}
			writer.close();
		}
		
	}

}
