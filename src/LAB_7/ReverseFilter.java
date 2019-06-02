package LAB_7;

public class ReverseFilter extends ReaderDecorator {


    public ReverseFilter(Reader rd) {
        super(rd);
    }

    @Override
    public String next() {
        String temp =super.next(),finalStr="";


        char [] tempChar=temp.toCharArray();
        for(int i =tempChar.length -1;i>=0;i--){
            finalStr+=tempChar[i];

        }
        return  finalStr;
    }

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }
}
