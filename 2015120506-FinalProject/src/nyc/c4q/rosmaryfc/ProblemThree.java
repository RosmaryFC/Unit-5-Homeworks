package nyc.c4q.rosmaryfc;
import java.util.Scanner;

/**
 The problem can be expressed as follows: Pick some positive integer and call it n.
 If n is even, divide it by two. If n is odd, multiply it by three and add one.
 Continue this process until n is equal to one.

 Starting with the number 15:
 15 is odd, so I make 3n+1: 46
 46 is even, so I take half: 23
 23 is odd, so I make 3n+1: 70
 70 is even, so I take half: 35
 35 is odd, so I make 3n+1: 106
 106 is even, so I take half: 53
 53 is odd, so I make 3n+1: 160
 160 is even, so I take half: 80
 80 is even, so I take half: 40
 40 is even, so I take half: 20
 20 is even, so I take half: 10
 10 is even, so I take half: 5
 5 is odd, so I make 3n+1: 16
 16 is even, so I take half: 8
 8 is even, so I take half: 4
 4 is even, so I take half: 2
 2 is even, so I take half: 1

 As you can see from this example, the numbers go up and down,
 but eventually—at least for all numbers that have ever been tried—comes down to end in 1.
 Write a program that reads in a number from the user and then displays the sequence for that
 number of steps taken to reach 1.

 For example, your program should be able to produce a sample run that looks like this:

 Enter a number: 17

 17 is odd, so I make 3n + 1: 52
 52 is even, so I take half: 26
 26 is even, so I take half: 13
 13 is odd, so I make 3n + 1: 40
 40 is even, so I take half: 20
 20 is even, so I take half: 10
 10 is even, so I take half: 5
 5 is odd, so I make 3n + 1: 16
 16 is even, so I take half: 8
 8 is even, so I take half: 4
 4 is even, so I take half: 2
 2 is even, so I take half: 1
 This process took 12 to reach 1

 How many steps, for example, does your program take when n is 27?
 */
public class ProblemThree
{

    public static void main (String[] args){
        Scanner input = new Scanner (System.in);

        System.out.print("Enter a number: ");

        int num = input.nextInt();

        int counter = 0;

        while (num != 1){
            if (num % 2 == 0){
                System.out.print(num + " is even so I take half: ");
                num = num / 2;
                System.out.println(num);
                counter ++;
            }else {
                System.out.print(num + " is odd so I make 3n + 1: ");
                num = (3 * num) + 1;
                System.out.println(num);
                counter ++;
            }
        }

        System.out.println("This process took " + counter + " to reach 1.");

    }
}
