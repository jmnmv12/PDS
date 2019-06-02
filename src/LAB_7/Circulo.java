package LAB_7;

public class Circulo extends Leaf{
    private String str;

    public Circulo(String str) {
        this.str = str;
    }

    @Override
    public void draw() {
        System.out.println(ident.toString()+"Circulo "+str);
    }
}
