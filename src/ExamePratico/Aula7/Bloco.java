package ExamePratico.Aula7;


import java.util.ArrayList;
import java.util.Iterator;

public class Bloco extends Element {
    ArrayList<Element> arr=new ArrayList<>();
    private String name;

    public Bloco(String name) {
        this.name = name;
    }
    public void add(Element a){
        arr.add(a);
    }
    public void remove(Element a){
        arr.removeIf(b->b==a);
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+"Window "+name);
        Iterator it=arr.listIterator();
        id.append("   ");
        while (it.hasNext()){
            Element el=(Element)it.next();
            el.draw();
        }
        id.setLength(id.length()-3);
    }
}
