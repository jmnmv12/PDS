package LAB_10;

public class Leilao {
    public static void main(String[] args) {
        Produto p1=new Produto("carro",200);
        Produto p2=new Produto("carroB",300);

        Gestor g1=new Gestor("Antonio");
        g1.addProd(p1);
        g1.addProd(p2);
        g1.addToLeilao(p1,2);
        g1.addToLeilao(p2,2);

        Cliente c1=new Cliente("Jose");
        Cliente c2=new Cliente("Joao");
        c1.licitar(p1,g1,210);
        c2.licitar(p1,g1,230);
        c1.licitar(p1,g1,240);

    }
}
