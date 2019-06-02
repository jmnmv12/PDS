package LAB_7;

abstract  public class ReaderDecorator implements Reader {

    protected Reader rd;

    public ReaderDecorator(Reader rd) {
        this.rd = rd;
    }

    @Override
    public String next() {
        return rd.next();
    }

    @Override
    public boolean hasNext() {
        return rd.hasNext();
    }
}
