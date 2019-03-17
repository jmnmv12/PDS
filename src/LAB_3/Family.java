package LAB_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<String> Nomes;
    private String doors;


    public Family(String doors) {
        this.Nomes = new ArrayList<>();
        this.doors=doors;
    }

    public void addFamily(String name){
        Nomes.add(name);
    }
}
