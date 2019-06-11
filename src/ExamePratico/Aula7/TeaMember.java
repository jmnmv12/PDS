package ExamePratico.Aula7;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

public class TeaMember extends EmployeeDecorator {

    public TeaMember(Pessoa p) {
        super(p);
    }

    @Override
    public void work() {
        super.work();
        System.out.println(" Team Member");
    }

    public void colaborate(){
        System.out.println(" Colaborating");
    }
}
