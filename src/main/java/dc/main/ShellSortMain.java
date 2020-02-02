package dc.main;

import dc.CountingSort;
import dc.InsertionSort;
import dc.ShellSort;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSortMain {
    public static void main(String[] args) {
        Double[] tab = new Double[]
        {1.0, 5.3, 2.3, 5.7, 7.1, 2.1, 1.3, 1.5, 4.5};
        ShellSort shell = new ShellSort(tab);
        shell.sort();
        shell.show();
        InsertionSort insert = new InsertionSort(tab);
        insert.sort();
        insert.show();
        CountingSort cs = new CountingSort();
        int N = 40_000;
        do {
            System.out.println("=== RESULTS for:" + N + " ===");
            ArrayList<Double> lista = new ArrayList<Double>();
            for (int i = 0; i < N; i++) {
                lista.add((Math.random()* N + i)); // raz z random*N , a raz z random*N + i
            }
            long startT = System.currentTimeMillis();
            Arrays.sort(lista.toArray());
            // best sort ... ?
            long stopT = System.currentTimeMillis();
            long elapsedTime = stopT - startT;
            System.out.println("\tbest:   " + elapsedTime);
            Double[] du = new Double[lista.size()];
            Double[] tb = lista.toArray(du);
            // shell sort
            //shell = new ShellSort(tb);
            //startT = System.currentTimeMillis();
                shell.sort();
            stopT = System.currentTimeMillis();
            elapsedTime = stopT - startT;
            System.out.println("\tshell:  " + elapsedTime);
            // insertion sort
            tb = lista.toArray(du);
            insert = new InsertionSort(tb);
            startT = System.currentTimeMillis();
                insert.sort();
            stopT = System.currentTimeMillis();
            elapsedTime = stopT - startT;
            System.out.println("\tinsert: " + elapsedTime);
            N+= 40_000;
        }
        while (N <= 160_000);

    }
}
