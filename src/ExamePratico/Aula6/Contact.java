package ExamePratico.Aula6;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private int number;
    private String company;

    public Contact(String name, int number, String company) {
        this.name = name;
        this.number = number;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }
}
