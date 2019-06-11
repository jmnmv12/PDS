package ExamePratico.Aula7;

public class Employee implements Pessoa {
    private String start;
    private String terminate;

    public Employee(String start, String terminate) {
        this.start = start;
        this.terminate = terminate;
    }

    @Override
    public void start(String date) {
       this.start=date;
    }

    @Override
    public void terminate(String Date) {
        this.terminate=Date;
    }

    @Override
    public void work() {
        System.out.println(start+"---"+terminate);
        System.out.println("The employee is: ");

    }
}
