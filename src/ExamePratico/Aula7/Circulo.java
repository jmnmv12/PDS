package ExamePratico.Aula7;

public class Circulo extends Leafes {
    public Circulo(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+"Circulo  "+super.getColor());
    }
}
