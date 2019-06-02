package ExamePratico.Aula5;

public class BeverageFactory {
    public static Commodity createBeverage(Temperature temp){
        if(temp==Temperature.COLD){
            return new FruitJuice("Orange");
        }
        else if(temp==Temperature.WARM){
            return new Milk();
        }
        return new Milk();
    }
}
