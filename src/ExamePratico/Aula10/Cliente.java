package ExamePratico.Aula10;

public class Cliente {
    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    public void update(String text){
        System.out.println(name+" : "+text);
    }

    public String getName() {
        return name;
    }

    public void licitar(Gestor g,Produto p, double valor){
        g.licitar(p.getId(),this,valor);

    }
}
