package ExamePratico.Aula5;

public class FruitJuice implements Commodity {
    private Temperature temp=Temperature.COLD;
    private State st=State.Liquid;
    private String outro;

    public FruitJuice(String outro) {
        this.outro = outro;
    }

    @Override
    public Temperature getTemperature() {
        return temp;
    }

    @Override
    public State getState() {
        return st;
    }
}
