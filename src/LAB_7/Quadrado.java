package LAB_7;

public class Quadrado extends Leaf{
    private String str;

    public Quadrado(String str) {
        this.str = str;
    }

    @Override
    public void draw() {
        System.out.println(ident.toString()+"Quadrado "+str);
    }
}
