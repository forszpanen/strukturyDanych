package dc.main;

import struktury.BST;
import struktury.BSTNode;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        try {
            bst.add(7);
            bst.addAll(8, 1, 2, 5, 7, 9, 6, 3, 11, 17, 2, 4);
            List<Integer> lista1 = bst.inOrder();
            List<Integer> lista2 = bst.postOrder();
            List<Integer> lista3 = bst.preOrder();
            int nr = 0;
            System.out.println("in order");
            System.out.print("[");
            for(int i : lista1)
                if (nr++ > 0)
                    System.out.print(", " + i);
                else
                    System.out.print(i);
            System.out.println("]");
            System.out.println("post order");
            System.out.print("[");
            nr = 0;
            for(int i : lista2)
                if (nr++ > 0)
                    System.out.print(", " + i);
                else
                    System.out.print(i);
            System.out.println("]");
            System.out.println("pre order");
            System.out.print("[");
            nr = 0;
            for(int i : lista3)
                if (nr++ > 0)
                    System.out.print(", " + i);
                else
                    System.out.print(i);
            System.out.println("]");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        for(int i = 0; i < 1000_000; i++) {
            int x = (int)(Math.random()*2_500_000);
            try {
                bst.add(x);
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        LocalDateTime startT = LocalDateTime.now();
        for(int i = 1; i < 2_500_000; i++)
            if (bst.contains(i))
                ;//System.out.println(i + " ");
        LocalDateTime endT = LocalDateTime.now();
        long gap = ChronoUnit.MILLIS.between(startT, endT);
        double time = (double)gap/1000;
        System.out.format("Time of searching = %.3f sec.%n", time);
    }
}
