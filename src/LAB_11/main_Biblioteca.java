package LAB_11;

import java.util.Scanner;

public class main_Biblioteca {
    public static void main(String[] args) {
        Livro [] bib={
                new Livro("Java Anti-Stress",112,2019,"Omodionah"),
                new Livro("A Guerra dos Padrões",113,2018,"Jorge Omel"),
                new Livro("A procura da luz",111,2017,"Khumatkli"),
        };
        boolean check=true;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        printmenu(bib);
        String op = myObj.nextLine();
        while (check){
            String [] tokens =op.split(",");
            int pos=Integer.parseInt(tokens[1]);
            switch (tokens[0]){

                case "1":{
                    bib[pos-1].regista();
                    break;
                }
                case "2":{
                    bib[pos-1].requesita();
                    break;
                }
                case "3":{
                    bib[pos-1].devolve();
                    break;
                }
                case "4":{
                    bib[pos-1].reserva();
                    break;
                }
                case "5":{
                    bib[pos-1].cancelaReserva();
                    break;
                }
            }
            printmenu(bib);
            op=myObj.nextLine();

        }
    }
    public static void printmenu(Livro [] bib){
        System.out.println("*** Biblioteca ***");
        for(int i=0;i<bib.length;i++){
            System.out.println(i+1+"    "+bib[i].getTitulo()+"   "+bib[i].getAutor()+"  "+"["+bib[i].getCurrentState().toString()+"]");
        }
        System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
    }
}
