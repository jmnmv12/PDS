package ExamePratico.Aula10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Gestor {
    private String name;
    private HashSet<Produto> arr=new HashSet<>();
    private HashMap<Produto, HashSet> subs=new HashMap<>();

    public Gestor(String name) {
        this.name = name;
    }

    public void licitar(int id,Cliente c,double valor){
        Produto p=null;
        for (Produto a:
             arr) {
            if(a.getId()==id)
                p=a;

        }
        if(p==null){
            c.update("Produto não existe");
            System.exit(1);
        }
        HashSet<Cliente> tempArr=null;
        if(p.getSt()==State.STOCK){
            if(valor>p.getValorLicitado()){
                p.setSt(State.LEILAO);
                tempArr=new HashSet<Cliente>();
                tempArr.add(c);
                p.setValorLicitado(valor);
                subs.put(p,tempArr);
                boolean check=p.spendTime();

                if(check){
                    c.update(c.getName()+" ganhou o leilao com o  "+valor+" no produto com id "+id);
                    p.setSt(State.VENDAS);
                    subs.remove(p);
                }
                else{
                    notify(c.getName()+" licitou "+valor+" no produto com id "+id,c,p);

                }


            }
            else{
                c.update("Valor licitado muito abaixo");
            }
        }
        else if(p.getSt()==State.LEILAO) {
            if (valor > p.getValorLicitado()) {
                tempArr=subs.get(p);
                tempArr.add(c);
                subs.put(p,tempArr);
                boolean check=p.spendTime();
                if(check){
                    notify(c.getName()+" ganhou o leilao com o  "+valor+" no produto com id "+id,c,p);
                    p.setSt(State.VENDAS);
                    subs.remove(p);

                }
                else
                {
                    notify(c.getName()+" licitou "+valor+" no produto com id "+id,c,p);

                }

            }
            else{
                c.update("Valor licitado muito abaixo");
            }
        }
        else if(p.getSt()==State.VENDAS){
            c.update("Produto já foi vendido");
        }


        arr.add(p);
    }

    public void notify(String msg,Cliente c,Produto p){
        HashSet<Cliente> set=subs.get(p);
        for (Cliente b:
             set) {

            b.update(msg);

        }
    }

    public void addProduct(Produto p){
        arr.add(p);
    }

    public void removeProduct(Produto p){
        arr.removeIf(b->b==p);
    }
}
