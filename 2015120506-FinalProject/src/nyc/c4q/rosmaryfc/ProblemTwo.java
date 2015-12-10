package nyc.c4q.rosmaryfc;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 Write a program that reads in a list of integers, one per line,
 until a sentinel value of 0 (which you should be able to change easily to some other value).
 When the sentinel is read, your program should display the smallest and largest values in the list,
 as illustrated in this sample run:

 This program find the largest and smallest numbers:
 ? 11
 ? 17
 ? 42
 ? 9
 ? -3
 ? 35
 ? 0
 smallest: -3
 largest: 42

 Your program should handle the following special cases:
 • If the user enters only one value before the sentinel,
 the program should report that value as both the largest and smallest.
 • If the user enters the sentinel on the very first input line,
 then no values have been entered, and your program should display a message to that effect.

 */
public class ProblemTwo
{

    public static int largestInt (List<Integer> nums){
        int currentLargest = nums.get(0);
        for(int num : nums){
            if (num > currentLargest){
                currentLargest = num;
            }
        }
        return currentLargest;
    }

    public static int smallestInt(List<Integer> nums){
        int currentSmallest = nums.get(0);
        for(int num : nums){
            if (num < currentSmallest){
                currentSmallest = num;
            }
        }
        return currentSmallest;
    }

    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        Scanner input = new Scanner (System.in);

        System.out.println("This program finds the largest and smallest numbers: ");

        System.out.print("? ");
        int num = input.nextInt();

        while (num != 0){
            nums.add(num);
            System.out.print("? ");
            num = input.nextInt();
        }

        if(nums.size() == 0){
            System.out.println("no values have been entered.");;
        }else {
            System.out.println("smallest: " + smallestInt(nums));
            System.out.println("largest: " + largestInt(nums));
        }

    }
}
