package ExamePratico.Aula8;

public class EmployeeV2 {
    private double salary;
    private Person p;
    public EmployeeV2(Person p, double s) {
        this.p=p;
        salary = s;
    }
    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount(){
        return p.getBankAccount();
    }

}
