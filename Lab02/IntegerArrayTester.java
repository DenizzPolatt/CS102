import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {
    public static void main(String[] args) {
        IntegerArray array1 = new IntegerArray("12345");
        IntegerArray array2 = new IntegerArray("345");

        //System.out.println(array1.add(array2));
        System.out.println(array1.subtract(array2));

        IntegerArrayList arr1 = readIntegerArraysFromFile("/home/PCLABS/d.polat-ug/Desktop/Lab02/Test1.txt");
        IntegerArrayList arr2 = readIntegerArraysFromFile("/home/PCLABS/d.polat-ug/Desktop/Lab02/Test2.txt");
        IntegerArrayList arr3 = readIntegerArraysFromFile("/home/PCLABS/d.polat-ug/Desktop/Lab02/Test3.txt");

        System.out.println("Test 1");
        System.out.println(arr1.min(0, arr1.getSize()));
        System.out.println(arr1.min(0, arr1.getSize() / 2));
        System.out.println(arr1.min(arr1.getSize() / 2, arr1.getSize() - 1));

        System.out.println("Test 2");
        System.out.println(arr2.min(0, arr2.getSize()));
        System.out.println(arr2.min(0, arr2.getSize() / 2));
        System.out.println(arr2.min(arr2.getSize() / 2, arr2.getSize() - 1));

        System.out.println("Test 3");
        System.out.println(arr3.min(0, arr3.getSize()));
        System.out.println(arr3.min(0, arr3.getSize() / 2));
        System.out.println(arr3.min(arr3.getSize() / 2, arr3.getSize() - 1));
    }
    public static IntegerArrayList readIntegerArraysFromFile(String fileName)
    {
        String dataFromFile = "";
        ArrayList<String> numbers = new ArrayList<String>();
        
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNextLine())
            {
                dataFromFile = scan.nextLine();
                if (!dataFromFile.isEmpty()) {
                    numbers.add(dataFromFile);
                    
                }
                
            }
            
            return new IntegerArrayList(numbers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new IntegerArrayList(numbers);

        
    }
}
