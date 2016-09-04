//package stringproblems;

import java.util.*;

public class kemija {

    public static boolean isVowel(char letter)
    {
        return (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u');
    }
    
    public static String decode(String word)
    {
        for (int i = 1; i < word.length(); i++)
        {
            if (word.charAt(i) == 'p' && isVowel(word.charAt(i-1)))
                word = word.substring(0, i) + word.substring(i+2, word.length());
        }
        return word;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split("\\ ");
        for (int i = 0; i < words.length; i++)
        {
            System.out.print(decode(words[i]));
            if (i+1 != words.length)
                System.out.print(" ");
        }
        
    }
}