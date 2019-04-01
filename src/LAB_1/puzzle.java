package LAB_1;



import java.util.ArrayList;
import java.util.List;

public class puzzle {
    private List<String> sopa;
    private List<String> sopa_transposte;
    List<String> stream= null;

    private static final int[] directions_X=new int[]{0,0,1,-1,1,1,-1,-1};
    private static final int[] directions_Y=new int[]{1,-1,0,0,1,-1,1,-1};
    private String final_output;

    public puzzle(List <String> stream) {
        this.stream=stream;

        this.sopa= new ArrayList<>();
        this.sopa_transposte= new ArrayList<String>();
        list_words lw= new list_words();

        //System.out.println(stream);
        for (String line:stream
        ) {
            if(checkletter(line)==false){
                System.out.println("The file cant contain digits");
                System.exit(1);
            }

            if(separate(line) & !line.trim().isEmpty()) add_puzzle(line);
            else if(!line.trim().isEmpty())
                lw.add_list(line.trim());
        }
        System.out.println(lw.get_list());
        //check puzzle

        if(checkpuzzle_1()==false){
            System.out.println("The puzzle must be a square");
            System.exit(1);
        }
        if(checkpuzzle_2()==false){
            System.out.println("The max size is 60x60");

            System.exit(1);
        }

        if(checkpuzzle_3()==false){
            System.out.println("All soup letters must be uppercase");

            System.exit(1);
        }

        //check list

        if(lw.checklist_1()==false){
            System.out.println("The length of the words in the list must be 3 or more chars");
            System.exit(1);
        }

        if(lw.checklist_2()==false){
            System.out.println("The words in the list must be lower case or a mix between lower case and upper case");
            System.exit(1);
        }

        if(lw.checklist_3()==false){
            System.out.println("The words in the list must be alphabetic");
            System.exit(1);
        }

        lw.checklist_4();


        for (String line:lw.get_list()
        ) {
            checkpuzzle(line);
        }


    }

    public void add_puzzle (String line){
        sopa.add(line);

    }

    public  boolean checkletter(String b){
        if(b.chars().anyMatch(Character::isDigit))
            return false;

        return true;
    }

    public  boolean separate(String b){
        return b.matches("[A-Z]+");
    }

    public boolean checkpuzzle_1(){
        int n_lines=sopa.size();
        for (String line:sopa
                ) {
            //System.out.println(line.length());
            //System.out.println(sopa.size());
            if(line.length()!=n_lines)

                return false;

        }
        return true;
    }

    public boolean checkpuzzle_2( ){
        int count=0;
        for (String line:sopa
                ) {
            count+=line.length();
        }

        if(count>60*60)
            return false;
        return true;
    }

    public boolean checkpuzzle_3( ){
        int count=0;
        for (String line:sopa
                ) {
             if(! line.matches("[A-Z]+"))
                 return false;
        }


        return true;
    }




    public void checkpuzzle(String line){

        int count=0;
        boolean exists=false;



            for (String line_a: sopa
                    ) {
                count++;

                for (int j=0;j<line_a.length();j++){
                    char c=line_a.toLowerCase().charAt(j);
                    //System.out.println(c);
                    //System.out.println(line.charAt(0));
                    if(c==line.toLowerCase().charAt(0)){

                        exists=checkDirections(count-1,j,line.toLowerCase(),exists);
                    }
                }



            }
        if(exists==false){
            System.out.println("The word: "+line+" is not in the jumble");
            System.exit(1);
        }


        count=0;






    }


    public boolean checkDirections(int initX,int initY, String word,boolean found){
        int x,y;
        boolean match=false;


        for (int dirIndex=0;dirIndex<directions_X.length;dirIndex++){
            match=true;
            for(int charIndex=0;charIndex<word.length();charIndex++){
                //move numa certa direção
                x=initX+directions_X[dirIndex]*charIndex;
                y=initY+directions_Y[dirIndex]*charIndex;
                if (x<0|| y<=0 || x>=sopa.size()||y>=sopa.size()||sopa.get(x).toLowerCase().charAt(y)!=word.charAt(charIndex))
                {
                    match=false;//if match=false we go tho the next char in line
                    break;
                }


            }

            if(match){
                String direction="";
                switch (directions_X[dirIndex]+directions_Y[dirIndex]){
                    case 2: direction="downright";break;

                    case -2: direction="upleft";break;

                    case 1:{
                        if (directions_X[dirIndex]==1)
                            direction="down";
                        else
                            direction="right";
                    }break;
                    case -1:{
                        if(directions_X[dirIndex]==-1)
                            direction="up";
                        else
                            direction="left";
                    }break;
                    case 0:{
                        if(directions_X[dirIndex]==1)
                            direction="downleft";
                        else
                            direction="upright";
                    }break;

                }
                int final_x=initX+1;
                int final_y=initY+1;

                if(found){
                    System.out.println("The word can only appear once in the puzzle");
                    System.exit(1);
                }
                this.final_output+=String.format("%-10s %-3d %d,%-5d %-13s \n",word.toUpperCase(),word.length(),final_x,final_y,direction);

                found=true;
                break;
            }

        }

        return found;
    }

    public void print_output(){
        System.out.println(this.final_output.replace("null",""));
    }



}
