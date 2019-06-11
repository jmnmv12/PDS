package ExamePratico.Aula7;

public class Retangulo extends Leafes {
    public Retangulo(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+"Retangulo "+super.getColor());
    }

}
