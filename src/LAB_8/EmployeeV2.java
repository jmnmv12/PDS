package LAB_8;

class EmployeeV2 {
    private double salary;
    private String name;
    private Person p;

    public EmployeeV2(Person n, double s) {
        salary = s;
        this.name = n.getName();
        this.p =n;

    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return p.getBankAccount();
    }

    public String getName() {
        return p.getName();
    }

}
