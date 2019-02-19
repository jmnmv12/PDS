package LAB_1;



import java.util.ArrayList;
import java.util.List;

public class puzzle {
    private List<String> sopa;
    private List<String> sopa_transposte;
    private int max_size;
    private static final int[] directions_X=new int[]{0,0,1,-1,1,1,-1,-1};
    private static final int[] directions_Y=new int[]{1,-1,0,0,1,-1,1,-1};

    public puzzle(int max_size) {
        this.max_size = max_size;
        this.sopa= new ArrayList<>();
        this.sopa_transposte= new ArrayList<String>();



    }

    public void add_puzzle (String line){
        sopa.add(line);

    }

   /* public void cr_transposte (){
        String temp="";

        int noOfElementsInList = sopa.get(0).length();
        for (int i = 0; i < noOfElementsInList; i++) {

            for (String row : sopa) {
                temp+=row.charAt(i);
            }
            sopa_transposte.add(temp);
            temp="";
        }
    }*/

    public boolean checkpuzzle_1(){
        int n_lines=sopa.size();
        for (String line:sopa
                ) {
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

    //first version of the solution
    /*public String checkpuzzle_horizontal(List<String> words){
        int count=0;
        int index=0;
        int index_reversed=0;
        String reversed="";
        for (String line:words
                ) {
            for(int i=line.length();i>0;i--){
                reversed+=line.charAt(i-1);
            }
            for (String line_a: sopa
                 ) {
                count++;
                //left to right
                index=line_a.indexOf(line.toUpperCase());
                if (index!=-1){
                    System.out.println(line+","+line.length()+","+count+","+index+"right");
                }

                //right to left
                //System.out.println(reversed);
                index_reversed=line_a.indexOf(reversed.toUpperCase());
                if (index_reversed!=-1){
                    index_reversed=index_reversed+reversed.length();
                    System.out.println(line+","+reversed.length()+","+count+","+index_reversed+"left");
                }


            }
            count=0;
            index=0;
            index_reversed=0;
            reversed="";
        }


        return "nothing";
    }

    public String checkpuzzle_vertical(List<String> words){
        cr_transposte();
        int count=0;
        int index=0;
        int index_reversed=0;
        String reversed="";
        for (String line:words
                ) {
            for(int i=line.length();i>0;i--){
                reversed+=line.charAt(i-1);
            }
            for (String line_a: sopa_transposte
                    ) {
                count++;
                //left to right
                index=line_a.indexOf(line.toUpperCase());

                if (index!=-1){
                    int local_index=index+1;
                    System.out.println(line+","+line.length()+","+local_index+","+count+"down");
                }

                //right to left
                //System.out.println(reversed);
                index_reversed=line_a.indexOf(reversed.toUpperCase());
                if (index_reversed!=-1){
                    index_reversed=index_reversed+reversed.length();
                    System.out.println(line+","+reversed.length()+","+index_reversed+","+count+"up");
                }


            }
            count=0;
            index=0;
            index_reversed=0;
            reversed="";
        }


        return "nothing";
    }*/


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
                System.out.format("%-10s %-3d %d,%d %-10s \n",word.toUpperCase(),word.length(),final_x,final_y,direction);

                found=true;
                break;
            }

        }

        return found;
    }

    //TO-DO check if all words are in the puzzle and just once



}
