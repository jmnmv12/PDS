package LAB_11;

public class Disponivel implements State {
    @Override
    public void regista(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void requesita(Livro wrapper) {
        System.out.println("ola");
        wrapper.setCurrentState(new Emprestado());
    }

    @Override
    public void devolve(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void reserva(Livro wrapper) {
        wrapper.setCurrentState(new Reservado());
    }

    @Override
    public void cancelaReserva(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public String toString() {
        return "Disponivel";
    }
}
