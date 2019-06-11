package ExamePratico.Aula11;

public class Disponivel implements State {
    @Override
    public void regista(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void requesita(Livro l) {
        l.setSt(new Emprestado());
    }

    @Override
    public void devolve(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void reservar(Livro l) {

    }

    @Override
    public void cancelar(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public String toString() {
        return "Disponivel";
    }
}
