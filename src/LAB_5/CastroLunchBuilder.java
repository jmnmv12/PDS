package LAB_5;

public class CastroLunchBuilder implements LunchBuilder {
    private String drink;
    private String mainCourse;
    private String sideCourse;


    @Override
    public void buildDrink() {
        this.drink="Vinho Tinto";
    }

    @Override
    public Lunch getMeal() {
        return new Lunch(drink,mainCourse,sideCourse);
    }

    @Override
    public void buildMainCourse() {
        this.mainCourse="Bacalhau à lagareiro";
    }

    @Override
    public void buildSide() {
        this.sideCourse="Broa";
    }
}
