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
        String option="";


        long start = System.currentTimeMillis();




        try{
            String caminho=args[0];

            if(args.length==2){
                caminho=args[1];
                option=args[0];
            }
            Path path = Paths.get(caminho);
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Pass a valid filename by argument USAGE: (optional)-timing filename");
            System.exit(1);
        }


        //System.out.println(stream);
        puzzle pz = new puzzle( stream);
        long elapsedTime = System.currentTimeMillis() - start;
        if(option.equals("-timing"))
            System.out.println(elapsedTime*0.001);
        pz.print_output();



    }




}
