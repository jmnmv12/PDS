package ExamePratico.Aula5;

public class Milk implements Commodity {
    private Temperature temp=Temperature.WARM;
    private State st=State.Liquid;
    @Override
    public Temperature getTemperature() {
        return temp;
    }

    @Override
    public State getState() {
        return st;
    }
}
