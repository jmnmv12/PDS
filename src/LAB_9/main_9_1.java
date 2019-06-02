package LAB_9;
import java.util.Iterator;
import java.util.ListIterator;

public class main_9_1 {
    public static void main(String[] args) {
        VectorGeneric<Integer> vp = new VectorGeneric<>();
        for (int i=0; i<10; i++)
            vp.addElem(i);
        Iterator<Integer> vec = vp.Iterator();
        ListIterator<Integer> ListVec=vp.ListIterator();
        ListIterator<Integer> ListVecIndice=vp.ListIterator(3);

        System.out.println( "Normal Iterator" );

        while ( vec.hasNext() )
            System.out.println( vec.next() );
        System.out.println( "List Iterator (next)" );

        while (ListVec.hasNext())
            System.out.println( ListVec.next() );
        System.out.println( "List Iterator(previous)" );

        while (ListVec.hasPrevious())
            System.out.println( ListVec.previous() );


        System.out.println( "List Iterator with index (next)" );

        while (ListVecIndice.hasNext())
            System.out.println( ListVecIndice.next() );

    }
}
