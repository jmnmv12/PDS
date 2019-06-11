package ExamePratico.Aula11;

public interface State {
    public void regista(Livro l);
    public void requesita(Livro l);
    public void devolve(Livro l);
    public void reservar(Livro l);
    public void cancelar(Livro l);
}
