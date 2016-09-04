import java.util.*;

public class natjecanje {
    
    
    public static class Team
    {
        boolean okay;
        boolean res;
        public Team()
        {   okay = true; res = false;   }
        public void updateOkay(boolean o)
        {   okay = o;   }
        public void updateRes(boolean r)
        {   res = r;    }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String[] line = in.nextLine().split("\\ ");
        int n = Integer.parseInt(line[0]); //total number of teams
        int s = Integer.parseInt(line[1]); //initial number of teams with damaged kayaks
        int r = Integer.parseInt(line[2]); //initial number of teams with reserve kayaks
        
        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++)
        {
            teams[i] = new Team();
        }
        String[] damaged = in.nextLine().split("\\ "); //list of teams with damaged kayak
        for (int i = 0; i < damaged.length; i++)
        {
            teams[Integer.parseInt(damaged[i])-1].updateOkay(false);
        }
        String[] reserve = in.nextLine().split("\\ "); //list of teams with reserve kayak
        for (int i = 0; i < reserve.length; i++)
        {
            teams[Integer.parseInt(reserve[i])-1].updateRes(true);      //merge loops?
        }
        for (int i = 0; i < teams.length; i++)
        {
            if (teams[i].okay == false && teams[i].res == true)
            {
                teams[i].updateOkay(true);
                teams[i].updateRes(false);
                s--;
                r--;
            }
        }
        int s_a = s;
        int s_b = s;
        for (int i = 0; i < teams.length - 1; i++)
        {
            if (teams[i].res == true && teams[i+1].okay == false)
            {
                //              teams[i].updateRes(false);
                //              r--;
                //              teams[i+1].updateOkay(true);
                s_a--;
            }
        }
        for (int i = 1; i < teams.length; i++)
        {
            if (teams[i].res == true && teams[i-1].okay == false)
            {
                //              teams[i].updateRes(false);
                //              r--;
                //              teams[i-1].updateOkay(true);
                s_b--;
            }
        }
        if (s_a < s_b)
            System.out.println(s_a);
        else
            System.out.println(s_b);
    }
}

