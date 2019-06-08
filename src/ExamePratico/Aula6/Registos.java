package ExamePratico.Aula6;

import java.util.*;

public class Registos {

    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees
    public Registos() {
        empregados = new ArrayList<>();
    }
    public void insere(Empregado emp) {

        empregados.add(emp);

    }
    public void remove(int codigo) {
        empregados.removeIf(b->b.codigo()==codigo);

        /*ListIterator it=empregados.listIterator();
        while (it.hasNext()){
            Empregado temp=(Empregado)it.next();
            if(temp.codigo()==codigo){
                it.remove();
                break;
            }

        }*/

    }
    public boolean isEmpregado(int codigo) {

        Iterator it=empregados.iterator();

        while (it.hasNext()){
            Empregado temp=(Empregado) it.next();
            if(temp.codigo()==codigo){
                return true;
            }
        }
        return false;
    }
    public List<Empregado> listaDeEmpregados() {

        return this.empregados;
    }

}
