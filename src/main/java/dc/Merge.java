package dc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Merge {
    public static int[] getSet1() {
        return set1;
    }

    public static int[] getSet2() {
        return set2;
    }

    private static int[] set1;
    private static int[] set2;

    public static void main(String[] args) {
        Merge merge = new Merge(5000, 6000, 1,2000, 110, 3000);
        //region pomiar czasu dla intersection()
        LocalDateTime startT, endT;
        startT = LocalDateTime.now();

        Integer[] res = merge.intersection();

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
        //region pomiar czasu dla merge na posortowanym zbiorze
        startT = LocalDateTime.now();
        CountingSort cs = new CountingSort();
        int[] tab1 = getSet1();
        int[] tab2 = getSet2();
        cs.setTable(tab1);
        cs.sort();
        tab1 = cs.getTable();
        cs.setTable(tab2);
        cs.sort();
        tab2 = cs.getTable();
        res = merge.intersection(tab1, tab2);

        endT = LocalDateTime.now();
        gap = ChronoUnit.MILLIS.between(startT, endT);
        time = (double)gap/1000;
        System.out.format("Time of intersection sorted = %.3f sec.%n", time);
        show(res);
    }
    public Merge(int size1, int size2, int from1, int to1, int from2, int to2) {
        set1 = new int[size1];
        set2 = new int[size2];
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

    /**
     * Metoda inicjujaca tablice set1 i set2
     * @param from1 poczatek zakresu generowanych liczb dla zbioru set1
     * @param to1 koniec zakresu generowanych liczb dla zbioru set1
     * @param from2
     * @param to2
     */
    private void init(int from1, int to1, int from2, int to2) {
        System.out.println("init");
        int ile = 0;
        do {
            int x = (int)(Math.random()*(to1 - from1 + 1)) + from1;
                set1[ile++] = x;
        } while (ile < set1.length);
        ile = 0;
        do {
            int x = (int)(Math.random()*(to2 - from2 + 1)) + from2;
                set2[ile++] = x;
        } while (ile < set2.length);
        System.out.println("end init");
    }

    /**
     * Czesc wspolna zbiorow (S1 AND S2)
     * @return tablica liczb stanowiacych czesc wspolna zbioru wartosci tablic set1 i set2
     */
    public Integer[] intersection() {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < set1.length; i++)
            for(int j = 0; j < set2.length; j++)
                if (set1[i] == set2[j])
                    if (!hs.contains(set1[i]))
                      hs.add(set1[i]);
        Integer[] tab = new Integer[hs.size()];
        return hs.toArray(tab);
    }
    public Integer[] intersection(int[] tab1, int[] tab2) {
        HashSet<Integer> hs = new HashSet<>();
        int i = 0;
        int j = 0;
        boolean koniec = false;
        do { if (tab1[i] < tab2[j]) {
                hs.add(tab1[i]);
                i++;
                if (i >= tab1.length)
                    koniec = true;
            }
            else
                if (tab1[i] > tab2[j]) {
                        hs.add(tab2[j]);
                    j++;
                    if (j >= tab2.length)
                        koniec = true;
                }
                else { // sąrówne
                        hs.add(tab1[i]);
                    i++; j++;
                    if (i >= tab1.length || j >= tab2.length)
                        koniec = true;
                }
        } while (!koniec);
        if (i < tab1.length) {
            for(int k = i; k < tab1.length; k++)
                hs.add(tab1[k]);
        }
        if (j < tab2.length) {
            for(int k = j; k < tab2.length; k++)
                hs.add(tab2[k]);
        }
        Integer[] tab = new Integer[hs.size()];
        return hs.toArray(tab);
    }

    /**
     * Suma zbiorow (S1 OR S2)
     * @return tablica liczb stanowiacych roznice: zbior wartosci tablicy set1 bez elementow z tablicy set2
     */
    public Integer[] union() {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < set1.length; i++)
            set.add(set1[i]);
        for(int j = 0; j < set2.length; j++)
            if (!set.contains(set2[j]))
                set.add(set2[j]);
        Integer[] tab = new Integer[set.size()];
        return set.toArray(tab);
    }

    /**
     * Roznica zbiorow (S1 - S2)
     * @return
     */
    public Integer[] complement() {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < set1.length; i++)
            set.add(set1[i]);
        for(int j = 0; j < set2.length; j++)
            set.remove(set2[j]);
        Integer[] tab = new Integer[set.size()];
        return set.toArray(tab);
    }

    public static void show(Integer[] tab) {
        System.out.println("[");
        int numer = 0;
        for(int i = 0; i < tab.length; i++) {
            if (numer++ > 0)
                System.out.print(String.format(", %3d ", tab[i]));
            else
                System.out.print(String.format("%3d ", tab[i]));
            if (numer % 27 == 0) {
                System.out.println(",");
                numer = 0;
            }
        }
        System.out.println("\n]");
    }
}
