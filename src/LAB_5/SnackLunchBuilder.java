package LAB_5;

public class SnackLunchBuilder implements LunchBuilder {
    private String drink;
    private String mainCourse;
    private String sideCourse;


    @Override
    public void buildDrink() {
        this.drink="Sumo";
    }

    @Override
    public Lunch getMeal() {
        return new Lunch(drink,mainCourse,sideCourse);
    }

    @Override
    public void buildMainCourse() {
        this.mainCourse="Pão com panado";
    }

    @Override
    public void buildSide() {
        this.sideCourse="Rissol";
    }
}
