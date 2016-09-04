//package exam;

import java.util.*;

public class pet {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bestScore = 0;
        int bestCont = 0;
        
        for (int i = 0; i < 5; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int sum = a+b+c+d;
            if (sum > bestScore)
            {
                bestScore = sum;
                bestCont = i+1;
            }
        }
        
        System.out.println(bestCont + " " + bestScore);
    }
}