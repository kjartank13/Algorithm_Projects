//package exam;

import java.util.*;

public class countingstars {

    public static int numStars;
    public countingstars()
    {   numStars = 0;   }
    
    
    public static void markStars(int[][] stars, int i, int j, int m, int n)
    {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;
        if (stars[i][j] != 1)
            return;
        stars[i][j] = 2;
        markStars(stars, i+1, j, m, n);
        markStars(stars, i-1, j, m, n);
        markStars(stars, i, j+1, m, n);
        markStars(stars, i, j-1, m, n);
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 1;
        while (in.hasNext())
        {
            System.out.print("Case " + i + ": ");
            i++;
            countingstars cs = new countingstars();
            
            String[] mn = in.nextLine().split("\\ ");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
            
            int[][] stars = new int[m][n];
            for (int j = 0; j < m; j++)
            {
                String line = in.nextLine();
                for (int k = 0; k < n; k++)
                {
                    if (line.charAt(k) == '-')
                        stars[j][k] = 1;
                }
            }
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (stars[j][k] == 1)
                    {
                        numStars++;
                        markStars(stars, j, k, m, n);
                    }
                }
            }
            System.out.println(numStars);
        }
    }
}