package LAB_7;

import java.util.ArrayList;

public class Bloco extends Entity {
    private ArrayList<Entity> elements;
    private String titulo;

    public Bloco( String titulo) {
        this.elements = new ArrayList<>();
        this.titulo = titulo;
    }

    public void add(Entity ent){
        elements.add(ent);
    }

    @Override
    public void draw() {
        System.out.println(ident.toString()+"Window "+titulo);
        ident.append("   ");
        for (Entity a: elements) {
            a.draw();

        }
        ident.setLength(ident.length()-3);
    }
}
