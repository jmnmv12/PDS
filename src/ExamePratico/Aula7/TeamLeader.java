package ExamePratico.Aula7;

public class TeamLeader extends EmployeeDecorator{
    public TeamLeader(Pessoa p) {
        super(p);
    }

    @Override
    public void work() {
        super.work();
        System.out.println(" Team Leader");
    }

    public void plan(){
        System.out.println(" Planing");
    }
}
