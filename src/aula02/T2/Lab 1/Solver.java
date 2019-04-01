
import java.util.ArrayList;
import java.util.List;

public class Solver {
	
	private List<String> soup;
	private List<String> words;
	private List<Pos> pos;
	
	public Solver(List<String> soup,List<String> words) {
		this.soup =soup;
		this.words = words;
		this.pos = new ArrayList<Pos>();
	}
	
	public void Solve() {
		int comp = this.soup.size();
		for(String word:words) {
			int len = word.length();
			int match = 0;
			List<Pos> matches = new ArrayList<Pos>();
			for(int i = 0; i<comp;i++) {
				for(int j=0; j<comp;j++) {
					if(soup.get(i).charAt(j)==word.charAt(0)) {
						if(i-len+1>=0 && matchUp(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"Up"));
						}
						if(i+len-1<comp && matchDown(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"Down"));
						}
						if(j+len-1<comp && matchRight(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"Right"));
						}
						if(j-len+1>=0 && matchLeft(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"Left"));
						}
						if(i-len+1>=0 && j+len-1<comp && matchUpRight(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"UpRight"));
						}
						if(i+len-1<comp && j+len-1<comp && matchDownRight(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"DownRight"));
						}
						if(i-len+1>=0 && j-len+1>=0 && matchUpLeft(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"UpLeft"));
						}
						if(i+len-1<comp && j-len+1>=0 && matchDownLeft(soup,i,j,word)) {
							match++;
							matches.add(new Pos(word,i,j,"DownLeft"));
						}
					}
				}
			}
			if(match>1) {
				System.out.println("Ficheiro contém palavras que aparecem no puzle mais que uma vez.");
				System.exit(0);
			}
			else if(match==0) {
				System.out.println("Ficheiro contém palavras que não aparecem no puzle.");
				System.exit(0);
			}
			pos.add(matches.get(0));
		}
		
		for(Pos p : pos) {
			System.out.printf("%7s %7d %5d,%-4d %s \n", p.getWord(),p.getWord().length(), p.getX()+1, p.getY()+1,p.getDir());
		}
	}
	
	private boolean matchDown(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x+m).charAt(y) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean matchUp(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x-m).charAt(y) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	
	private boolean matchLeft(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x).charAt(y-m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}

	private boolean matchRight(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x).charAt(y+m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	private boolean matchUpRight(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x-m).charAt(y+m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	private static boolean matchDownRight(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x+m).charAt(y+m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	private boolean matchUpLeft(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x-m).charAt(y-m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}
	private static boolean matchDownLeft(List<String> list,int x,int y,String word) {
		int match = 1;
		for(int m = 1;m<word.length();m++) {
			if(list.get(x+m).charAt(y-m) == word.charAt(m)) {
				match++;
			}
		}
		if(match == word.length()) {
			return true;
		}
		return false;
	}

}
