package nyc.c4q.rosmaryfc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * For this assignment, your mission is to write a program that plays the game of Hangman.
 * As an assignment, Hangman serves two purposes. First, the program is designed to give you
 * some practice writing programs that manipulate strings and files.
 * <p/>
 * When the user plays Hangman, the computer first selects a secret word at random from
 * a list built into the program. The program then prints out a row of dashes—one for each
 * letter in the secret word and asks the user to guess a letter.
 * If the user guesses a letter that is in the word, the word is redisplayed with
 * all instances of that letter shown in the correct positions, along with any letters correctly
 * guessed on previous turns. If the letter does not appear in the word, the user is charged with an
 * incorrect guess. The user keeps guessing letters until either (1) the user has correctly guessed
 * all the letters in the word or (2) the user has made eight incorrect guesses.
 */
public class Hangman
{


    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("/Users/c4q-rosmary/Desktop/accessCodeUnits/accessCodeUnit-5/2015120506-FinalProject/src/nyc/c4q/rosmaryfc/word_list"));

        System.out.println("Welcome to Hangman! ");

        List<String> words = new ArrayList<String>();
        while (scanner.hasNext()){
            words.add(scanner.next());
        }

        int randomWord = new Random().nextInt(words.size());

        String answer = words.get(randomWord);
        String guessedSoFar = "";
        String letterGuessed;

        for(int i = 0; i < answer.length(); i++)
        {
            guessedSoFar += "- ";
        }

        int lives = 8;

        do
        {
            System.out.println("The word now looks like this: " + guessedSoFar);
            System.out.println("You have " + lives + " guesses left.");
            System.out.print("Your guess: ");
            letterGuessed = input.next();
            while(! checkIfValid(letterGuessed.toUpperCase()))
            {
                System.out.println("Not a valid guess");
                System.out.print("Your guess: ");
                letterGuessed = input.next();
            }
            char guess = letterGuessed.toUpperCase().charAt(0);

            if(answer.toUpperCase().contains(letterGuessed.toUpperCase()))
            {
                System.out.println("That guess is correct.");
                for(int i = 0; i < answer.length(); i++)
                {
                    if(answer.toUpperCase().charAt(i) == guess)
                    {
                        String[] lettersGuessed = guessedSoFar.split(" ");
                        lettersGuessed[i] = letterGuessed.toUpperCase();
                        String newGuessedSoFar = "";
                        for(String letter : lettersGuessed)
                        {
                            newGuessedSoFar += letter + " ";
                        }
                        guessedSoFar = newGuessedSoFar;
                    }
                }
            }
            else
            {
                System.out
                        .println("There are no " + letterGuessed.toUpperCase() + "'s in the word.");
                lives--;
            }

        }
        while(lives > 0 && guessedSoFar.contains("-"));

        if(lives == 0)
        {
            System.out.println("You're completely hung.");
            System.out.println("The word was: " + answer.toUpperCase());
            System.out.println("You lose.");
        }
        else
        {
            System.out.println("You guessed the word: " + answer.toUpperCase());
            System.out.println("You win.");
        }


    }

    private static boolean checkIfValid(String letterGuessed)
    {
        if(letterGuessed.length() == 1)
        {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            for(int i = 0; i < alphabet.length(); i++)
            {
                char[] letters = alphabet.toCharArray();
                if(letterGuessed.charAt(0) == letters[i])
                {
                    return true;
                }
            }

        }

        return false;
    }


}
