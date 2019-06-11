package ExamePratico.Aula7;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class CoderFilter extends ReaderDecorator {
    public CoderFilter(ReaderInterface r) {
        super(r);
    }

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    public String next() {
        byte [] encoded=null;
        try {
            encoded= Base64.getEncoder().encode(super.next().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String(encoded);
    }
}
