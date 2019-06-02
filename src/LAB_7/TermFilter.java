package LAB_7;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TermFilter extends  ReaderDecorator {
    private List<String> templist;
    private ListIterator<String> iter;


    public TermFilter(Reader rd) {
        super(rd);
        this.templist=new ArrayList<>();


        while (super.hasNext()){
            String [] tokens=super.next().split(" ");
            for (String a:tokens) {
                templist.add(a);

            }
        }
        this.iter=templist.listIterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public String next() {
        return iter.next();
    }
}
