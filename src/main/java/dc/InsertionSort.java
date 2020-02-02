package dc;

public class InsertionSort {
    private Double table[];
    public InsertionSort(Double[] table) {
        this.table = table;
    }
    public void sort()
    {
        int n = table.length;
        for (int i = 1; i < n; ++i) {
            double key = table[i];
            int j = i - 1;
            while (j >= 0 && table[j] > key) {
                table[j + 1] = table[j];
                j = j - 1;
            }
            table[j + 1] = key;
        }
    }
    public void show() {
        System.out.println("=== INSERTION SORT RESULTS ===");
        int nr = 0;
        System.out.println("[");
        for(int i = 0; i < table.length; i++)
            if (nr++ == 0)
                System.out.print(table[i]);
            else
                System.out.print(", " + table[i]);
        System.out.println("]");

    }
}
