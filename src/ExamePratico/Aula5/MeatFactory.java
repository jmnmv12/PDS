package ExamePratico.Aula5;

public class MeatFactory {
    public static Commodity createMeat(Temperature temp){
        if(temp==Temperature.WARM)
            return new Pork();
        else if(temp==Temperature.COLD)
            return new Tuna();
        return new Pork();
    }
}
