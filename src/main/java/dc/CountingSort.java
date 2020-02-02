package dc;

import java.util.Arrays;

public class CountingSort {
    private int[] liczby;
    private final int SIZE = 100_000;
    public CountingSort() {
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        cs.init();
        cs.sort();
        cs.show();
        int[] tab = new int[100_000];
        int[] tab2 = new int[100_100];
        for(int i = 0; i < 100_000; i++) {
            tab[i] = (int) (Math.random() * 1000);
            tab2[i] = tab[i];
        }
        long startT = System.currentTimeMillis();
            Arrays.sort(tab);
        // best sort ... ?
        long stopT = System.currentTimeMillis();
        long elapsedTime = stopT - startT;
        System.out.println("\tbest:   " + elapsedTime);

        cs.setTable(tab2);
        startT = System.currentTimeMillis();
         cs.sort();
        // best sort ... ?
        stopT = System.currentTimeMillis();
        elapsedTime = stopT - startT;
        System.out.println("\tcount:   " + elapsedTime);

    }
    public void sort(int[] tablica) {
        int max = Arrays.stream(tablica).max().getAsInt();
        int[] robocza = new int[max+1];
        for(int i = 0; i < tablica.length; i++) {
           robocza[tablica[i]]++;
        }
        int numer = 0;
        for(int i = 0; i < max+1; i++)
            if (robocza[i] > 0) {
               while(robocza[i] > 0) {
                   tablica[numer++] = i;
                   robocza[i]--;
               }
        }
    }
    public void sort() {
        int[] robocza = new int[SIZE];
        for(int i = 0; i < SIZE; i++)
            robocza[i] = 0;
        for(int i = 0; i < liczby.length; i++)
            robocza[liczby[i]]++;
        int indeks = 0;
        for(int i = 0; i < SIZE; i++)
            while(robocza[i] > 0) {
                liczby[indeks++] = i;
                robocza[i]--;
            }
    }
    public void show() {
        System.out.println("[");
        int numer = 0;
        for(int i = 0; i < liczby.length; i++) {
            if (numer++ > 0)
                System.out.print(String.format(", %3d ", liczby[i]));
            else
                System.out.print(String.format("%3d ", liczby[i]));
            if (numer % 27 == 0) {
                System.out.println(",");
                numer = 0;
            }
        }
        System.out.println("\n]");
    }
    public void init() {
        liczby = new int[]{
            147 ,  11 ,  19 ,  43 ,  51 ,  43 , 149 ,  78 ,  67 ,  27 , 183 , 129 ,  83 ,  16 ,
             47 ,  61 ,   9 ,  42 ,  43 ,  42 ,  42 ,  78 ,  57 ,  37 , 283 ,  29 ,  84 ,   6 ,
             47 ,  51 ,  29 ,  41 ,  49 ,  41 ,  41 ,  78 ,  47 ,  47 ,  83 , 129 , 183 ,  26 ,
             41 , 191 , 129 , 143 ,  59 , 143 , 149 , 171 , 181 , 127 , 683 , 229 ,  83 ,  36 ,
             49 ,  91 ,  19 ,  43 , 159 , 243 , 449 , 778 , 587 , 227 ,  83 ,  29 , 283 , 126 ,
            347 , 891 , 119 , 843 , 759 , 543 , 449 , 778 , 587 , 527 , 683 , 129 , 383 ,  46 ,
              4 ,   1 ,   9 ,   3 ,   9 ,   3 ,  49 ,   8 ,   7 ,   2 ,   3 ,   9 ,  83 ,   6 ,
            612 , 164 , 425 , 424 , 746 , 246 , 184 , 526 , 458 , 100 , 267 , 200 , 453 , 158 ,
            182 , 147 , 663 , 234 , 315 , 722 , 356 , 551 ,  40 , 742 , 591 , 203 , 708 ,  10 ,
            365 , 868 , 629 , 630 , 610 , 651 , 680 ,  17 , 592 , 378 , 612 , 692 ,  47 , 770 ,
            101 , 719 ,  63 ,   9 , 756 , 824 , 748 , 419 , 466 ,  13 , 855 , 853 , 705 , 494 ,
             42 ,  41 ,  29 ,  43 ,  59 , 143 , 149 , 178 , 187 ,  27 ,  83 ,  39 ,  83 ,  26 ,
            353 , 505 , 811 , 562 , 161 , 431 , 302 , 584 , 151 , 269 , 760 , 764 ,  26 , 136 ,
            850 , 653 , 648 ,  76 , 392 , 887 , 291 , 674 ,  41 , 629 , 308 , 849 , 218 ,  23 ,
            748 , 174 , 375 , 178 , 175 , 503 , 198 , 616 ,  43 ,  81 , 340 , 301 , 157 , 223 ,
             14 ,  11 ,  19 ,  13 ,  19 ,  13 ,  29 ,  18 ,  17 ,  12 ,   3 ,  19 ,  23 ,  16 ,
            222 ,  92 , 261 , 273 ,  81 , 261 , 815 ,  74 , 437 , 669 , 796 , 792 ,  20 , 737 ,
            670 , 884 , 330 , 505 , 650 , 830 , 416 , 463 ,  24 ,  97 , 156 , 404 ,  51 ,  55 ,
             43 ,  48 ,  39 ,  43 , 159 ,  47 ,  49 , 278 , 287 , 127 ,  53 ,  49 , 183 , 126 ,
            562 , 398 , 627 , 291 , 261 , 320 , 562 , 597 , 147 ,  15 ,  49 ,  52 , 306 , 452 ,
            706 , 866 ,  45 , 356 ,  73 , 829 , 716 ,  29 , 451 , 455 , 110 , 657 , 784 , 874 ,
            457 , 361 , 631 , 378 , 561 ,  34 , 259 , 537 , 459 , 810 , 173 ,  29 , 204 , 164 ,
            240 , 420 , 858 , 605 , 748 , 313 , 597 , 336 ,   4 ,  60 ,  93 , 214 , 826 ,  48 ,
             68 , 200 ,  38 , 867 , 358 , 288 , 541 , 216 , 342 , 495 , 399 , 224 ,  68 , 656 ,
            238 , 701 , 330 , 801 , 622 , 473 , 695 , 469 ,  44 , 564 , 479 , 454 , 727 , 106 ,
             87 , 214 , 441 ,  99 , 664 , 305 , 141 , 683 , 212 , 824 , 571 , 415 ,  52 , 174 ,
            477 , 753 ,  21 ,  40 , 880 , 766 ,   8 , 845 , 631 , 105 , 564
    };
}
    public void setTable(int[] table) {
        this.liczby = table;
    }
    public int[] getTable() {
        return this.liczby;
    }
}