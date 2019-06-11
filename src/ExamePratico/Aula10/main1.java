package ExamePratico.Aula10;

public class main1 {
    public static void main(String[] args) {
        Gestor g1=new Gestor("Joaquim");
        Produto p1=new Produto("maquina de lavar louça",200);
        Produto p2=new Produto("computador",1000);
        g1.addProduct(p1);
        g1.addProduct(p2);
        Cliente c1=new Cliente("Joao");
        Cliente c2=new Cliente("Maria");
        c1.licitar(g1,p1,100);
        c2.licitar(g1,p1,300);
        c1.licitar(g1,p1,400);
        c2.licitar(g1,p1,1000);
        c1.licitar(g1,p1,1200);
    }
}
