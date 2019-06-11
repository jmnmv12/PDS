package ExamePratico.Aula7;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Manager extends EmployeeDecorator {
    public Manager(Pessoa p) {
        super(p);
    }

    @Override
    public void work() {
        super.work();
        System.out.println(" Manager");
    }

    public void manage(){
        System.out.println("Managing");
    }
}
