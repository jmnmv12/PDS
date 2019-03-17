package LAB_3;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        List<String> options = new ArrayList<>();
        Street rua = new Street();
        Scanner sc = new Scanner(System.in);
        String regex = ("[A-Za-z0-9 @ , _]+");
        boolean file = false;
        Iterator<String> iterator_file=null;
        List<java.lang.String> stream = null;
        if (args.length > 0) {
            file = true;


            try {
                Path path = Paths.get(args[0]);
                stream = Files.readAllLines(path);

            } catch (NoSuchFileException e) {
                System.out.println("File Not Found, the file should be in the project folder");

            }
            iterator_file = stream.iterator();
        }



        while (true) {
            String option="";
            if (!file) {
                System.out.println("Command:");
                option = sc.nextLine();

            }
            else {

                option=iterator_file.next();




            }
            String[] tokens = option.split("\\s+");
            options = Arrays.asList(tokens);
            ListIterator<String> iterator = options.listIterator();
            while (iterator.hasNext()) {
                iterator.set(iterator.next().toLowerCase());
            }


            if (options.contains("load")) {
                String filename = options.get(1);
                try {

                    rua.readFile(filename);

                } catch (NoSuchFileException e) {
                    System.out.println("File Not Found, the file should be in the project folder");
                }
            } else if (options.contains("map")) {
                rua.Map();
            } else if (options.contains("add")) {
                try {
                    rua.addUser(options.get(2) + "-" + options.get(3) + " " + options.get(1));

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("You must insert a door number");
                }
            } else if (options.contains("remove")) {
                rua.Remove(options.get(1));
            } else if (options.contains("lookup")) {
                rua.Look(options.get(1));
            } else if (options.contains("list")) {
                rua.List();
            } else if (options.contains("clear")) {
                rua.Clear();
            } else if (options.contains("quit")){
                break;
            } else{
                System.out.println("Wrong command");
            }




        }



    }
}