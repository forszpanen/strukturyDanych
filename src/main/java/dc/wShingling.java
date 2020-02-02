package dc;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class wShingling {

    public static void main(String[] args) {
        wShingling ws = new wShingling();
        String plik1 = "test1.txt";
        String plik2 = "test2.txt";
        String[] wyrazy1 = ws.readFile(plik1);
        String[] wyrazy2 = ws.readFile(plik2);
        HashSet<Integer> hs1 = ws.changeToHashSet(wyrazy1);
        HashSet<Integer> hs2 = ws.changeToHashSet(wyrazy2);
        float res = ws.compareFiles(hs1,hs2);
        System.out.format("Similarity for %s and %s = %.3f %n", plik1, plik2, res);
    }
    public wShingling() {
    }
    public String[] readFile(String fileName) {
        File file = new File(fileName);
        String plik = "";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buRead = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String line;
            while ((line = buRead.readLine())!= null) {
                plik += line;
            }
            buRead.close();
            reader.close();
        }
        catch(IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        String[] tokens = plik.split("\\W");
        return tokens;
    }
    private HashSet<Integer> changeToHashSet(String[] wyrazy)
    {
        Integer[] inty = new Integer[wyrazy.length];
        HashSet<Integer> szin = new HashSet<Integer>();
        for (int i = 0; i < wyrazy.length; i++)
        {
            Integer h = 0;
            for (char c  : wyrazy[i].toCharArray())
            {
                h = (h << 3) +(int)c;
            }
            h = h % 391397;
            inty[i] = h;
        }
        for (int i = 0; i < wyrazy.length - 3; i++)
        {
            Integer x = (inty[i] + inty[i + 1] + inty[i + 2] + inty[i + 3]) % 391397;
            szin.add(x);
        }
        return szin;
    }
    private float compareFiles(HashSet<Integer> hasze1, HashSet<Integer> hasze2)
    {
        Iterator<Integer> iterator = hasze1.iterator();
        int ile = 0;
        while (iterator.hasNext())
        {
            if (hasze2.contains(iterator.next()))
               ile++;
        }
        float average = (hasze1.size() + hasze2.size()) / 2;
        float result = (float)ile/average;
        return result;

    }
}
