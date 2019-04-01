package LAB_4.T1.aula3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rua {
	
	private List<Familia> familias; //Lista de fam�lias presentes na rua
	private List<String> nomes;		//Lista de pessoas que ocupam esta rua
	private int maxPort;			//N�mero de porta mais alto ocupado na rua
	
	
	public Rua() {
		this.familias = new ArrayList<Familia>();
		this.nomes = new ArrayList<String>();
		this.maxPort=1; //O n�mero da rua come�a por 1
	}

	
	public boolean Add(int portaIn,int portaFin, String nome) { //Adiciona uma pessoa � rua
		if(this.nomes.contains(nome)) { //Verifica se j� existe algum residente com o mesmo nome do membro a ser adicionado
			System.out.println("Rua j� tem residente com esse nome ( "+nome+" ).");
			return false;
		}
		for(Familia f:familias) { //Itera pelas familias da rua para verificar se alguma delas ocupa as mesmas portas que a pessoa a ser adicionada
			//System.out.println("f - "+f.getPortaInicial()+" - "+f.getPortaFinal() +" "+nome+" "+portaIn+" "+portaFin);
			if(f.getPortaInicial()==portaIn && f.getPortaFinal()==portaFin) { //Se a fam�lia e a pessoa a ser adiciona ocuparem os mesmos n�meros de portas a nova pessoa
				//System.out.println("Check add");							  // � adicionada a essa familia
				boolean b = f.AddMembro(nome);
				if(b == true) {
					nomes.add(nome);
					System.out.println("Nome adicionado com sucesso ( "+nome+" existent family).");
				}
				return b;
			}
		}
		Familia f = Familia.createFamilia(portaIn, portaFin);	//Se n�o for encontrada uma fam�lia que ocupe as mesmas portas 
		if(f==null) {											//, ent�o � criada uma nova familia para a nova pessoa
			return false;
		}
		if(!f.AddMembro(nome)) {
			return false;
		}
		nomes.add(nome);
		System.out.println("Nome adicionado com sucesso ( "+nome+" new family).");
		familias.add(f);
		if(this.maxPort<portaFin) { //Atualiza a porta m�xima ocupada se necess�rio
			maxPort = portaFin;
		}
		return true;
	}
	
	public boolean Remove(String s) { //Remove um nome da rua
		if(!this.nomes.contains(s)) {
			System.out.println("A rua n�o cont�m o nome a remover ( "+s+" ).");
			return false;
		}
		for(Familia f:familias) {	//Se o nome pertencer a alguma familia, ele � eliminado da fam�lia a que pertencia
			if(f.contains(s)) {
				boolean b = f.RemoveMembro(s);
				nomes.remove(s);
				if(f.getNumeroMembros()==0) {//Se o nome for removido de uma fam�lia e esta tiver zero membros, esta � eliminada
					familias.remove(f);
				}
				System.out.println("Nome removido com sucesso ( "+s+" ).");
				return b;
			}
		}
		return false;
	}
	
	public boolean Load(String filename) throws IOException {
		Path path = Paths.get(filename);
		
		if(!Files.exists(path)) { //Verificar a existencia do ficheiro
			System.out.println("Ficheiro n�o existe.");
			return false;
		}
		
		List<String> list = Files.readAllLines(path); //Lista com todas as linhas do ficheiro
		
		if(list.get(0).charAt(0)!='>') {	//Processar a primeira linha se ela for v�lida
			String[] s = list.get(0).split(" |\\.");
			int in = Integer.parseInt(s[0]);
			int out = Integer.parseInt(s[1]);
			String nome = s[3];
			this.Add(in, out, nome);
		}
		
		for(int i = 1;i<list.size();i++) { //Processar as linhas restantes
			String line = list.get(i);
			String[] s = line.split("-|\\ ");
			for(String st:s) {
				System.out.println(st);
			}
			int in = Integer.parseInt(s[0]);
			int out = Integer.parseInt(s[1]);
			String nome = s[2];
			this.Add(in, out, nome);
		}
		return true;
	}
	
	public void map() {
		this.familias.sort(null);
		Collections.reverse(familias); //Ordena-se as familias de forma a ficarem 
		for(int i=1;i<=this.maxPort;i++) { //primeiro as que t�m mais portas ocupadas
			String s = i+" ";
			for(Familia f :this.familias) { //Itera-se por cada porta at� � porta m�xima ocupada e 
				if(f.ocupa(i)) {			//para cada porta verifica-se que fam�lias as ocupam. Depois � 
					s = s + ": "+f+" ";		//impressa uma linha por porta com as fam�lias que a ocupam, 
				}							//de forma a ficar primeiro a que ocupa um maior n�mero de portas
			}
			System.out.println(s);
		}
	}
	
	public void list() { //Lista os nomes por ordem alfab�tica e para cada nome procura o n�meros das portas ocupados
		this.nomes.sort(null); //procurando pela familia a que pertence o nome
		
		for(String nome:nomes) {
			String line = nome + " ";
			for(Familia f:familias) {
				if(f.contains(nome)) {
					line = line + f.getPortaInicial()+" "+f.getPortaFinal();
				}
			}
			System.out.println(line);
			
		}
	}
	
	public void lookup(String nome) {//Procura pelo nome nas fam�lias da rua e devolve as informa��es 
		for(Familia f:familias) {	 //da fam�lia a que pertence esse nome
			if(f.contains(nome)) {
				System.out.println(f.getPortaInicial()+" "+f.getPortaFinal()+" : "+f);
			}
		}
	}
	
	public void clear() { //Limpa todas as listas e faz reset do n�mero de porta m�ximo ocupado
		this.maxPort=1;
		this.familias.clear();
		this.nomes.clear();
		System.out.println("Cleared");
	}
}
