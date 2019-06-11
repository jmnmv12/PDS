package ExamePratico.Aula7;

import java.util.ArrayList;
import java.util.Iterator;

public class TermFilter extends ReaderDecorator {
    private ArrayList<String> arr=new ArrayList<>();
    private Iterator<String> it;
    public TermFilter(ReaderInterface r) {
        super(r);

        while(super.hasNext()){
          String [] temp=super.next().split("[^a-zA-Z]+");
            for (String b:
                 temp) {
                arr.add(b);

            }
        }
        it=arr.listIterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public String next() {
        return it.next();
    }
}
