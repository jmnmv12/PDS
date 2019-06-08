package ExamePratico.Aula6;

import java.util.Vector;

public class DataBase {
    // Data elements
    private Vector<Employee> employees; // Stores the employees
    public DataBase() {
        employees = new Vector<>();
    }
    public boolean addEmployee(Employee employee) {
        employees.add(employee);
        return true;

    }
    public void deleteEmployee(long emp_num) {

        employees.removeIf(b->emp_num==b.getEmpNum());
    }
    public Employee[] getAllEmployees() {
        return (Employee []) employees.toArray(new Employee [employees.size()]);
    }
}