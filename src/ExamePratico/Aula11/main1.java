package ExamePratico.Aula11;

public class main1 {


    public static void main(String[] args) {
        Telemovel t1=new Telemovel("A4",1200,2,20);
        Telemovel t2=new Telemovel("A20",1400,1,12);
        Telemovel t3=new Telemovel("A10",1500,5,50);
        Telemovel [] arr={t1,t2,t3};
        Strategy st=new MergeSort();
        Context c1=new Context(st);
        Telemovel [] sorted=c1.work(arr,"memoria");
        for (Telemovel a:
             sorted) {
            System.out.println(a);

        }


        sorted=c1.work(arr,"processador");
        for (Telemovel a:
                sorted) {
            System.out.println(a);

        }


    }


}
