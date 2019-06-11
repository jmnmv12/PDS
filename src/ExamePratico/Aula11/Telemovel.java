package ExamePratico.Aula11;

public class Telemovel {
    private String processador;
    private double preço;
    private double memoria;
    private double camara;

    public Telemovel(String processador, double preço, double memoria, double camara) {
        this.processador = processador;
        this.preço = preço;
        this.memoria = memoria;
        this.camara = camara;
    }

    public String getProcessador() {
        return processador;
    }

    public double getPreço() {
        return preço;
    }

    public double getMemoria() {
        return memoria;
    }

    public double getCamara() {
        return camara;
    }

    public Object getVar(String varname){
        switch (varname){
            case "processador":{
                return this.processador;

            }
            case "preço":{
                return this.preço;

            }
            case "memoria":{
                return this.memoria;

            }
            case "camara":{
                return this.camara;

            }

        }
        return null;
    }


    @Override
    public String toString() {
        return "Telemovel{" +
                "processador='" + processador + '\'' +
                ", preço=" + preço +
                ", memoria=" + memoria +
                ", camara=" + camara +
                '}';
    }
}
