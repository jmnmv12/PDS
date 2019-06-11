package ExamePratico.Aula7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextReader implements ReaderInterface {
    private String filename;
    private List<String> text=new ArrayList<>();
    private Iterator<String> it;
    public TextReader(String filename) {
        this.filename = filename;

        Path p= Paths.get(filename);
        try {
            text=Files.readAllLines(p);
            it=text.listIterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {

        return it.hasNext();
    }

    @Override
    public String next() {
        return  it.next();
    }
}
