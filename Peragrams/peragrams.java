//package stringproblems;

import java.util.*;

public class peragrams {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int[] letters = new int[26];
        if (word.length() == 1)
        {
            System.out.println(0);
            return;
        }
        
        for (int i = 0; i < word.length(); i++)
            letters[Character.getNumericValue(word.charAt(i)) - 10]++;
        int odds = 0;
        for (int i = 0; i < letters.length; i++)
            if (!(letters[i] % 2 == 0))
                odds++;
        if (odds == 0)
            System.out.println(0);
        else
            System.out.println(odds - 1);
    }
}

