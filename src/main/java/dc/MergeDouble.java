package dc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MergeDouble {
    public static double[] getSet1() {
        return set1;
    }

    public static double[] getSet2() {
        return set2;
    }

    private static double[] set1;
    private static double[] set2;

    public static void main(String[] args) {
        MergeDouble merge = new MergeDouble(5000, 6000, 1,2000, 110, 3000);
        //region pomiar czasu dla intersection()
        LocalDateTime startT, endT;
        startT = LocalDateTime.now();

        Double[] res = merge.intersection();

        endT = LocalDateTime.now();
        long gap = ChronoUnit.MILLIS.between(startT, endT);
        double time = (double)gap/1000;
        System.out.format("Time = %.3f sec.%n", time);
        //endregion
        //region pomiar czasu dla union()
        startT = LocalDateTime.now();
        res = merge.union();

        endT = LocalDateTime.now();
        gap = ChronoUnit.MILLIS.between(startT, endT);
        time = (double)gap/1000;
        System.out.format("Time = %.3f sec.%n", time);
        //endregion
        //region pomiar czasu dla complement()
        res = merge.complement();

        endT = LocalDateTime.now();
        gap = ChronoUnit.MILLIS.between(startT, endT);
        time = (double)gap/1000;
        System.out.format("Time = %.3f sec.%n", time);
        //endregion
        //region pomiar czasu dla merge z wykorzystaniem zbioru HashSet
        startT = LocalDateTime.now();
            merge.intersectionUsingHashSet();
        endT = LocalDateTime.now();
        gap = ChronoUnit.MILLIS.between(startT, endT);
        time = (double)gap/1000;
        System.out.format("Time of intersection sorted = %.3f sec.%n", time);
        show(res);
    }
    public MergeDouble(int size1, int size2, int from1, int to1, int from2, int to2) {
        set1 = new double[size1];
        set2 = new double[size2];
        init(from1, to1, from2, to2);
    }
    private void initUnique(int from1, int to1, int from2, int to2) {
        List<Integer> lista = new ArrayList<Integer>();
        int ile = 0;
        do {
            int x = (int)(Math.random()*(to1 - from1 + 1)) + from1;
            if (!lista.contains(x)) {
                set1[ile++] = x;
                lista.add(x);
            }
        } while (ile < set1.length);
        lista = new ArrayList<Integer>();
        ile = 0;
        do {
            int x = (int)(Math.random()*(to2 - from2 + 1)) + from2;
            if (!lista.contains(x)) {
                set2[ile++] = x;
                lista.add(x);
            }
        } while (ile < set2.length);
    }
    private void init(int from1, int to1, int from2, int to2) {
        System.out.println("init");
        int ile = 0;
        do {
            double x = Math.random()*(to1 - from1 + 1) + from1;
            set1[ile++] = x;
        } while (ile < set1.length);
        ile = 0;
        do {
            double x = Math.random()*(to2 - from2 + 1) + from2;
            set2[ile++] = x;
        } while (ile < set2.length);
        System.out.println("end init");
    }
    /**
     * Czesc wspolna zbiorow (S1 AND S2)
     * @return
     */
    public Double[] intersection() {
        HashSet<Double> hs = new HashSet<>();
        for(int i = 0; i < set1.length; i++)
            for(int j = 0; j < set2.length; j++)
                if (set1[i] == set2[j])
                    if (!hs.contains(set1[i]))
                        hs.add(set1[i]);
        Double[] tab = new Double[hs.size()];
        return hs.toArray(tab);
    }

    /**
     * Wykorzystanie HashSet'u do szybszego znalezienia czesci wspolnej 2 zbiorow
     * @return
     */
    public Double[] intersectionUsingHashSet() {
        Set<Double> hs1 = new HashSet<>();
        for(double d : set1)
            hs1.add(d);
        Set<Double> hs2 = new HashSet<>();
        for(double d : set2)
            hs2.add(d);
        Set<Double> hs = new HashSet<>();
        Iterator<Double> iterator = hs1.iterator();
        while(iterator.hasNext()) {
            double d = iterator.next();
            if (hs2.contains(d))
                hs.add(d);
        }
        Double[] tab = new Double[hs.size()];
        return hs.toArray(tab);
    }

    /**
     * Suma zbiorow (S1 OR S2)
     * @return
     */
    public Double[] union() {
        Set<Double> set = new HashSet<>();
        for(int i = 0; i < set1.length; i++)
            set.add(set1[i]);
        for(int j = 0; j < set2.length; j++)
            if (!set.contains(set2[j]))
                set.add(set2[j]);
        Double[] tab = new Double[set.size()];
        return set.toArray(tab);
    }

    /**
     * Roznica zbiorow (S1 - S2)
     * @return
     */
    public Double[] complement() {
        Set<Double> set = new HashSet<>();
        for(int i = 0; i < set1.length; i++)
            set.add(set1[i]);
        for(int j = 0; j < set2.length; j++)
            set.remove(set2[j]);
        Double[] tab = new Double[set.size()];
        return set.toArray(tab);
    }

    public static void show(Double[] tab) {
        System.out.println("[");
        int numer = 0;
        for(int i = 0; i < tab.length; i++) {
            System.out.print(String.format(" %.2f ", tab[i]));
            if (++numer % 16 == 0) {
                System.out.println();
                numer = 0;
            }
        }
        System.out.println("\n]");
    }
}
