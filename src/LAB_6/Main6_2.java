package LAB_6;
import java.util.ArrayList;
import java.util.List;

public class Main6_2 {
    public static void main(String[] args) {
        Contact c1=new Contact("Joao",913654912,"j@gmail.com");
        Contact c2=new Contact("Antonio",913674912,"j@gmail.com");
        Contact c3=new Contact("Mario",91364912,"j@gmail.com");

        List <Contact> agenda=new ArrayList<>();
        TxtStorage txtSt=new TxtStorage("../../teste.txt");

        Agenda test=new Agenda(txtSt);
        // Text files
        test.openAndLoad(txtSt);
        test.add(c1);
        System.out.println(test.getByName("Joao"));
        System.out.println(test.exist(c1));

        System.out.println(test.remove(c1));
        test.add(c3);
        test.saveAndClose();
        test.openAndLoad(txtSt);

        //Binary files

        BinaryStorage binSt= new BinaryStorage("../../teste.bin");

        Agenda testB=new Agenda(binSt);

        testB.openAndLoad(binSt);
        testB.add(c1);
        System.out.println(testB.getByName("Joao"));
        System.out.println(testB.exist(c1));

        System.out.println(testB.remove(c1));
        testB.add(c3);
        testB.saveAndClose();
        testB.openAndLoad(binSt);




    }

}
