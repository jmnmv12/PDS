package LAB_5;

public class ContainerFactory implements Container {

    public static ContainerFactory createContainerFor(Commodity cm){
        return new ContainerFactory(cm);
    }

    public ContainerFactory(Commodity cm) {

    }

    @Override
    public boolean placeCommodity(Commodity c) {
        return super.placeCommodity(c);
    }
}
