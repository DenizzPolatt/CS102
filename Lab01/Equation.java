/**
 * This class creates Equation objects that represent a linear equation in the form a = bx + c.
 * It contains method that sums, substracts and simplifies the equations.
 * @author Deniz Polat
 */
public class Equation {

    public int a;
    public int b;
    public int c;

    // Constructor
    public Equation(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;

        if(b < 0)
        {
            this.a = a * -1;
            this.b = b * -1;
            this.c = c * -1;
        }
    }

    /**
     * This method simplifies the given equation
     */
    public void reduceEquation()
    {
        int n = gcd3(a, b, c);
        a = a / n;
        b = b / n;
        c = c / n;
    }

    /**
     * 
     * @param a
     * @param b
     * @return the greatest common divisor of a and b 
     */
    public static int gcd(int a, int b)
    {
        int remainder = 1;

        if(a == 0) return b;
        if(b == 0) return a;

        if(a > b)
        {
            if(a % b == 0) return b;

            else
            {
                while(remainder != 0)
                {
                    remainder = a % b;
                    a = b;
                    if(remainder == 0) break;
                    b = remainder;
                }
            }
        }

        if(b > a)
        {
            if(b % a == 0) return a;

            else
            {
                while(remainder != 0)
                {
                    remainder = b % a;
                    b = a;
                    if(remainder == 0) break;
                    a = remainder;
                }
            }
        }
        return b;
    }

    /**
     * This method is used to simplify the equations by their greatest common divisors, uses gcd() method.
     * @param a
     * @param b
     * @param c
     * @return the greatest common divisor of a, b and c
     */
    public static int gcd3(int a, int b, int c)
    {
        if(c > gcd(a, b)) return gcd(c, gcd(a, b));
        return gcd(gcd(a, b), c);
    }

    /**
     * @param eq2
     * @return the sum of the coefficients of two equations.
     */
    public Equation add(Equation eq2)
    {
        a = this.a + eq2.a;
        b = this.b + eq2.b;
        c = this.c + eq2.c;

        Equation addedEquation = new Equation(a, b, c);

        addedEquation.reduceEquation();

        return addedEquation;
    }
    
    /**
     * substract the second equation's coefficients from the first equation's. 
     * @param eq2
     * @return the substracted equation.
     */
    public Equation substract(Equation eq2)
    {
        a = this.a - eq2.a;
        b = this.b - eq2.b;
        c = this.c - eq2.c;

        Equation substractedEquation = new Equation(a, b, c);

        substractedEquation.reduceEquation();

        return substractedEquation;
    }

    /**
     * String representation of the Equation objects
     */
    public String toString()
    {
        String str = "";
        str += a + " = ";
        if(b == 0) str += c;
        else if(c == 0) str += b + "x";
        else str += b + "x + " + c;
        return str;
    }

    /**
     * @param eq2
     * @return true if the reduced coefficients of two objects are equal.
     */
    public boolean equals(Equation eq2)
    {
        Equation modifiedEquation = new Equation(this.a, this.b, this.c);
        modifiedEquation.reduceEquation();
        eq2.reduceEquation();

        return modifiedEquation.a == eq2.a 
            && modifiedEquation.b == eq2.b 
            && modifiedEquation.c == eq2.c;
    }
}