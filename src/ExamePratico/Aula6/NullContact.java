package ExamePratico.Aula6;

public class NullContact {

    private String name;
    private int number;
    private String email;

    public NullContact() {
        this.name = "";
        this.number = 0;
        this.email = "";
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}
