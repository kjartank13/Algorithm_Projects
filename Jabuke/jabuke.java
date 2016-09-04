//package geometry;

import java.util.*;
import java.text.DecimalFormat;

public class jabuke {

    public static class Vertex
    {
        double x;
        double y;
        public Vertex(double a, double b)
        {
            x = a;
            y = b;
        }
    }
    
    public static double area(Vertex a, Vertex b, Vertex c)
    {
        double part1 = a.x * (b.y - c.y);
        double part2 = b.x * (c.y - a.y);
        double part3 = c.x * (a.y - b.y);
        double out = Math.abs(part1+part2+part3)/2;
        DecimalFormat df = new DecimalFormat("####0.0");
        return Double.parseDouble(df.format(out));
    }
    
    public static boolean isInTriangle(Vertex a, Vertex b, Vertex c, Vertex p, double ABC)
    {
        double PBC = area(p, b, c);
        double PAC = area(p, a, c);
        double PAB = area(p, a, b);
        
        return (ABC == PBC + PAC + PAB);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double maxX = Double.MIN_VALUE;
        double minX = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        Vertex[] corners = new Vertex[3];
        for (int i = 0; i < 3; i++)
        {
            double x = (double) in.nextInt();
            double y = (double) in.nextInt();
            if (x > maxX)
                maxX = x;
            if (x < minX)
                minX = x;
            if (y > maxY)
                maxY = y;
            if (y < minY)
                minY = y;
            corners[i] = new Vertex(x, y);
        }
        double ABC = area(corners[0], corners[1], corners[2]);
        System.out.println(ABC);
        
        int n = in.nextInt();
        int ownedTrees = 0;
        for (int i = 0; i < n; i++)
        {
            double x = (double) in.nextInt();
            double y = (double) in.nextInt();
            Vertex p = new Vertex(x, y);
            if (isInTriangle(corners[0], corners[1], corners[2], p, ABC))
            {
                ownedTrees++;
//              System.out.println(x + " " + y);
            }
        }
        System.out.println(ownedTrees);
    }
}