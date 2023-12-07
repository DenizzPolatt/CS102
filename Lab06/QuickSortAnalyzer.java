public class QuickSortAnalyzer extends SortAnalyzer {

    @Override
    public Comparable[] sort(Comparable[] arr) 
    {
        int begin = 0;
        int end = arr.length;
        sortHelper(arr, begin, end);

        return arr;    
    }

    public void sortHelper(Comparable[] arr, int begin, int end)
    {
        if(compare(arr[begin], arr[end]) > 0) return;

        int p = partition(arr, begin, end);
        
        sortHelper(arr, begin, p);
        sortHelper(arr, p + 1, end);
    }

    private int partition(Comparable[] arr, int begin, int end)
    {
        Comparable pivot = arr[begin];
        int i = begin - 1;
        int j = end + 1;
        
        while (i < j)
        {
            i++; 
            
            while (compare(arr[i], pivot) < 0) i++;
            
            j--; 
            
            while (compare(arr[i], pivot) < 0) j--;
            
            if (i < j) 
            { 
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return j;
    }

    
}
