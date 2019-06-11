package ExamePratico.Aula11;

import java.util.ArrayList;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        ArrayList<Livro> arr=new ArrayList<>();
        arr.add(new Livro("Java Anti-Stress","A123",2019,"Omodionah"));
        arr.add(new Livro("A Guerra dos Padrões","A153",2019,"Jorge Omel"));
        arr.add(new Livro("A Procura da Luz","A163",2019,"Khumatkli"));



        String op="";
        while (op!="Exit"){

            System.out.println("*** Bibliotreca ***");
            for (Livro l:
                    arr) {
                int i =arr.indexOf(l);
                System.out.println(i+1+"        "+l.getTitulo()+"       "+l.getAutor()+"        ["+l.getSt()+"]");
            }
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
            Scanner sc=new Scanner(System.in);
            op=sc.next();

            String [] tokens=op.split(",");
            int opLivro=Integer.parseInt(tokens[0]);
            int opOperacao=Integer.parseInt(tokens[1]);
            Livro temp=arr.get(opLivro-1);
            switch (opOperacao){
                case 1:{
                    temp.regista();
                    break;
                }
                case 2:{
                    temp.requesita();
                    break;
                }
                case 3:{
                    temp.devolve();
                    break;
                }
                case 4:{
                    temp.reservar();
                    break;
                }
                case 5:{
                    temp.cancelar();
                    break;
                }
            }

        }

    }
}
