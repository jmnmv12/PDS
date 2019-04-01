
public class Pos {
	private int x;
	private int y;
	private String dir;
	private String word;
	
	
	public Pos(String word,int x, int y, String dir) {
		this.word = word;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}


	public String getWord() {
		return word;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public String getDir() {
		return dir;
	}
	

}
