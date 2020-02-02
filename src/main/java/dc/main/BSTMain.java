package dc.main;

import struktury.BST;
import struktury.BSTNode;

import java.util.List;

public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        try {
            bst.add(7);
            bst.addAll(8, 1, 2, 5, 7, 9, 6, 3, 11, 17, 2, 4);
            List<Integer> lista = bst.inOrder();
            System.out.print("[");
            int nr = 0;
            for(int i : lista)
                if (nr++ > 0)
                    System.out.print(", " + i);
                else
                    System.out.print(i);
            System.out.println("]");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
