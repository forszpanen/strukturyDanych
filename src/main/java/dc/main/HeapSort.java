package dc.main;

public class HeapSort<T extends Comparable<T>> {
    T[] arr;
    HeapSort(T[] arr) {
        this.arr = arr;
    }

    public void sort()
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
        for (int i = n-1; i >= 0; i--)
        {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(i, 0);
        }
    }
    void heapify(int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
        if (largest != i)
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(n, largest);
        }
    }
    public void show() {
        System.out.println("=== SORT RESULTS ===");
        int nr = 0;
        System.out.print("[");
        for(int i = 0; i < arr.length; i++)
            if (nr++ == 0)
                System.out.print(arr[i]);
            else
                System.out.print(", " + arr[i].toString());
        System.out.println("]");
    }
}
