package LAB_5;

public class LunchDirector {
    private LunchBuilder builder;

    public LunchDirector(LunchBuilder builder) {
        this.builder = builder;
    }

    public void constructMeal(){
        builder.buildDrink();
        builder.buildMainCourse();
        builder.buildSide();


    }

    public Lunch  getMeal(){
        return builder.getMeal();
    }
}
