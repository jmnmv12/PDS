package ExamePratico.Aula7;

public class main1 {
    public static void main(String[] args) {
        Manager a=new Manager(new TeaMember(new Employee("2018","2019")));
        a.work();
        a.manage();
    }
}
