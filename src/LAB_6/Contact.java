package LAB_6;

public class Contact {
    private String name;
    private int number;
    private String email;

    public Contact(String name, int number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
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
}
