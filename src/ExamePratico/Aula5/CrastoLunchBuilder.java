package ExamePratico.Aula5;

public class CrastoLunchBuilder implements LunchBuilder {
    protected Lunch food=new Lunch();

    @Override
    public void buildDrink() {
        food.setDrink("Vinho Tinmto");
    }

    @Override
    public void buildMainCourse() {
        food.setMainCourse("Bacalhau");
    }

    @Override
    public void buildSide() {
        food.setSide("Broa");
    }

    @Override
    public Lunch getMeal() {
        return food;
    }
}
