package ExamePratico.Aula6;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

public class RecentBD {
    private DataBase db;
    private Registos rg;

    public RecentBD(DataBase db, Registos rg) {
        this.db = db;
        this.rg = rg;
    }

    public void addEmployee(Employee emp){
        Empregado empB=new Empregado(emp.getName()," ",(int)emp.getEmpNum(),emp.getSalary());
        rg.insere(empB);
    }

    public void remove(long codigo){
        db.deleteEmployee(codigo);
        rg.remove((int)codigo);
    }

    public boolean exists(long codigo){
       boolean check=rg.isEmpregado((int)codigo);
       boolean test=false;
       Employee [] h=this.db.getAllEmployees();
       for (Employee emp:h){
           if(emp.getEmpNum()==codigo){
               test=true;
               break;
           }
       }

       if(check | test)
           return true;
       else
           return false;

    }

    public void print(){
        Employee [] a=db.getAllEmployees();
        List b=rg.listaDeEmpregados();
        for (Employee emp:a
             ) {
            System.out.println(emp);
        }
        Iterator it=b.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
