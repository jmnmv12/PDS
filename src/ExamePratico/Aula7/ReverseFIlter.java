package ExamePratico.Aula7;

public class ReverseFIlter extends ReaderDecorator {
    public ReverseFIlter(ReaderInterface r) {
        super(r);
    }

    @Override
    public String next() {

        return  new StringBuilder(super.next()).reverse().toString();
    }

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }
}
