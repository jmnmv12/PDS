package ExamePratico.Aula5;

public abstract class Container {
    protected Commodity commodity;
    public boolean placeCommodity(Commodity c){
        this.commodity = c;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"[" +
                "commodity=" + commodity +
                '}';
    }
}
