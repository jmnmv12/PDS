package LAB_1;

import java.util.ArrayList;
import java.util.List;

public class list_words {

    private List<String> list_solutions;


    public list_words() {
        this.list_solutions=new ArrayList<>();
    }

    public void add_list(String line){
        String [] tokens = line.split("[,|;|\\s+]");

        for(String s:tokens){

            list_solutions.add(s.trim());
        }
        //System.out.println(list_solutions);


    }

    public List<String> get_list(){
        return this.list_solutions;
    }

    public boolean checklist_1( ){

        for (String line:list_solutions
                ) {
            //System.out.println(line.length());
            if(line.length()<3 & !line.trim().isEmpty()){

                return false;
            }


        }

        return true;
    }

    public boolean checklist_2( ){

        boolean check=true;
        for (String line:list_solutions
                ) {
            //System.out.println(line.length());
            if(line.matches("[A-Z]+")){

                check=false;
            }


        }

        return check;
    }

    public boolean checklist_3( ){

        boolean check=true;
        for (String line:list_solutions
                ) {
            //System.out.println(line.length());
            check=line.chars().allMatch(Character::isAlphabetic);


        }

        return check;
    }

    public void checklist_4( ){
        int count,index;

        for (String line:list_solutions
                ) {
            count=0;
            for (String line_b:list_solutions
                 ) {
                index=line_b.indexOf(line);
                if (index!=-1){
                    //System.out.println(line);
                    count++;
                }
            }
            if(count>=2){
                System.out.println("The list of words cant contain duplicates");
                System.exit(1);            }


        }


    }

}
