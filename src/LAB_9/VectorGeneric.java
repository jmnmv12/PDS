package LAB_9;
import  java.util.NoSuchElementException;

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
                vec[--nElem] = null; // libertar último objecsto para o GC
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
    public java.util.Iterator<T> Iterator(){
        return (this).new VectorIterator<T>();

    };
    public java.util.ListIterator<T> ListIterator(){
        return (this).new ListIterator<T>();
    }
    public java.util.ListIterator<T> ListIterator(int indice){
        return (this).new ListIterator<T>(indice);
    }

    private class ListIterator<K> implements java.util.ListIterator<K> {
        private int indice;
        ListIterator() {
            indice = 0;
        }
        ListIterator(int i){
            indice=i;
        }
        public boolean hasNext() {
            return (indice < nElem);
        }
        public boolean hasPrevious() {
            return (indice>0);
        }

        @Override
        public K previous() {
            if (hasPrevious()){
                return (K)VectorGeneric.this.vec[--indice];
            }

            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public int nextIndex() {
            if(hasNext()){

                return indice+1;
            }
            else
                return nElem;
        }

        @Override
        public int previousIndex() {
            if(hasPrevious()){

                return indice-1;
            }
            else
                return -1;
        }

        public K next() {
            if (hasNext())
                return (K)VectorGeneric.this.vec[indice++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }
        public void remove() { // default since Java 8
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }

        @Override
        public void set(K k) {
            throw new UnsupportedOperationException("Operacao nao suportada!");

        }

        @Override
        public void add(K k) {
            throw new UnsupportedOperationException("Operacao nao suportada!");

        }
    }

    private class VectorIterator<K> implements java.util.Iterator<K> {
        private int indice;
        VectorIterator() {
            indice = 0;
        }

        public boolean hasNext() {
            return (indice < nElem);
        }
        public K next() {
            if (hasNext())
                return (K)VectorGeneric.this.vec[indice++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }
        public void remove() { // default since Java 8
            throw new UnsupportedOperationException("Operacao nao suportada!");
        }
    }

}
