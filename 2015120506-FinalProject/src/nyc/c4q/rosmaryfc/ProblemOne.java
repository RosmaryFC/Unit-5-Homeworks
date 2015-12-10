package nyc.c4q.rosmaryfc;
import java.util.Scanner;

/**
 The Pythagorean theorem for the relationship of the lengths of the three
 sides of a right triangle: a2 + b2 = c2 which can alternatively be written as: c^2 =a^2+b^2

 Write a program that accepts values for a and b as doubles
 (you can assume that a and b will be positive) and then calculates
 the solution of c as a double. Your program should be able to duplicate the following sample run:

 Enter values to compute the Pythagorean theorem.
 a:3.5
 b:4.2
 c = 5.4671747731346585

 */
public class ProblemOne
{

    public static double pythagoreanTheorem (double a, double b){
//        double aSquared = a * a;
//        double bSquared = b * b;
//        double cSquared = aSquared + bSquared;
//
//        double c = Math.sqrt(cSquared);
//
//        return c;
        return Math.sqrt((a * a) + (b * b));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter values to computer the pythagorean theorem.");

        System.out.print("a:  ");
        double a = input.nextDouble();
        System.out.println();

        System.out.print("b:  ");
        double b = input.nextDouble();
        System.out.println();

        System.out.println("c =  " + pythagoreanTheorem(a, b));

    }

}
