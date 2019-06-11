package ExamePratico.Aula7;

public abstract class ReaderDecorator implements ReaderInterface {
    private ReaderInterface r;

    public ReaderDecorator(ReaderInterface r) {
        this.r = r;
    }

    @Override
    public boolean hasNext() {
        return  r.hasNext();
    }

    @Override
    public String next() {
        return r.next();
    }
}
