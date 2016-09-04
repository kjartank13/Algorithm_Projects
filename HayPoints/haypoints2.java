import java.util.*;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


//Provided class for improving Java's input reading speed
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

public class haypoints2 {
    
    public static void main(String[] args){
        //        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Kattio in = new Kattio(System.in, System.out);
        //        String[] ins = in.readLine().split("\\ ");
        int words = Integer.parseInt(in.getWord());
        int descs = Integer.parseInt(in.getWord());
        HashMap dict = new HashMap();
        for (int i = 0; i < words; i++)
        {
            String w = in.getWord();
            int v = Integer.parseInt(in.getWord());
            dict.put(w, v);
        }
        for (int i = 0; i < descs; i++)
        {
            int worth = 0;
            boolean dot = false;
            while (!dot)
            {
                String line = in.getWord();
                if (line.matches("\\p{Punct}"))
                {
                    dot = true;
                    continue;
                }
                
                if (dict.containsKey(line))
                    worth += (Integer)dict.get(line);
                
            }
            System.out.println(worth);
        }
    }
}