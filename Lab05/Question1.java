//Assume that Sarah purchases N apples on day 0. She eats either 2 or 3 apples each
//day starting from day 1. Write a recursive program that checks if she can have k
//apples at day a.

// Example:
// N = 12, k = 4, a = 3
// Day 0 -> has 9 apples
// Day 1 -> eat 3 apples (9 left)
// Day 2 -> eat 3 apples (6 left)
// Day 3 -> eat 2 apples (4 left) => 4 apples left, so, done.

public class Question1 {

    public static boolean daysApples(int N, int k, int a)
    {

        if(a == 0)
        {
            // correct amount left.
            if(N == k) return true;

            // no more apples
            if(N <= 1) return false;
        }

        // no days left or target amount is not reached
        if(a < 0 || N <= k) return false;

        boolean x1 = daysApples(N-2, k, a-1);
        boolean x2 = daysApples(N-3, k, a-1);

        return x1 || x2;
    }

    public static void main(String[] args) {
        System.out.println(daysApples(29, 5, 10)); // true
        System.out.println(daysApples(75, 25, 7)); // false
        System.out.println(daysApples(74, 30, 16)); // true
        System.out.println(daysApples(75, 25, 0)); // false
        System.out.println(daysApples(75, 75, 0)); // true
    }
}