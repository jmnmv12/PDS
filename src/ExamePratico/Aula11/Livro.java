package ExamePratico.Aula11;

public class Livro {
    private  String titulo;
    private String ISBN;
    private int ano;
    private String autor;
    private State st;

    public Livro(String titulo, String ISBN, int ano, String autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autor = autor;
        this.st=new Inventario();
    }

    public State getSt() {
        return st;
    }

    public void setSt(State st) {
        this.st = st;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public void regista() {
        st.regista(this);
    }

    public void requesita() {
        st.requesita(this);
    }

    public void devolve() {
        st.devolve(this);
    }

    public void reservar() {
        st.reservar(this);
    }

    public void cancelar() {
        st.cancelar(this);
    }
}
