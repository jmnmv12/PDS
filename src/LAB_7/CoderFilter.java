package LAB_7;

import java.io.UnsupportedEncodingException;
import  java.util.Base64;

public class CoderFilter extends ReaderDecorator  {

    public CoderFilter(Reader rd) {
        super(rd);
    }


    @Override
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    public String next() {
        byte[] encodedBytes=null;
        try {
            //base64 encoding
            encodedBytes = Base64.getEncoder().encode(super.next().getBytes("UTF-8"));


        }catch (UnsupportedEncodingException e){
            System.err.println(e);
        }
        return new String(encodedBytes);
    }

}
