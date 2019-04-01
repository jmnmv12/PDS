package LAB_5;

public class BeverageFactory implements Commodity {

    private Temperature temp;
    private State st=State.LIQUID;
    public static BeverageFactory createBeverage(Temperature temp){

        return new BeverageFactory(temp);
    }


    private BeverageFactory(Temperature temp) {
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
