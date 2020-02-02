package dc;

import java.util.Comparator;

public class ShellSortGeneric<T extends Comparable<T>> {
    private int N;
    private T[] table;

    public static void main(String[]args){
      ShellSortGeneric<String> shell = new ShellSortGeneric<>(new String[]
              {
                      "kot", "wrona", "gawron", "pies", "tygrys", "krowa", "ala", "ma", "okapi", "skowronek", "biedronka",
                      "rosomak", "dudek", "zebra", "kaczka", "hiena", "lelek", "jaszczurka", "krokodyl", "bocian", "sowa"
              }
              );
      shell.sort();
      shell.show();
      Employee[] emp = new Employee[] {
              new Employee("John", "Smith", 6500, "IT specialist"),
              new Employee("Ann", "Croft", 6200, "CEO"),
              new Employee("Steven", "Kenin", 5200, "Seller"),
              new Employee("Alan", "Burry", 4780, "Driver"),
              new Employee("Helen", "Giles", 6400, "Department manager")
      };
      ShellSortGeneric<Employee> shellEmp = new ShellSortGeneric<>(emp);
      shellEmp.sort();
      shellEmp.show();
    }
    public ShellSortGeneric(T[] tab) {
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
                T x = table[j];
                i = j + h;
                while ((i < N) && (x.compareTo(table[i]) >0 )) {
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
        System.out.print("[");
        for(int i = 0; i < N; i++)
            if (nr++ == 0)
                System.out.print(table[i]);
            else
                System.out.print(", " + table[i].toString());
        System.out.println("]");
    }
}
