import java.util.Scanner;

/**
 * This class represents the main method for the Equation class. It creates two equations by taking the coefficients aas inputs from the user.
 * @author Deniz Polat
 */
public class EquationTest {
    
    public static void main(String[] args) {

        System.out.print("Enter the value of a, b and c for first equation: ");
        Scanner in = new Scanner(System.in);

        // takes coefficients from the user in the form "a b c"
        int a = in.nextInt(); 
        int b = in.nextInt();
        int c = in.nextInt();

        Equation eq1 = new Equation(a, b, c); // First equation is created

        System.out.print("Enter the value of a, b and c for second equation: ");

        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int c1 = in.nextInt();

        Equation eq2 = new Equation(a1, b1, c1); // Second equation is created

        Equation sumOfEquations = eq1.add(eq2); // Adds the equations
        Equation substractOFequations = eq1.substract(eq2); // Substracts the equations

        System.out.println("Sum of the equations: " + sumOfEquations.toString());
        System.out.println("Subtraction of the equations: " + substractOFequations.toString());

        in.close();
    }
}
