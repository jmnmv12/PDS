package LAB_11;

public interface State {
    void regista(Livro wrapper);
    void requesita(Livro wrapper);
    void devolve(Livro wrapper);
    void reserva(Livro wrapper);
    void cancelaReserva(Livro wrapper);


}
