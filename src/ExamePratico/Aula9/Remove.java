package ExamePratico.Aula9;

public class Remove implements Command {
    private Playlist pl;

    public Remove(Playlist pl) {
        this.pl = pl;
    }

    @Override
    public void execute(String elem) {
        pl.rmElem(elem);
    }
}
