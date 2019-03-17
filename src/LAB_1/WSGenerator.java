package LAB_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

public class WSGenerator  {

    public static void main(String[] args) throws IOException {
        List<String> stream= null, puzzle, solution;
        boolean print=true;

        String caminho_out=null;
        Path path_out=null;
        int size=0;

        try{
            if(args.length==3){

                caminho_out=args[2];
                print=false;
            }
            String caminho=args[0];
            size=Integer.parseInt(args[1]);


            Path path = Paths.get(caminho);

            if (!print)
                path_out=Paths.get(caminho_out);

            stream= Files.readAllLines(path);


        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");
            System.exit(1);

        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Pass a valid filename by argument and a size for the puzzle, USAGE: filename size (optional)output_filename");
            System.exit(1);
        }




        PuzzleGenerator pg= new PuzzleGenerator(size, stream);


        puzzle=pg.getPuzzle();
        if(!print){
            File file= new File(caminho_out);
            if (file.exists()) {
                file.delete(); //you might want to check if delete was successfull
            }

            Files.createFile(path_out);

        }

        for(String line : puzzle){
            if(!print){

                Files.write(path_out,(line+"\n").getBytes(),StandardOpenOption.APPEND);
            }

            else
                System.out.println(line);
        }






    }






}
