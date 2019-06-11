package ExamePratico.Aula9;

public class Add implements Command {
    private Playlist pl;

    public Add(Playlist pl) {
        this.pl = pl;
    }

    @Override
    public void execute(String elem) {
        pl.addElem(elem);
    }
}
