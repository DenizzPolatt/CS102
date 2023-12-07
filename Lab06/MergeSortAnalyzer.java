public class MergeSortAnalyzer extends SortAnalyzer {


    private void merge(Comparable[] firstHalf, Comparable[] secondHalf, Comparable[] arr)
    {
        int indexOfFirstH = 0;
        int indexOfSecondH = 0;
        int i = 0;

        while(indexOfFirstH < firstHalf.length && indexOfSecondH < secondHalf.length)
        {

            if(compare(firstHalf[indexOfFirstH], secondHalf[indexOfSecondH]) == -1)
            {
                arr[i] = firstHalf[indexOfFirstH];
                indexOfFirstH++;
            } 
            else 
            {
                arr[i] = secondHalf[indexOfSecondH];
                indexOfSecondH++;
                i++;
            }

            while(indexOfFirstH < firstHalf.length)
            {
                arr[i] = firstHalf[indexOfFirstH];
                indexOfFirstH++;
                i++;
            }

            while(indexOfSecondH < secondHalf.length)
            {
                arr[i] = secondHalf[indexOfSecondH];
                indexOfSecondH++;
                i++;
            }
        }
    } 


    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(arr.length <= 1) return arr;

        Comparable[] firstHalf = new Comparable[arr.length / 2];
        Comparable[] secondHalf = new Comparable[arr.length - firstHalf.length];

        for(int i = 0; i < firstHalf.length; i++)
        {
            firstHalf[i] = arr[i];
        }

        for(int i = 0; i < secondHalf.length; i++)
        {
            secondHalf[i] = arr[firstHalf.length + 1];
        }

        sort(firstHalf);
        sort(secondHalf);

        merge(firstHalf, secondHalf, arr);

        return arr;
    }


    
}
