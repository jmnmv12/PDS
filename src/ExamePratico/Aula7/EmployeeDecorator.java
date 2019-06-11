package ExamePratico.Aula7;

public abstract class EmployeeDecorator implements Pessoa {
    private Pessoa p;

    public EmployeeDecorator(Pessoa p) {
        this.p = p;
    }

    @Override
    public void start(String date) {
        p.start(date);
    }

    @Override
    public void terminate(String Date) {
        p.terminate(Date);
    }

    @Override
    public void work() {
        p.work();
    }
}
