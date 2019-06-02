package LAB_8;

import java.util.*;

class CompanyV2 {
    public static User user;
    private List<EmployeeV2> emps = new ArrayList<>();
    public void admitEmployee(Person person, double salary) {

        EmployeeV2 e = new EmployeeV2(person, salary);
        emps.add(e);
    }
    public void paySalaries(int month) {
        for (EmployeeV2 e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }
    public List<EmployeeV2> employees() {
        return Collections.unmodifiableList(emps);
    }
}