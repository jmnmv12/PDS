package LAB_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class WSGenerator  {

    public static void main(String[] args) throws IOException {
        List<String> stream= null;
        Scanner sc= new Scanner(System.in);
        try{
            Path path = Paths.get("wordlist_1.txt");
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }

        System.out.println(stream);
        System.out.println("Size of the puzle: ");
        int n= sc.nextInt();
        sc.close();

        PuzzleGenerator pg= new PuzzleGenerator(n);
        for (String line:stream
                ) {
            if(checkletter(line)==false){
                System.out.println("The file cant contain digits");
                System.exit(1);
            }

            pg.add_list(line);
        }

        pg.generate();

        //check list

        /*if(lw.checklist_1()==false){
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

        lw.checklist_4();*/
    }

    public static boolean checkletter(String b){
        if(b.chars().anyMatch(Character::isDigit))
            return false;

        return true;
    }




}
