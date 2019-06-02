package LAB_10;

public class Cliente implements Observer {
    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    public void licitar(Produto prod, Gestor ges, double valor){
        double temp=prod.getValor_licitado();
        if(valor>temp){
            prod.setValor_licitado(valor);
            ges.addObs(prod,this);

        }

    }

    @Override
    public void notify_client(String type) {
        System.out.println(this.name+" Notified about: "+type);

    }

    public String getName() {
        return name;
    }
}
