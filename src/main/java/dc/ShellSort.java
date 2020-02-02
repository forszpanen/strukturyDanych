package dc;

/*
 Dobre wytlumaczenie algorytmu znajdziesz tutaj: https://eduinf.waw.pl/inf/alg/003_sort/m0012.php
 */
public class ShellSort {
    private int N;
    private Double[] table;

    public ShellSort(Double[] tab) {
        table = tab;
        N = tab.length;
    }
    public void sort() {
        int h, i;
        for( h = 1; h < N; h = 3 * h + 1);
        h /= 9;
        if (h == 0) h++; // istotne dla malych N, dla wiekszych mozna pominac!
        while (h > 0) {
            for (int j = N - h - 1; j >= 0; j--) {
                double x = table[j];
                i = j + h;
                while ((i < N) && (x > table[i])) {
                    table[i - h] = table[i];
                    i += h;
                }
                table[i - h] = x;
            }
            h /= 3;
        }
    }
    public void show() {
        System.out.println("=== SHELL SORT RESULTS ===");
        int nr = 0;
        System.out.println("[");
        for(int i = 0; i < N; i++)
            if (nr++ == 0)
                System.out.print(table[i]);
            else
                System.out.print(", " + table[i]);
        System.out.println("]");
    }
}
