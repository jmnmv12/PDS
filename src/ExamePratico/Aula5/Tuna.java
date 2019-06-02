package ExamePratico.Aula5;

public class Tuna implements Commodity {
    private Temperature temp=Temperature.COLD;
    private State st=State.Solid;
    @Override
    public Temperature getTemperature() {
        return temp;
    }

    @Override
    public State getState() {
        return st;
    }
}
