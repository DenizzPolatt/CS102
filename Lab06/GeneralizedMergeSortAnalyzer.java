public class GeneralizedMergeSortAnalyzer extends SortAnalyzer 
{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        
        if(arr.length % k == 0)
        {
            int lengthOfSubArrays = arr.length / k;

            Comparable[][] storedArrays = new Comparable[k][lengthOfSubArrays];

            for(int i = 0; i < k; i++)
            {
                Comparable[] piece = new Comparable[lengthOfSubArrays];

                for(int j = 0; j < lengthOfSubArrays; j++)
                {
                    for(int k = 0; k < arr.length; k++) piece[j] = arr[k];
                    k += lengthOfSubArrays;
                }


            }
            

        }
        
        return null;
    }
    
}
