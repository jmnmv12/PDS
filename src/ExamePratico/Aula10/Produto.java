package ExamePratico.Aula10;

import java.util.Random;

public class Produto {
    private int id;
    private String descricao;
    private double preco;
    private State st;
    private double valorLicitado;
    private int time=3;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
        Random random=new Random();
        this.id=random.nextInt();
        this.valorLicitado=preco;
        st=State.STOCK;
    }

    public double getPreco() {
        return preco;
    }

    public State getSt() {
        return st;
    }

    public void setSt(State st) {
        this.st = st;
    }

    public double getValorLicitado() {
        return valorLicitado;
    }

    public void setValorLicitado(double valorLicitado) {
        this.valorLicitado = valorLicitado;
    }

    public boolean spendTime(){
        time--;

        if(time==0)
            return true;
        else
            return false;
    }

    public int getId() {
        return id;
    }


}
