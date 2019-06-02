package ExamePratico.Aula5;

public class ContainerFactory {
    public static Container createContainerFor(Commodity c){
        if(c.getState()==State.Liquid){
            if(c.getTemperature()==Temperature.WARM)
                return new TermicBottle();
            else
                return new PlasticBottle();
        }
        else if(c.getState()==State.Solid){
            if(c.getTemperature()==Temperature.WARM)
                return new Tupperware();
            else
                return new PlasticBag();
        }

        return new PlasticBag();
    }
}
