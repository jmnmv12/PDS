package LAB_5;

public class CentralCantineLunchBuilder implements LunchBuilder {

    private String drink;
    private String mainCourse;
    private String sideCourse;


    @Override
    public void buildDrink() {
        this.drink="Água";
    }

    @Override
    public Lunch getMeal() {
        return new Lunch(drink,mainCourse,sideCourse);
    }

    @Override
    public void buildMainCourse() {
        this.mainCourse="Grelhada mista";
    }

    @Override
    public void buildSide() {
        this.sideCourse="Queijo Fresco";
    }
}
