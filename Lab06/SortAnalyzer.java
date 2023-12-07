public abstract class SortAnalyzer {
    private int numberOfComparisons;
    protected int k;

    public int getNumberOfComparisons()
    {
        return numberOfComparisons; 
    }

    protected int compare(Comparable o1, Comparable o2)
    {
        numberOfComparisons++;
        return o1.compareTo(o2);
        
    }

    public boolean isSorted(Comparable[] arr)
    {
        if(isSortedIncreasing(arr, arr.length)) return true;
        if(isSortedDecreasing(arr, arr.length)) return true;
        return false;
    }

    private boolean isSortedIncreasing(Comparable[] array, int n){
        if(n == 1 || n == 0) return true;
        if(array[n-1].compareTo(array[n-2]) < 0) return true;
        return isSortedIncreasing(array, n-1);
    }

    private boolean isSortedDecreasing(Comparable[] array, int n)
    {
        if(n == 1 || n == 0) return true;
        if(array[n-1].compareTo(array[n-2]) > 0) return true;
        return isSortedIncreasing(array, n-1);
    }

    public abstract Comparable[] sort(Comparable[] arr);

    public static String arrayPrinter(Integer[] a)
    {
        String str = "";
        for(int i = 0; i < a.length; i++)
        {
            str += a[i] + " ";
        }

        return str;
    }

    public static void main(String[] args) 

    {
        SortAnalyzer a = new MergeSortAnalyzer();
        Integer[] array1 = new IncreasingArrayGenerator().generate(20);
        System.out.println("first array: " + arrayPrinter(array1));
        
        Integer[] array2 = new DecreasingArrayGenerator().generate(20);
        System.out.println("second array: " + arrayPrinter(array2));

        Integer[] array3 = new RandomArrayGenerator().generate(20);
        System.out.println("third array: " + arrayPrinter(array3));

        System.out.println(a.isSorted(array1));
        System.out.println(a.isSorted(array2));
        System.out.println(a.isSorted(array3));

        SortAnalyzer b = new QuickSortAnalyzer();
        System.out.println(b.isSorted(array1));
        System.out.println(b.isSorted(array2));
        System.out.println(b.isSorted(array3));
    }

}
