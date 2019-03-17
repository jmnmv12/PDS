package LAB_3;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Street {
    private Set<String> all_users;
    private Map<String,String> mapa;
    private int max_door;

    public Street() {
        this.all_users=new TreeSet<>();
        this.mapa = new TreeMap<String, String>(
                new Comparator<String>() {


                    @Override
                    public int compare(String o1, String o2) {
                        String[] doors_a = o1.split("-");
                        int doors_a_1 = Integer.parseInt(doors_a[0]);
                        int doors_a_2 = Integer.parseInt(doors_a[1]);
                        int interval_a = doors_a_2 - doors_a_1;
                        int sum_a=doors_a_1+doors_a_2;

                        String[] doors_b = o2.split("-");
                        int doors_b_1 = Integer.parseInt(doors_b[0]);
                        int doors_b_2 = Integer.parseInt(doors_b[1]);
                        int interval_b = doors_b_2 - doors_b_1;
                        int sum_b=doors_b_1+doors_b_2;

                        int final_result = interval_a - interval_b;

                        if (final_result==0){
                            if(sum_a==sum_b)
                                return 0;
                            else if(sum_a<sum_b)
                                return +1;
                            else
                                return -1;
                        }



                        return -final_result;
                    }
                });

        this.max_door = 0;
    }

    public void readFile(String filename) throws IOException {
        List<java.lang.String> stream = null;


        Path path = Paths.get(filename);
        stream = Files.readAllLines(path);
        Iterator<String> iterador_file = stream.iterator();
        while (iterador_file.hasNext()) {
            addUser(iterador_file.next());
        }


    }

    public void addUser(String line) {
        String descricao = "";
        String name = "";
        String doors = "";
        int door1 = 0;
        int door2 = 0;

        if (line.contains(">"))
            descricao = line.replace(">", "");
        else {
            String tokens[] = line.split("\\s+");
            doors = tokens[0];
            String tokens_b[] = doors.split("-");

            if (tokens_b.length > 1) {
                door1 = Integer.parseInt(tokens_b[0]);
                door2 = Integer.parseInt(tokens_b[1]);
            }
            if (door2 > max_door)
                this.max_door = door2;
            name = tokens[1];
            Check(name); //verificações do nome
            if (mapa.containsKey(doors )) {
                String temp = mapa.get(doors);
                if (temp.contains(name)){
                    System.err.println("Name already exists");
                    System.exit(1);
                }
                temp += " " + name;
                mapa.put(doors, temp);
            } else {
                mapa.put(doors , name);

            }


        }
        this.all_users.add(name+" "+door1+" "+door2);


    }

    public void Map() {

        for(int i=1;i<=this.max_door;i++){
            String line=""+i;
            for(Map.Entry<String,String> entry: mapa.entrySet()){
                String [] doors=entry.getKey().split("-");

                int door1=Integer.parseInt(doors[0]);
                int door2=Integer.parseInt(doors[1]);
                if(intervallContains(door1,door2,i)){
                    line+=" : "+entry.getValue();
                }
            }
            System.out.println(line);
        }
    }

    public void Remove(String name_remove) {

        for(Map.Entry<String,String> entry: mapa.entrySet()){
            String [] doors=entry.getKey().split("-");
            String names=entry.getValue();

            if(names.contains(name_remove)){
                names=names.replace(name_remove,"");
            }
        mapa.put(entry.getKey(),names);



        }

    }

    public void Look (String name_search) {

        for(Map.Entry<String,String> entry: mapa.entrySet()){
            String [] doors=entry.getKey().split("-");
            String door1=doors[0];
            String door2=doors[1];
            String names=entry.getValue();

            if(names.contains(name_search))
                System.out.println(door1+" "+door2+" : "+ names);



        }

    }

    public void List () {

        Iterator it=all_users.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public void Check (String name) {
        boolean check=true;
        //verficaçao 1
        if(!name.matches("[A-Za-z0-9 @ . _]+")){
            System.err.println("The name contains only letters,digits or @ . _");
            System.exit(1);
        }


        //verificaçao 2
        if(name.length()>40){
            System.err.println("The maximum length is 40");
            System.exit(1);
        }
        //verificaçao 3
        if (!Character.isLetter(name.toCharArray()[0])){
            System.err.println("The first char must be a letter");
            System.exit(1);
        }
        if (name.toCharArray()[name.length()-1]=='@' || name.toCharArray()[name.length()-1]=='.' || name.toCharArray()[name.length()-1]=='_'){
            System.err.println("The name cannot end with a symbol");
            System.exit(1);
        }


    }

    public void Clear () {

        this.all_users.clear();
        this.mapa.clear();
        this.max_door=0;

    }



    public static boolean intervallContains(int low, int high, int n) {
        return n >= low && n <= high;


    }

}
