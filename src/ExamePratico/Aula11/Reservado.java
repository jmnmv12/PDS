package ExamePratico.Aula11;

public class Reservado implements State {
    @Override
    public void regista(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void requesita(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void devolve(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void reservar(Livro l) {
        System.out.println("Operação nao disponivel");

    }

    @Override
    public void cancelar(Livro l) {
        l.setSt(new Disponivel());
    }

    @Override
    public String toString() {
        return "Reservado";
    }
}
