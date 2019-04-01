package LAB_5;

public class Lunch {
    private String drink;
    private String mainCourse;
    private String side;

    public Lunch(String drink, String mainCourse, String side) {
        this.drink = drink;
        this.mainCourse = mainCourse;
        this.side = side;
    }

    @Override
    public String toString() {
        return "[ drink: "+this.drink+", main course: "+this.mainCourse+", side: "+this.side+" ]";
    }
}
