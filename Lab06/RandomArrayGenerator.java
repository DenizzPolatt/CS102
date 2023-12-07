import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator {

    public Integer[] generate(int n) {

        Integer[] array = new Integer[n];

        for(int i = 0; i < n; i++)
        {
            array[i] = new Random().nextInt(n) + 1;
        }

        return array;
    }

    

    
    

}
