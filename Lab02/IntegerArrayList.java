import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntegerArrayList {
    ArrayList<IntegerArray> numbers = new ArrayList<IntegerArray>();

    private int size;

    public IntegerArrayList(ArrayList<String> strings)
    {
        size = strings.size();
        for(int i = 0; i < size; i++)
        {
            IntegerArray a = new IntegerArray(strings.get(i));
            numbers.add(a);
        }
    }

    public int getSize()
    {
        return size;
    }

    public IntegerArray getIntegerArrayAt(int index)
    {
        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr)
    {
        numbers.set(index, intArr);
    }

    public void addIntegerArray(String number)
    {
        IntegerArray addedArray = new IntegerArray(number);
        numbers.add(addedArray);
    }

    public void removeIntegerArray(IntegerArray intArr)
    {
        numbers.remove(intArr);
    }

    public void removeIntegerArray(int index)
    {
        numbers.remove(index);
    }
    public IntegerArray min(int start, int end)
    {
        ArrayList<IntegerArray> newList = new ArrayList<>();
        
        for(int i = start; i < end; i++)
        {
            newList.add(this.numbers.get(i));
        }
        Collections.sort(newList);

        return newList.get(0);
    }
}
