package LAB_11;

public class BubbleSort implements Sort<Telemovel>{
    @Override
    public Telemovel[] sort_alg(Telemovel[] arr, String attr) {
            int i, j, n=arr.length;
            Telemovel temp=null;
            boolean swapped;
            for (i = 0; i < n - 1; i++)
            {
                swapped = false;
                for (j = 0; j < n - i - 1; j++)
                {
                    if ((double)arr[j].attribute(attr) >(double) arr[j + 1].attribute(attr))
                    {
                        // swap arr[j] and arr[j+1]
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }

                // IF no two elements were
                // swapped by inner loop, then break
                if (swapped == false)
                    break;
            }
    return arr;

    }
}
