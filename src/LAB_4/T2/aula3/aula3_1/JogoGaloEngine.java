package aula3.aula3_1;

import java.lang.Math;

public class JogoGaloEngine implements JGaloInterface{

	private char [] [] matrix;
	private char player;
	private char winner;

	public JogoGaloEngine() {
		this.player = (char) ((Math.random() > 0.5) ? 'X' : 'O');
		this.matrix = new char [3] [3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = '!';
			}
		}
		this.winner = '!';
	}

	public JogoGaloEngine(char player) {
		this.player = player;
		this.matrix = new char [3] [3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = '!';
			}
		}
		this.winner = '!';
	}

	@Override
	public char getActualPlayer() {
		return player;
	}

	@Override
	public boolean setJogada(int lin, int col) {
		if (matrix[lin - 1][col - 1] != '!') {
			return false;
		}
		matrix[lin - 1][col - 1] =  player;
		if (player == 'X') {
			player = 'O';
		}
		else {
			player = 'X';
		}
		return true;
	}

	@Override
	public boolean isFinished() {
		int x = 0, y = 0;
		char n = '!';
		boolean isOver = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] != '!') {
					n = matrix[i][j];
					y = i;
					x = j;
					if (checkRigth(matrix, x, y,  n) || checkDown(matrix, x, y, n)
							|| checkDiagonalRigth(matrix, x, y, n)	|| checkDiagonalLeft(matrix, x, y, n)) {
						this.winner = (char)n;
						return true;
					}
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == '!') {
					isOver = false;
				}
			}
		}

		if (isOver) {
			this.winner = ' ';
			return true;
		}
		return false;
	}

	@Override
	public char checkResult() {
		return this.winner;
	}

	public static boolean checkRigth(char [] [] matrix, int x, int y, char n) {
		int i = 1;
		boolean bool = false;
		while (true) {
			if (x + i >= 3) {
				if (i == 3) {
					bool = true;
				}
				break;
			}

			if (matrix[y][x + i] == n) {
				i++;
				continue;
			}
			else {
				break;
			}
		}
		return bool;
	}

	public static boolean checkDown(char [] [] matrix, int x, int y, char n) {
		int i = 1;
		boolean bool = false;
		while (true) {
			if (y + i >= 3) {
				if (i == 3) {
					bool = true;
				}
				break;
			}
			if (matrix[y + i][x] == n) {
				i++;
				continue;
			}
			else {
				break;
			}
		}
		return bool;
	}

	public static boolean checkDiagonalRigth(char [] [] matrix, int x, int y, char n) {
		int i = 1;
		boolean bool = false;
		while (true) {
			if (x + i >= 3 || y + i >= 3) {
				if (i == 3) {
					bool = true;
				}
				break;
			}
			if (matrix[y + i][x + i] == n) {
				i++;
				continue;
			}
			else {
				break;
			}
		}
		return bool;
	}

	public static boolean checkDiagonalLeft(char [] [] matrix, int x, int y, char n) {
		int i = 1;
		boolean bool = false;
		while (true) {
			if (x - i < 0 || y + i >= 3) {
				if (i == 3) {
					bool = true;
				}
				break;
			}
			if (matrix[y + i][x - i] == n) {
				i++;
				continue;
			}
			else {
				break;
			}
		}
		return bool;
	}
}