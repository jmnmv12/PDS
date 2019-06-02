package LAB_7;


import java.io.IOException;
import java.nio.file.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TextReader implements Reader {
    private String filename;
    private Path p1;
    private List<String> contents;
    private ListIterator<String> iter;


    public TextReader(String filename) {
        this.filename = filename;
        this.p1 = Paths.get(this.filename);


        try{
            this.contents=Files.readAllLines(p1);
            this.iter=contents.listIterator();

        }catch (IOException e){
            System.err.println("Error: "+ e);
        }

    }


    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public String next() {
        return iter.next();
    }
}
