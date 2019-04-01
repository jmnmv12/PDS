package aula02.T1.pratica1.versao2;

import java.util.TreeMap;

public class SoupMap extends TreeMap {

    @Override
    public Object put(Object key, Object value) {

        if(this.containsKey(key))
            ErrorsSoap.duplicationInPuzzleError();
        return super.put(key, value);
    }
}
