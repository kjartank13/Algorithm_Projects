import java.util.*;

public class toilet {
    
    
    public static void main(String[] args) {
        int SeatUpAdj = 0;
        int SeatDownAdj = 0;
        int SeatPrefAdj = 0;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        //      System.out.println(input);
        if (input.length() < 2 || input.length() > 1000)
            throw new IllegalArgumentException();
        
        if(!input.matches("[UD]+"))
            throw new IllegalArgumentException();
        //for SeatUpAdj
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++)
        {
            char curr = input.charAt(i);
            if (prev == 'U' && curr == 'U')
            {
                prev = 'U';
                continue;
            }
            else if (prev == 'U' && curr == 'D')
            {
                SeatUpAdj += 2;
                prev = 'U';
                continue;
            }
            else if (prev == 'D' && curr == 'U')
            {
                SeatUpAdj++;
                prev = 'U';
                continue;
            }
            else if (prev == 'D' && curr == 'D')
            {
                SeatUpAdj++;
                prev = 'U';
                continue;
            }
            
        }
        
        //for SeatDownAdj
        prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++)
        {
            char curr = input.charAt(i);
            if (prev == 'U' && curr == 'U')
            {
                SeatDownAdj++;
                prev = 'D';
                continue;
            }
            else if (prev == 'U' && curr == 'D')
            {
                SeatDownAdj++;
                prev = 'D';
                continue;
            }
            else if (prev == 'D' && curr == 'U')
            {
                SeatDownAdj += 2;
                prev = 'D';
                continue;
            }
            else if (prev == 'D' && curr == 'D')
            {
                prev = 'D';
                continue;
            }
        }
        //for SeatPrefAdj
        prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++)
        {
            char curr = input.charAt(i);
            if (prev == 'U' && curr == 'U')
            {
                prev = 'U';
                continue;
            }
            else if (prev == 'U' && curr == 'D')
            {
                SeatPrefAdj++;
                prev = 'D';
                continue;
            }
            else if (prev == 'D' && curr == 'U')
            {
                SeatPrefAdj++;
                prev = 'U';
                continue;
            }
            else if (prev == 'D' && curr == 'D')
            {
                prev = 'D';
                continue;
            }
        }
        System.out.println(SeatUpAdj);
        System.out.println(SeatDownAdj);
        System.out.println(SeatPrefAdj);
    }
}

