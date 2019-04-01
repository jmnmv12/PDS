
import java.util.*;

public class Generator {
	
	private char [][] soup;
	private int comp;
	private List<String> words;
	
	public Generator(int comp) {
		this.comp = comp;
		this.soup = new char[comp][comp];
		this.words = new ArrayList<String>();
	}
	
	public boolean addWord(String word) {
		word = word.toUpperCase();
		int len = word.length();
		int tries = 0;
		String[] directions = {"Up","Down","Left","Right","DownRight","DownLeft","UpRight","UpLeft"};
		if(len>this.comp) {
			return false;
		}
		while(tries<20) {
			this.words.add(word);
			int x = (int)(Math.random()*(this.comp-1));
			int y = (int)(Math.random()*(this.comp-1));
			String dir = directions[(int) (Math.random()*(directions.length-1))];
			if(dir=="Up" && checkUp(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x-m][y]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="Down" && checkDown(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x+m][y]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="Left" && checkLeft(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x][y-m]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="Right" && checkRight(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x][y+m]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="DownRight" && checkDownRight(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x+m][y+m]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="DownLeft" && checkDownLeft(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x+m][y-m]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="UpRigth" && checkUpRight(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x-m][y-m]=word.charAt(m);
				}
				return true;
			}
			else if(dir=="UpLeft" && checkUpLeft(x,y,word)) {
				for(int m = 0;m<word.length();m++) {
					soup[x-m][y-m]=word.charAt(m);
				}
				return true;
			}
		}
		return false;
	}
	
	public List<String> GenerateSoup(){
		String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		List<String> list = new ArrayList<String>();
		for(int x = 0;x<this.comp;x++) {
			String line="";
			for(int y = 0;y<this.comp;y++) {
				if (soup[x][y]==0) {
					char c = upperLetters.charAt((int)(Math.random()*26));
					line = line+c;
				}
				else {
					line = line+soup[x][y];
				}
			}
			list.add(line);
		}
		return list;
	}
	
	private boolean checkDown(int x, int y, String word) {
		int check = 0;
		if (x+word.length()-1>=this.comp) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x+m][y] == 0 || soup[x+m][y]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkUp(int x, int y, String word) {
		int check = 0;
		if (x-word.length()+1<0) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x-m][y] == 0 || soup[x-m][y]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkRight(int x, int y, String word) {
		int check = 0;
		if (y+word.length()-1>=this.comp) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x][y+m] == 0 || soup[x][y+m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkLeft(int x, int y, String word) {
		int check = 0;
		if (y-word.length()+1<0) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x][y-m] == 0 || soup[x][y-m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkUpLeft(int x, int y, String word) {
		int check = 0;
		if (x-word.length()+1<0 || y-word.length()+1<0) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x-m][y-m] == 0 || soup[x-m][y-m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkUpRight(int x, int y, String word) {
		int check = 0;
		if (x-word.length()+1<0 || y+word.length()-1>=this.comp) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x-m][y+m] == 0 || soup[x-m][y+m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkDownLeft(int x, int y, String word) {
		int check = 0;
		if (x+word.length()-1>=this.comp || y-word.length()+1<0) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x+m][y-m] == 0 || soup[x+m][y-m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean checkDownRight(int x, int y, String word) {
		int check = 0;
		if (x+word.length()-1>=this.comp || y+word.length()-1>=this.comp) {
			return false;
		}
		for(int m = 0;m<word.length();m++) {
			if(soup[x+m][y+m] == 0 || soup[x+m][y+m]==word.charAt(m)) {
				check++;
			}
		}
		if(check == word.length()) {
			return true;
		}
		return false;
	}

}
