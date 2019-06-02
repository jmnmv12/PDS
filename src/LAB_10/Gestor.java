package LAB_10;


import java.util.*;

public class Gestor{

    private String name;
    private ArrayList<Produto> stock=new ArrayList<>();
    private ArrayList<Produto> leilao=new ArrayList<>();
    private ArrayList<Produto> vendidos=new ArrayList<>();
    private HashMap<Produto, List<Observer>> obs =new HashMap<>();

    public Gestor(String name) {
        this.name = name;
    }

    public void addProd(Produto b){
        switch (b.getEstado()){
            case LEILAO:
                leilao.add(b);
            case STOCK:
                stock.add(b);
            case VENDAS:
                vendidos.add(b);
        }

    }

    public void addObs(Produto prod, Cliente observ){

        if(obs.get(prod)==null){
            ArrayList<Observer> arr=new ArrayList<>();
            arr.add(observ);
            obs.put(prod,arr);

        }
        else{
            obs.get(prod).add(observ);

        }
        notificar(prod,"Cliente "+observ.getName()+" licitou "+prod.getValor_licitado()+" pelo produto "+prod.getID());


        boolean check=prod.pass_time();
        if(!check){
            Cliente cl=(Cliente) obs.get(prod).get(obs.get(prod).size()-1);
            notificar(prod,"Acabou o leilao do produto "+prod.getID()+" .Vendido a "+cl.getName());
            leilao.remove(prod);
            vendidos.add(prod);

        }

        Iterator it=obs.keySet().iterator();

        while (it.hasNext()){
            Produto p=(Produto) it.next();
            if(obs.get(p)==null){
                boolean checkB=p.pass_time_min();
                if(!checkB){
                    leilao.remove(prod);
                    stock.add(prod);
                    it.remove();
                    notificar(prod,"Acabou o leilao do produto "+p.getID()+" . Voltou ao stock. ");
                }
            }
        }








    }

    public void addToLeilao(Produto p, int tempo){
        p.setEstado(states.LEILAO,tempo);
        stock.remove(p);
        leilao.add(p);
        obs.put(p,null);
    }


    public void notificar(Produto prod,String type){
        List<Observer> users=obs.get(prod);
        Set<Observer> send=new HashSet<Observer>(users);
        Iterator it= send.iterator();



        while (it.hasNext()){
            Observer temp=(Observer) it.next();
            temp.notify_client(type);


        }
    }


}
