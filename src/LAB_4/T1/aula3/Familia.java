package LAB_4.T1.aula3;

import java.util.ArrayList;
import java.util.List;

public class Familia implements Comparable<Familia> {
	
	private int portaInicial; //N�mero da porta inicial do intervalo de portas que a familia ocupa
	private int portaFinal;	  //N�mero da porta final do intervalo de portas que a familia ocupa
	private List<String> membros; //Lista com membros da fam�lia;
	
	static public Familia createFamilia(int portainicial, int portafinal) { //Fun��o que ajuda na cria��o de objetos v�lidos desta classe
		if(portainicial<=0 || portafinal<=0) {
			System.out.println("Os n�meros das portas dadas t�m de ser positivos ( "+portainicial+" - "+portafinal+" ).");
			return null;
		}
		if(portainicial>portafinal) {
			System.out.println("O n�mero da porta inicial tem de ser menor ou igual que o da porta final( "+portainicial+" - "+portafinal+" ).");
			return null;
		}
		
		return new Familia(portainicial,portafinal);
	}

	private Familia(int portaInicial, int portaFinal) { //Construtor privado porque vai ser utilizada outra fun��oe est�tica para obter objetos desta classe
		this.portaInicial = portaInicial;
		this.portaFinal = portaFinal;
		this.membros = new ArrayList<String>();
	}
	
	public boolean AddMembro(String s) { //Adiciona um membro � familia fazendo as verifica��es necess�rias
		if(this.membros.contains(s)) {
			System.out.println("Familia j� tem residente com esse nome ( "+s+" ).");
			return false;
		}
		if(!Character.isLetter(s.charAt(0))) {
			System.out.println("O primeiro carater do nome n�o � uma letra( "+s+" ).");
			return false;
		}
		if(!Character.isLetterOrDigit(s.charAt(s.length()-1))) {
			System.out.println("O ultimo carater do nome n�o � uam letra nem um digito( "+s+" ).");
			return false;
		}
		if(s.length()>40) {
			System.out.println("O nome tem mais de 40 carateres( "+s+" ).");
			return false;
		}
		if(!s.matches("[a-zA-Z0-9_.@]+")) {
			System.out.println("O nome � constituido por carateres n�o permitidos( "+s+" ).");
			return false;
		}
		membros.add(s);
		return true;
	}
	
	public boolean contains(String s) { //Verifica se a famm�lia j� possui um elemento com o nome passado como argumento
		if(membros.contains(s)) {
			return true;
		}
		return false;
	}
	
	public boolean RemoveMembro(String s) {
		if(membros.contains(s)) {
			membros.remove(s);
			return true;
		}
		System.out.println("O nome n�o pode ser removido porque n�o pertence � familia( "+s+" ).");
		return false;
	}
	
	public boolean ocupa(int n) { //Verifica se a fam�lia ocupa o n� da parta n
		if(n>=this.portaInicial && n<= this.portaFinal) {
			return true;
		}
		return false;
	}


	public int getPortaInicial() {
		return portaInicial;
	}

	public int getPortaFinal() {
		return portaFinal;
	}
	
	public int getNumeroMembros() {
		return membros.size();
	}
	
	
	@Override
	public String toString() { //O toString()desta classe devolve apenas os nomes dos seus membros separados por um espa�o
		String s ="";
		for(String nome:this.membros) {
			s = s + nome + " ";
		}
		return s;
	}

	public int compareTo(Familia f) { //Objetos desta classe s�o comparados pelo n�mero de portas que ocupam;
		// TODO Auto-generated method stub
		int num = this.portaFinal-this.portaInicial+1;
		int num2 = f.getPortaFinal()-f.getPortaInicial()+1;
		
		return num-num2;
	}

}
