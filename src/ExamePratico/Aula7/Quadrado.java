package ExamePratico.Aula7;

public class Quadrado extends Leafes {
    public Quadrado(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+"Quadrado "+super.getColor());
    }
}
