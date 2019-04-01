package aula02.T1.pratica1.versao2;

import java.util.TreeMap;

public class SoapMap extends TreeMap {

    @Override
    public Object put(Object key, Object value) {
        if(this.containsKey(key))
            ErrorsSoapSolver.duplicationInPuzzleError();
        return super.put(key, value);
    }
}
