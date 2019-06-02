package LAB_11;

public class Livro {

    private String titulo;
    private int ISBN;
    private int ano;
    private String autor;
    private State currentState;

    public Livro(String titulo, int ISBN, int ano, String autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autor = autor;
        this.currentState=new Inventario();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public void regista() {
        currentState.regista(this);
    }


    public void requesita() {
        currentState.requesita(this);
    }

    public void devolve() {
        currentState.devolve(this);
    }

    public void reserva() {
        currentState.reserva(this);

    }


    public void cancelaReserva() {
        currentState.cancelaReserva(this);
    }
}
