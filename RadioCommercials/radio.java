//package dynamic;

import java.util.*;

public class radio {

    static int mem[];
    static int gain[];
    static boolean comp[];
    
    public static int max(int a, int b)
    {
        if (a < b)
            return b;
        else
            return a;
    }
    
    public static int max_sum(int i)
    {
        if (i == 0)
            return gain[i];
        if (comp[i])
            return mem[i];
        
        int res = max(gain[i], gain[i] + max_sum(i-1));
        mem[i] = res;
        comp[i] = true;
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int comm = in.nextInt();
        int cost = in.nextInt();
        gain = new int[comm];
        mem = new int[comm];
        comp = new boolean[comm];
        for (int i = 0; i < comm; i++)
        {
            int n = in.nextInt();
            gain[i] = n - cost;
        }
        int maximum = 0;
        for (int i = 0; i < comm; i++)
            maximum = max(maximum, max_sum(i));
        System.out.println(maximum);
    }
}

