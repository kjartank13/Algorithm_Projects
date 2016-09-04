import java.util.*;

public class eightqueens {
    
    
    private static boolean valid(boolean[][] board, int x, int y)
    {
        for (int i = y+1; i < 8; i++)
        {
            if (board[x][i] == true)
                return false;
        }
        for (int i = x+1; i < 8; i++)
        {
            if (board[i][y] == true)
                return false;
        }
        int X = x+1;
        int Y = y+1;
        while (X < 8 && Y < 8)
        {
            if (board[X][Y] == true)
                return false;
            X++;
            Y++;
        }
        X = x-1;
        Y = y+1;
        while (X >= 0 && Y < 8)
        {
            if (board[X][Y] == true)
                return false;
            X--;
            Y++;
        }
        X = x+1;
        Y = y-1;
        while (X < 8 && Y >= 0)
        {
            if (board[X][Y] == true)
                return false;
            X++;
            Y--;
        }
        
        return true;
    }
    
    public static void checkValid(boolean[][] board)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (board[i][j] == true)
                {
                    if (!valid(board, i, j))
                    {
                        System.out.println("invalid");
                        return;
                    }
                }
            }
        }
        System.out.println("valid");
    }
    
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];
        Scanner in = new Scanner(System.in);
        int queens = 0;
        for (int i = 0; i < 8; i++)
        {
            String line = in.nextLine();
            for (int j = 0; j < 8; j++)
            {
                if (line.charAt(j) == '*')
                {
                    board[i][j] = true;
                    queens++;
                }
                else
                    board[i][j] = false;
            }
        }
        if (queens != 8)
        {
            System.out.println("invalid");
            return;
        }
        
        checkValid(board);
        
    }
    
}