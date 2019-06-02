package LAB_11;

public class main_Telemovel {

    public static void main(String[] args) {
        Telemovel [] teles={
                new Telemovel("A4",20.30,2,12),
                new Telemovel("A4",40.30,5,20),
                new Telemovel("A4",10.30,1,30)
         };
        for (Telemovel b:teles
             ) {
            System.out.println(b);

        }
        //sorted by price
        SelectionSort sl=new SelectionSort();
        BubbleSort bs=new BubbleSort();

        Telemovel[] sorted =sl.sort_alg(teles,"preco");
        System.out.println("Sorted by price");
        for (Telemovel b:sorted
        ) {
            System.out.println(b);

        }

        sorted =sl.sort_alg(teles,"memoria");
        System.out.println("Sorted by memory");
        for (Telemovel b:sorted
        ) {
            System.out.println(b);

        }

        sorted =bs.sort_alg(teles,"memoria");
        System.out.println("Sorted by memory (buble sort)");
        for (Telemovel b:sorted
        ) {
            System.out.println(b);

        }
    }
}
