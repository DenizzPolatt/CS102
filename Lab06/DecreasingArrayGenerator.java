public class DecreasingArrayGenerator implements ArrayGenerator {
    
    public  Integer[] generate(int n)
    {
        Integer[] array = new Integer[n];
        for(int i = n; i > 0; i--)
        {
            array[n-i] = i;
        }

        return array;
    }
    
}
