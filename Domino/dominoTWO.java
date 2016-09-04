//package unweightedgraphs;

import java.util.*;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

//Provided class which improves Java's input read speed
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
    return peekToken() != null;
    }

    public int getInt() {
    return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
    return Double.parseDouble(nextToken());
    }

    public long getLong() {
    return Long.parseLong(nextToken());
    }

    public String getWord() {
    return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
    if (token == null) 
        try {
        while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        token = st.nextToken();
        } catch (IOException e) { }
    return token;
    }

    private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
    }
}

public class dominoTWO {

    public static boolean[] tipped;
    public static int fallen;
    public static int n;
    
    public dominoTWO(int num)
    {
        tipped = new boolean[num];
        n = num;
        fallen = 0;
    }
    
    public static void updateFallen(Vector[] adj, int p)
    {
        if (tipped[p])
            return;
        
        tipped[p] = true;
        fallen++;
        
//      for (int i = 0; i < n; i++)
//          System.out.print(tipped[i] + " ");
//      System.out.println();
        
        
        for (int i = 0; i < adj[p].size(); i++)
        {
            updateFallen(adj, (Integer) adj[p].elementAt(i));
        }
    }
    
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in, System.out);
        int cases = in.getInt();
        for (int a = 0; a < cases; a++)
        {
            int num = in.getInt(); //number of tiles
            int m = in.getInt();    //number of adjacencies
            int l = in.getInt();    //number of nudged tiles
            dominoTWO domino = new dominoTWO(num);
            Vector[] adj = new Vector[num];
            for (int i = 0; i < num; i++)
            {
                adj[i] = new Vector<Integer>();
            }
            for (int i = 0; i < m; i++)
            {
                int x = in.getInt();
                int y = in.getInt();
                x--;
                y--;
                adj[x].add(y);
            }
            
//          for (int i = 0; i < num; i++)
//          {
//              System.out.print(i + " ");
//              for (int j = 0; j < adj[i].size(); j++)
//              {
//                  System.out.print((Integer) adj[i].elementAt(j) + " ");
//              }
//              System.out.println();
//          }
//          System.out.println(fallen);
            for (int i = 0; i < l; i++)
            {
                int p = in.getInt();
                updateFallen(adj, p-1);
            }
            System.out.println(fallen);
            
//          for (int i = 0; i < tipped.length; i++)
//              System.out.println((1+i) + " " + tipped[i] + " ");
        }
    }
}

