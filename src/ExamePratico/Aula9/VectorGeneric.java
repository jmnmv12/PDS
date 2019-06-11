package ExamePratico.Aula9;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;
    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }
    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }
    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            vec = newArray;
        }
    }
    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0) // not last element
                    System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }
    public T getElem(int i) {
        return (T) vec[i];
    }

    public Iterator<T> Iterator(){
        return (this).new VectorIterator<T>();
    }

    public ListIterator<T> listIterator(){
        return (this).new VectorListIterator<T>();
    }

    public ListIterator<T> listIterator(int i){
        return (this).new VectorListIterator<T>(i);
    }

    private class VectorListIterator<K> implements ListIterator<K>{
        private int indice;

        public VectorListIterator(int indice) {
            this.indice = indice;
        }

        public VectorListIterator() {
            this.indice = 0;
        }



        @Override
        public boolean hasNext() {
            return indice<nElem;
        }

        @Override
        public K next() {
            if(hasNext()){
                return (K) VectorGeneric.this.vec[indice++];
            }
            throw new NoSuchElementException("only " +nElem+" elements");
        }

        @Override
        public boolean hasPrevious() {
            if(indice>=nElem)
                indice=nElem-1;
            return indice>=0;
        }

        @Override
        public K previous() {
            if(hasPrevious()){
                //System.out.println("indice: "+indice);
                return (K) VectorGeneric.this.vec[indice--];
            }
            throw new NoSuchElementException("only " +nElem+" elements");
        }

        @Override
        public int nextIndex() {
            int temp=indice;
            return temp++;
        }

        @Override
        public int previousIndex() {

            int temp=indice;
            return indice--;
        }

        @Override
        public void remove() {
            throw new NotImplementedException();
        }

        @Override
        public void set(K k) {
            throw new NotImplementedException();

        }

        @Override
        public void add(K k) {
            throw new NotImplementedException();

        }
    }

    private class VectorIterator<K> implements Iterator<K>{
        private int indice;



        public VectorIterator() {
            this.indice =0;
        }



        @Override
        public boolean hasNext() {
            return indice<nElem;
        }

        @Override
        public K next() {
            if(hasNext()){
                return (K) VectorGeneric.this.vec[indice++];
            }
            throw new NoSuchElementException("only " +nElem+" elements");
        }
    }
}
