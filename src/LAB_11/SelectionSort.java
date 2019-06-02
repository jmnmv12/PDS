package LAB_11;

public class SelectionSort implements Sort<Telemovel> {

    @Override
    public Telemovel[] sort_alg(Telemovel[] arr, String attr){

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if ((double)arr[j].attribute(attr) < (double) arr[min_idx].attribute(attr))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            Telemovel temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return arr;



    }



}
