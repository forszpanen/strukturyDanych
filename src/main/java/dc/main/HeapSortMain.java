package dc.main;

public class HeapSortMain {
    public static void main(String[] args) {
        Integer tab[] = {12, 7, 2, 3, 4, 11, 9, 13, 1, 5, 6, 8};
        HeapSort<Integer> hs = new HeapSort<Integer>(tab);
        hs.sort();
        System.out.println("=== HEAPSORT RESULTS ===");
        hs.show();
    }
}
