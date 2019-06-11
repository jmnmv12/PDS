package ExamePratico.Aula11;

public class MergeSort implements  Strategy {
    @Override
    public Telemovel[] sort(Telemovel[] arr, String atributo) {


        if(atributo=="processador"){
            //System.out.println("ola");
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                Telemovel t=arr[i];

                String key =(String) t.getVar(atributo);
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                int k=((String)arr[j].getVar(atributo)).compareTo(key);
                //System.out.print(k);
                while (j >= 0 && k>1) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = t;
            }


        }
        else{
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                Telemovel t=arr[i];

                double key = (double)t.getVar(atributo);
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && (double)arr[j].getVar(atributo) > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = t;
            }
        }




        return arr;
    }
}
