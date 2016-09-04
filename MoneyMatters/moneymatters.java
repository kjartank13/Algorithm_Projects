//package exam;

import java.util.*;

public class moneymatters {
    
    public static int[] friendship;
    public static int groups;
    
    public moneymatters(int p)
    {   friendship = new int[p];
        for (int i = 0; i < p; i++)
            friendship[i] = i;
        groups = p;
    }
    
    public static boolean connected(int p, int q) {
        return friendship[p] == friendship[q];
    }
    
    public static void union(int p, int q)
    {
        if (connected(p, q))
            return;
        friendship[find(p)] = find(q);
        groups--;
    }
    public static int find(int p)
    {
        if (friendship[p] == p)
            return p;
        else
        {
            friendship[p] = find(friendship[p]);
            return friendship[p];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int people = in.nextInt();
        int friends = in.nextInt();     
        int[] moneys = new int[people];
        moneymatters mm = new moneymatters(people);
        for (int i = 0; i < people; i++)
        {
            moneys[i] = in.nextInt();
        }
        
        for (int i = 0; i < friends; i++)
        {
            int friend1 = in.nextInt();
            int friend2 = in.nextInt();
            union(friend1, friend2);
        }
//      System.out.println(groups);
//      for (int i = 0; i < people; i++)
//          System.out.print(find(i));
        
        Vector<Integer> sets = new Vector<Integer>();
        int[] finds = new int[people];
        for (int i = 0; i < people; i++)
        {
            finds[i] = find(i);
            if (!sets.contains(finds[i]))
                sets.add(finds[i]);
        }
        for (int i = 0; i < sets.size(); i++)
        {
            int sum = 0;
            for (int j = 0; j < people; j++)
            {
                if (finds[j] == sets.elementAt(i))
                    sum += moneys[j];
            }
            if (sum != 0)
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println("POSSIBLE");
    }
}