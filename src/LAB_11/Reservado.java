package LAB_11;

public class Reservado implements State {
    @Override
    public void regista(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void requesita(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void devolve(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void reserva(Livro wrapper) {
        System.out.println("Operação não disponivel");

    }

    @Override
    public void cancelaReserva(Livro wrapper) {
        wrapper.setCurrentState(new Disponivel());
    }

    @Override
    public String toString() {
        return "Reservado";
    }
}
