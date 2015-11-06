package Rosmaryfc.nyc.c4q;

public class Main {

    public static boolean isEvenWord (String word)
    {
        if (word.length() == 0){
            return true;
            //word contains no more letters RETURN true because it means all letters were even;
        }

        String firstLetter = String.valueOf(word.charAt(0));

        String newWord = word.replace(firstLetter, "");

        if(newWord.length() % 2 != 0){
            //length of word is odd meaning an odd amount of chars were removed return FALSE;
            return false;
        }

        //up to here only if previous letter counter % 2 = 0, then new word created can go through steps
        return isEvenWord(newWord);
    }

    public static void main(String[] args) {

        System.out.println("Is appeases an Even Word? - " + isEvenWord("appeases"));

        System.out.println("Is arraigning an Even Word? - " + isEvenWord("arraigning"));

        System.out.println("Is tattletale an Even Word? - " + isEvenWord("tattletale"));

        System.out.println("Is banana an Even Word? - " + isEvenWord("banana"));

    }


}
