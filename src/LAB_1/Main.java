package LAB_1;

import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Word Search Solver");

        List<String> stream= null;
        try{
            Path path = Paths.get("sopa.txt");
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }
        //System.out.println(stream);
        puzzle pz = new puzzle(60*60);
        list_words lw= new list_words();



        for (String line:stream
             ) {
            if(checkletter(line)==false){
                System.out.println("The file cant contain digits");
                System.exit(1);
            }

            if(separate(line) & !line.trim().isEmpty()) pz.add_puzzle(line);
            else if(!line.trim().isEmpty())
                lw.add_list(line.trim());
        }

        //check puzzle

        if(pz.checkpuzzle_1()==false){
            System.out.println("The puzzle must be a square");
            System.exit(1);
        }
        if(pz.checkpuzzle_2()==false){
            System.out.println("The max size is 60x60");

            System.exit(1);
        }

        if(pz.checkpuzzle_3()==false){
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
        //find words

        //pz.checkpuzzle_horizontal(lw.get_list());
        //pz.checkpuzzle_vertical(lw.get_list());

        for (String line:lw.get_list()
             ) {
            pz.checkpuzzle(line);
        }











    }

    public static boolean checkletter(String b){
        if(b.chars().anyMatch(Character::isDigit))
            return false;

        return true;
    }

    public static boolean separate(String b){
        return b.matches("[a-zA-Z]+");
    }


}
