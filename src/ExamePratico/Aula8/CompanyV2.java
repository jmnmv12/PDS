package ExamePratico.Aula8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyV2 {
    public static User user;
    private List<EmployeeV2> emps = new ArrayList<>();
    private double media;
    public void admitEmployee(Person p, double salary) {
        EmployeeV2 e = new EmployeeV2(p, salary);
        emps.add(e);
        int sum=0;
        for (EmployeeV2 b:emps
             ) {
            sum+=b.getSalary();
        }
        media=sum/emps.size();
        SocialSecurity.regist(p);
        Insurance.regist(p);
        if(salary>media){
            Parking.allow(p);
        }


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
