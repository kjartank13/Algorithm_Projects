import java.util.*;

public class walls {
    
    public static class Coords
    {
        double x;
        double y;
        public Coords(double a, double b)
        {
            x = a;
            y = b;
        }
    }
    
    public static class Crane
    {
        Coords location;
        boolean A, B, C, D;
        public Crane(Coords l)
        {
            location = l;
            A = false;
            B = false;
            C = false;
            D = false;
        }
        public void update(boolean a, boolean b, boolean c, boolean d)
        {
            A = a;
            B = b;
            C = c;
            D = d;
        }
    }
    
    public static Double dist(Coords a, Coords b)
    {
        double X = Math.pow((a.x - b.x), 2);
        double Y = Math.pow((a.y - b.y), 2);
        return Math.sqrt(X + Y);
    }
    
    public static boolean anyCovered(Crane x)
    {   return (x.A || x.B || x.C || x.D);  }
    
    
    public static boolean oneCoverage(Crane x)
    {   return (x.A && x.B && x.C && x.D);  }
    public static boolean twoCoverage(Crane x, Crane y)
    {   return ((x.A || y.A) && (x.B || y.B) && (x.C || y.C) && (x.D || y.D));  }
    public static boolean threeCoverage(Crane x, Crane y, Crane z)
    {   return ((x.A || y.A || z.A) && (x.B || y.B || z.B)
                && (x.C || y.C || z.C) && (x.D || y.D || z.D)); }
    public static boolean fourCoverage(Crane x, Crane y, Crane z, Crane w)
    {   return ((x.A || y.A || z.A || w.A) && (x.B || y.B || z.B || w.B)
                && (x.C || y.C || z.C || w.C) && (x.D || y.D || z.D || w.D));   }

    
    
    
    
    //new Coverage
    public static String Coverage(Vector<Crane> CV)
    {
        if (CV.size() == 1)
        {
            if (oneCoverage(CV.elementAt(0)))
                return "1";
            else
                return "Impossible";
        }
        else if (CV.size() == 2)
        {
            if (oneCoverage(CV.elementAt(0)) || oneCoverage(CV.elementAt(1)))
                return "1";
            else if (twoCoverage(CV.elementAt(0), CV.elementAt(1)))
                return "2";
            else
                return "Impossible";
        }
        else if (CV.size() == 3)
        {
            for (int i = 0; i < 3; i++)
            {
                if (oneCoverage(CV.elementAt(i)))
                    return "1";
            }
            if (twoCoverage(CV.elementAt(0), CV.elementAt(1))
                || twoCoverage(CV.elementAt(0), CV.elementAt(2))
                || twoCoverage(CV.elementAt(1), CV.elementAt(2)))
                return "2";
            else if (threeCoverage(CV.elementAt(0), CV.elementAt(1), CV.elementAt(2)))
                return "3";
            return "Impossible";
        }
        else
        {
            for (int i = 0; i < CV.size(); i++)
            {
                if (oneCoverage(CV.elementAt(i)))
                    return "1";
            }
            for (int i = 0; i < CV.size(); i++)
            {
                for (int j = i+1; j < CV.size(); j++)
                    if (twoCoverage(CV.elementAt(i), CV.elementAt(j)))
                        return "2";
            }
            for (int i = 0; i < CV.size(); i++)
            {
                for (int j = i+1; j < CV.size(); j++)
                {
                    for (int k = j+1; k < CV.size(); k++)
                    {
                        if (threeCoverage(CV.elementAt(i), CV.elementAt(j), CV.elementAt(k)))
                            return "3";
                    }
                }
            }
            for (int i = 0; i < CV.size(); i++)
            {
                for (int j = i+1; j < CV.size(); j++)
                {
                    for (int k = j+1; k < CV.size(); k++)
                    {
                        for (int l = k+1; l < CV.size(); l++)
                        {
                            if (fourCoverage(CV.elementAt(i), CV.elementAt(j), CV.elementAt(k), CV.elementAt(l)))
                                return "4";
                        }
                    }
                }
            }
            
        }
        
        return "Impossible";
    }
    //new coverage end
    
    
    
    
    
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split("\\ ");
        double l = Double.parseDouble(data[0]); //house length
        double w = Double.parseDouble(data[1]); //house width
        int n = Integer.parseInt(data[2]);      //number of possible crane locations
        double r = Double.parseDouble(data[3]); //reach of each crane
        //      if (n == 0)
        //      {
        //          System.out.println("Impossible");
        //          return;
        //      }
        //      if (l < 1 || l > 30 || w < 1 || w > 30 || n < 1 || n > 30 || r < 1 || r > 30)
        //          throw new IllegalArgumentException();
        Coords wallA =  new Coords(0, w/2);
        Coords wallB =  new Coords(l/2, 0);
        Coords wallC = new Coords(0, -w/2);
        Coords wallD = new Coords(-l/2, 0);
        Vector<Crane> uCrane = new Vector<Crane>();
        for (int i = 0; i < n; i++)
        {
            boolean a, b, c, d;
            a = false;
            b = false;
            c = false;
            d = false;
            String[] site = in.nextLine().split("\\ ");
            double loc1 = Double.parseDouble(site[0]);
            double loc2 = Double.parseDouble(site[1]);
            Coords loc = new Coords(loc1, loc2);
            //          if (loc.y < -100 || 100 < loc.y || loc.x < -100 || 100 < loc.x)
            //              throw new IllegalArgumentException();
            //          if (loc.x < wallB.x && loc.x > wallD.x && loc.y < wallA.y && loc.y > wallC.y)
            //              continue;
            Crane x = new Crane(loc);
            if (dist(wallA, loc) <= r)
            {
                a = true;
                //              System.out.println(dist(wallA, loc) + " a: " + a);
            }
            if (dist(wallB, loc) <= r)
            {
                b = true;
                //              System.out.println(dist(wallB, loc) + " b: " + b);
            }
            if (dist(wallC, loc) <= r)
            {
                c = true;
                //              System.out.println(dist(wallC, loc) + " c: " + c);
            }
            if (dist(wallD, loc) <= r)
            {
                d = true;
                //              System.out.println(dist(wallD, loc) + " d: " + d);
            }
            x.update(a, b, c, d);
            if (anyCovered(x))
                uCrane.add(x);
        }
        
        //      for (int i = 0; i < uCrane.size(); i++)
        //          System.out.println(uCrane.elementAt(i).location.x + " " + uCrane.elementAt(i).location.y);
        
        System.out.println(Coverage(uCrane));
        
    }
    
}

