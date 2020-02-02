package dc;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {
    private static int SIZE = 10;
    private static int[] tab;

    public Permutations(int size) {
        SIZE = size;
        tab = new int[SIZE+1];
        for(int i = 0; i <= SIZE; i++)
            tab[i] = i;
    }
    public void showAllPermutations() {
        boolean koniec = false;
        do {
            show();
            if (tab[SIZE-1] < tab[SIZE]) {
                swap(SIZE-1, SIZE);
            }
            else {
                boolean stop = false;
                int nr = SIZE - 1;
                do {
                    if (tab[nr - 1] < tab[nr])
                        stop = true;
                    else {
                        nr--;
                        if (nr == 0) {
                            koniec = true;
                            stop = true;
                        }
                    }
                } while (!stop);
                if (!koniec) {
                    ArrayList<Integer> liczby = new ArrayList<>();
                    int t = tab[nr - 1];
                    int mini = 999;
                    for (int i = nr; i <= SIZE; i++) {
                        liczby.add(tab[i]);
                        if (tab[i] > t && tab[i] < mini)
                            mini = tab[i];
                    }
                    liczby.add(tab[nr - 1]);
                    Collections.sort(liczby);
                    tab[nr - 1] = mini;
                    tab[nr] = liczby.get(0);
                    int j = 1;
                    for (int i = nr + 1; i <= SIZE; i++) {
                        if (liczby.get(j) == mini) j++;
                        tab[i] = liczby.get(j);
                        j++;
                    }
                }
            }
        } while (!koniec);
        //1 2 3 4 5 6 7 8 9 10 11 12
        //1 2 3 4 5 6 7 8 9 10 12 11
        //1 2 3 4 5 6 7 8 9 11 10 12
        //1 2 3 4 5 6 7 8 9 11 12 10
        //1 2 3 4 5 6 7 8 9 12 10 11
        //1 2 3 4 5 6 7 8 9 12 11 10
        //1 2 3 4 5 6 7 8 10 9 11 12
        //1 2 3 4 5 6 7 8 10 9 12 11
    }
    private void swap(int nr1, int nr2) {
        int t = tab[nr1];
        tab[nr1] = tab[nr2];
        tab[nr2] = t;
    }

    private void show() {
        System.out.print("[");
        int nr = 0;
        for (int i = 0; i <=SIZE; i++)
            if (nr++ >0)
                System.out.print(", " + tab[i]);
            else
                System.out.print(tab[i]);
        System.out.println("]");
    }

    public static void main(String[] args) {
        Permutations per = new Permutations(11);
        per.showAllPermutations();
    }
}
