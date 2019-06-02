package LAB_7;

public class Retangulo  extends Leaf {
    private String str;

    public Retangulo(String str) {
        this.str = str;
    }

    @Override
    public void draw() {
        System.out.println(ident.toString()+"Retangulo "+str);
    }
}
