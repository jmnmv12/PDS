package aula3;

public class JogoGaloIntern  implements JGaloInterface{
	
	private char[][] grid;
	private char Player = 'X';//Guarda o jogador atual
	private int plays = 0; //Guarda o numero de jogadas feitas
	
	public JogoGaloIntern() {
		this.grid = new char[3][3]; //Inicializa a grelha do jogo
	}

	@Override
	public char getActualPlayer() { //retorna o jogador atual
		if(this.Player=='X') {
			return 'X';
		}
		else {
			return 'O';
		}
	}

	@Override
	public boolean setJogada(int lin, int col) { //Executa uma jogada
		if(grid[lin-1][col-1]==0) { //Verifica se esse lugar da grelha esta vazio(vai esta porque a aplicação visual não permite selecionar o mesmo quadrado duas vezes)
			grid[lin-1][col-1] = this.Player;
			if(this.Player=='X') { //Muda o jogador para ooutro apos executar a jogada
				this.Player = 'O';
			}
			else {
				this.Player = 'X';
			}
			this.plays++; //Incrementa o número de jogadas
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isFinished() {
		
		if(this.plays<5) { //É impossivel acabar um jogo com menos de 5 jogadas
			return false;
		}
		if(this.plays==9) //O jogo é automaticamente terminado se forem feitas 9 jogadas(a grelha só tem 9 quadrados)
			return true;
		for(int i =0;i<3;i++) {
			if(grid[i][0]!=0 && grid[i][0]==grid[i][1] && grid[i][0]==grid[i][2]) { //Verifica se alguma linha está completa com o mesmo simbolo
				return true;
			}
			if(grid[0][i]!=0 && grid[0][i]==grid[1][i] && grid[0][i]==grid[2][i]) { //Verifica se alguma coluna está completa com o mesmo simbolo
				return true;
			}
		}
		if(grid[0][0]!=0 && grid[0][0]==grid[1][1] && grid[0][0]==grid[2][2]) { //Verifica as diagonais estão completas com o mesmo simbolo
			return true;
		}
		if(grid[0][2]!=0 && grid[0][2]==grid[1][1] && grid[0][2]==grid[2][0]) {
			return true;
		}
		return false;
	}

	@Override
	public char checkResult() { //Codigo é equivalente a parte do da funçãoisFinished(), mas devolve o simbolo de um jogador no caso de alguém ter ganho
		for(int i =0;i<3;i++) {
			if(grid[i][0]!=0 && grid[i][0]==grid[i][1] && grid[i][0]==grid[i][2]) {
				return grid[i][0];
			}
			if(grid[0][i]!=0 && grid[0][i]==grid[1][i] && grid[0][i]==grid[2][i]) {
				return grid[0][i];
			}
		}
		if(grid[0][0]!=0 && grid[0][0]==grid[1][1] && grid[0][0]==grid[2][2]) {
			return grid[0][0];
		}
		if(grid[0][2]!=0 && grid[0][2]==grid[1][1] && grid[0][0]==grid[2][0]) {
			return grid[0][2];
		}
		return ' ';
	}

}
