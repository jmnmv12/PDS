package LAB_11;

public class Telemovel {

    private String processador;
    private double preco;
    private double memoria;
    private double camara;
    private Sort <Telemovel> sorting;

    public void setSorting(Sort<Telemovel> sorting) {
        this.sorting = sorting;
    }

    public Telemovel(String processador, double preco, int memoria, int camara) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }

    public double getPreco() {
        return preco;
    }

    public double getMemoria() {
        return memoria;
    }

    public double getCamara() {
        return camara;
    }

    public Object attribute(String attribute){
        switch (attribute){
            case "preco":return this.preco;
            case "memoria":return this.memoria;
            case "camara":return  this.camara;
            default: throw new RuntimeException("Invalid attribute: " + attribute);
        }
    }

    @Override
    public String toString() {
        return "Telemovel{" +
                "processador='" + processador + '\'' +
                ", preco=" + preco +
                ", memoria=" + memoria +
                ", camara=" + camara+
                '}';
    }
}
