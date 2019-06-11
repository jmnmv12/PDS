package ExamePratico.Aula11;

public class Context {
    private Strategy st;

    public Context(Strategy st) {
        this.st = st;
    }

    public void setSt(Strategy st) {
        this.st = st;
    }

    public Telemovel[] work(Telemovel [] arr, String atributo ){
        return st.sort(arr,atributo);
    }
}
