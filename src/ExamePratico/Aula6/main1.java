package ExamePratico.Aula6;

public class main1 {
    public static void main(String[] args) {
        DataBase a=new DataBase();
        Registos b=new Registos();
        a.addEmployee(new Employee("Joao",123,2000));
        b.insere(new Empregado("Antonio","Nunes",234,2000));
        b.isEmpregado(123);
        //a.deleteEmployee(123);
        //System.out.println(a.getAllEmployees());

        RecentBD c=new RecentBD(a,b);
        c.addEmployee(new Employee("Nunes",456,1000));
        c.print();
        System.out.println(c.exists(123));
    }
}
