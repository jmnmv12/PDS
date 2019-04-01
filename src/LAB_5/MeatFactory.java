package LAB_5;

public class MeatFactory implements  Commodity {

    private Temperature temp;
    private State st=State.SOLID;
    public static MeatFactory createMeat(Temperature temp){

        return new MeatFactory(temp);
    }


    private MeatFactory(Temperature temp) {
        this.temp=temp;
    }

    @Override
    public State getState() {
        return this.st;
    }

    @Override
    public Temperature getTemperature() {
        return this.temp;
    }


}
