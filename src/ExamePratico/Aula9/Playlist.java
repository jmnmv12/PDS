package ExamePratico.Aula9;

import java.util.ArrayList;

public class Playlist {
    ArrayList<String> arr=new ArrayList<>();

    public void addElem(String elem){
        arr.add(elem);

    }

    public void rmElem(String elem){
        arr.removeIf(b->b==elem);

    }
}
