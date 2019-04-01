package LAB_1;

<<<<<<< HEAD
=======
import sun.dc.pr.PRError;
>>>>>>> 66e2c46a47981e8d873fc2ad418ee3f37b3a17cf

import java.util.*;

public class PuzzleGenerator {
    private List<String> list_solutions;
    private List<String> puzzle;
    private List<String> listDirections;
    private List<String> check;
    private int size;
    private static final int[] directions_X=new int[]{0,0,1,-1,1,1,-1,-1};
    private static final int[] directions_Y=new int[]{1,-1,0,0,1,-1,1,-1};
    private String [] directions_name= new String [] {"Right", "Left", "Down", "Up", "DownRight","DownLeft","UpRight","UpLeft"};
    private Map<String, int[]> directions_map;
    private Stack<int []> lastDir;
    private puzzle pz;


    public PuzzleGenerator( int size, List <String> stream) {
        this.list_solutions = new ArrayList<>();
        this.puzzle=new ArrayList<>();
        this.listDirections=new ArrayList<>();
        this.directions_map=new TreeMap<String, int[]>();
        this.lastDir=new Stack<>();
        this.size = size;


        for (String line:stream
        ) {
            if(checkletter(line)==false){
                System.out.println("The file cant contain digits");
                System.exit(1);
            }

            add_list(line);
        }


        for(int i=0;i<size;i++){
            this.puzzle.add( new String(new char[this.size]).replace("\0", ";"));
        }

        for(int j=0;j< this.directions_name.length;j++){
            this.listDirections.add(directions_name[j]);
            int array1 [] =new int []{directions_X[j],directions_Y[j]};
            this.directions_map.put(directions_name[j],array1);
        }

        generate();
        this.check=puzzle;

        for (String line_c: stream
             ) {
            this.check.add(line_c);
        }


        //this.pz=new puzzle(check);

    }

    public boolean checkletter(String b){
        if(b.chars().anyMatch(Character::isDigit))
            return false;

        return true;
    }

    public void add_list(String line){
        String [] tokens = line.split("[,|;|\\s+]");

        for(String s:tokens){

            list_solutions.add(s.trim());
        }
        //System.out.println(list_solutions);


    }


    public List<String> getList_solutions() {
        return list_solutions;
    }

    public List<String> getPuzzle() {
        return puzzle;
    }

    public void generate(){
        //first insert the words in the list
        Random rand= new Random();
        int x,y,initX=0,initY=0;
        for (String line:list_solutions
             ) {
            boolean check_2=false;


            while(check_2==false){
                initX=rand.nextInt(this.size);
                initY=rand.nextInt(this.size);
                while(initY==initX){
                    initY=rand.nextInt(this.size);
                }

                Collections.shuffle(this.listDirections);
                for(int dirIndex=0;dirIndex<directions_X.length;dirIndex++){
                    //rand_dir=rand.nextInt(directions_X.length);
                    check_2=true;
                    String op=this.listDirections.get(dirIndex);
                    int [] arr1=this.directions_map.get(op);
                    int direcX=arr1[0], direcY=arr1[1];

                    for (int charIndex = 0; charIndex < line.length(); charIndex++) {
                        //move numa certa direção
                        x = initX + direcX * charIndex;
                        y = initY + direcY * charIndex;
                        int [] cord={x,y};
                        this.lastDir.push(cord);
                        if (x < 0 || y <= 0 || x >= this.size || y >= this.size || (this.puzzle.get(x).toLowerCase().charAt(y) !=';' & this.puzzle.get(x).toLowerCase().charAt(y)!=line.charAt(charIndex) )) {
                            //rand_dir=rand.nextInt(directions_X.length);
                            //if(this.puzzle.get(x).toLowerCase().charAt(y)!='a' ){
                            check_2=false;
                            break;
                            //}

                        }
                    /*else{
                        char [] line_chars=this.puzzle.get(x).toCharArray();
                        //System.out.println(x);
                        line_chars[y]=line.charAt(charIndex);
                        this.puzzle.set(x,String.valueOf(line_chars));

                    }*/


                    }
                    if(check_2){
                        for (int charIndex = line.length()-1; charIndex >=0; charIndex--) {
                            int [] last_cord=this.lastDir.pop();

                            int y_cord=last_cord[1], x_cord=last_cord[0];
                            char [] line_chars=this.puzzle.get(x_cord).toCharArray();
                            //System.out.println(y_cord);
                            line_chars[y_cord]=line.charAt(charIndex);
                            this.puzzle.set(x_cord,String.valueOf(line_chars));


                        }
                        break;

                    }

                }


            }


            //int rand_dir;







        }
        finalize_generate();
    }

    private void finalize_generate (){

        Random rand= new Random();
        int rand_dir;
        for (int j=0;j<this.size;j++){
            for (int k=0;k<this.size;k++){
                if (this.puzzle.get(j).toLowerCase().charAt(k) ==';' ) {
                    char c = (char) (rand.nextInt(26) + 'a');
                    char [] line_chars=this.puzzle.get(j).toCharArray();
                    //System.out.println(y_cord);
                    line_chars[k]=c;
                    this.puzzle.set(j,String.valueOf(line_chars).toUpperCase());

                }

            }
        }

    }


}
