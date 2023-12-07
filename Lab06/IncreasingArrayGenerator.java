public class IncreasingArrayGenerator implements ArrayGenerator {
    
    public  Integer[] generate(int n)
    {
        Integer[] array = new Integer[n];
        for(int i = 1; i < n+1; i++)
        {
            array[i-1] = i;
        }

        return array;
    }
    
}
