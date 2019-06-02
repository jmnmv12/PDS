package LAB_10;

import java.util.UUID;

public class Produto {
    private String ID;
    private String descricao;
    private double preco_base;
    private states estado;
    private double valor_licitado;
    private int  tempo_em_leilão;
    private int minTempoEmLeilao=1;

    public Produto(String descricao, double preco_base) {
        this.ID= UUID.randomUUID().toString();
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.estado = states.STOCK;
        this.valor_licitado=preco_base;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }

    public void setEstado(states estado,int tempo) {
        this.tempo_em_leilão=tempo;
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco_base() {
        return preco_base;
    }

    public states getEstado() {
        return estado;
    }

    public String getID() {
        return ID;
    }

    public double getValor_licitado() {
        return valor_licitado;
    }

    public void setValor_licitado(double valor_licitado) {

        this.valor_licitado = valor_licitado;



    }

    public boolean pass_time_min(){
        minTempoEmLeilao--;
        if(minTempoEmLeilao<0){
            return false;
        }
        return true;
    }

    public boolean pass_time(){
        tempo_em_leilão--;
        if(tempo_em_leilão<0){
            return false;
        }
        return true;
    }

}
