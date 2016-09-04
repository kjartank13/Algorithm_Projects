
import java.util.*;

public class mugs {
    
    public static String muggs(int n1, int n2, int D)
    {
        
        //      int frames;
        //      while (n1 < D)
        //      {
        //          frames = (int) (Math.pow(n2, 2) - Math.pow(n1, 2));
        //          if (frames == D)
        //              return Integer.toString(n1) + " " + Integer.toString(n2);
        //          else if (frames > D)
        //          {
        //
        //          }
        //      }
        
        int frames;
        while (n1 < D)
        {
            frames = (int) (Math.pow(n2, 2) - Math.pow(n1, 2));
            if (frames == D)
                return Integer.toString(n1) + " " + Integer.toString(n2);
            else if (frames > D)
            {
                n1++;
                n2 = n1+1;
                //              return muggs(n1, n2, D);
            }
            else
                n2++;
        }
        return "impossible";
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int D = in.nextInt();
        System.out.println(muggs(0, 1, D));
    }
}