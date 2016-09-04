
import java.util.*;


public class trees {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//      Vector<Integer> trees = new Vector<Integer>();
        int n = in.nextInt();
        int[] trees = new int[n];
        for (int i = 0; i < n; i++)
            trees[i] = in.nextInt();
        Arrays.sort(trees);
        for (int i = n-1; i > 0; i--)
        {
            for (int j = i; j < n; j++)
            {
                trees[j]--;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
        {
            if (trees[i] > max)
                max = trees[i];
        }
        System.out.println(max + n + 1);
    }
}