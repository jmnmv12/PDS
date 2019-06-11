package ExamePratico.Aula9;

public class main2 {
    public static void main(String[] args) {
        ControlRemote cl=new ControlRemote();
        Playlist pl=new Playlist();
        Command add=new Add(pl);
        Command delete=new Remove(pl);


        cl.setCommand(add);
        cl.pressButton("ola");
        cl.pressButton("adeus");

        cl.setCommand(delete);
        cl.pressButton("ola");
        cl.pressButton("joao");
    }
}
