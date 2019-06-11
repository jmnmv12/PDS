package ExamePratico.Aula9;

import java.util.Iterator;
import java.util.ListIterator;

public class main1 {
    public static void main(String[] args) {
        VectorGeneric<Integer> vt=new VectorGeneric<Integer>();
        vt.addElem(1);
        vt.addElem(2);
        vt.addElem(3);
        vt.addElem(4);
        vt.addElem(5);
        Iterator it=vt.Iterator();
        while (it.hasNext()){
            System.out.println("primeiro: "+it.next());
        }
        ListIterator lit=vt.listIterator();
        while (lit.hasNext()){
            System.out.println("segundo: "+lit.next());
        }

        while (lit.hasPrevious()){
            System.out.println("segundo: "+lit.previous());
        }
    }
}
