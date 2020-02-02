package struktury;

public class BinaryTree<T> {
    private TreeNode<T> root;
    private int size;

    public int getSize() {
        return size;
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }
    public void add(TreeNode<T> node) {
        if (root == null) {
            root = node;
            root.setRight(null);
            root.setLeft(null);
            size = 1;
        }
        else {
            if (root.getLeft() == null) {
                root.setLeft(node);
                size++;
                return;
            }
            if (root.getRight() == null) {
                root.setRight(node);
                size++;
                return;
            }
            double x = Math.random();
            if (x > 0.5)
               add(root.getLeft(), node);
            else
               add(root.getRight(), node);
        }
    }
    public void add(TreeNode<T> where, TreeNode<T> node) {
        if (where.getLeft() == null) {
            where.setLeft(node);
            size++;
            return;
        }
        if (where.getRight() == null) {
            where.setRight(node);
            size++;
            return;
        }
        double x = Math.random();
        if (x > 0.5)
           add(where.getLeft(), node);
        else
           add(where.getRight(), node);
    }
    public TreeNode<T> getRoot() {
        return root;
    }
    public void deleteAll() {
        deleteAll(root);
    }
    public void deleteAll(TreeNode<T> node) {
        if (node != null) {
            deleteAll(node.getLeft());
            deleteAll(node.getRight());
        }

    }
    public void preOrder(TreeNode<T> node) {
        if(node != null) {
            System.out.println(node.getItem()); // odwiedzamy węzeł
            preOrder (node.getLeft());      // przechodzimy lewe poddrzewo
            preOrder ( node.getRight());     // przechodzimy prawe poddrzewo
        }
    }
    public void inOrder(TreeNode<T> node) {
        if(node != null) {
            inOrder (node.getLeft());      // przechodzimy lewe poddrzewo
            System.out.println(node.getItem()); // odwiedzamy węzeł
            inOrder ( node.getRight());     // przechodzimy prawe poddrzewo
        }
    }
    public void postOrder(TreeNode<T> node) {
        if(node != null) {
            postOrder (node.getLeft());      // przechodzimy lewe poddrzewo
            postOrder ( node.getRight());     // przechodzimy prawe poddrzewo
            System.out.println(node.getItem()); // odwiedzamy węzeł
        }
    }

    /**
     * Procedura przechodzenia w drzewie BFS breadth-first search (wszerz, lub poziomami)
     */
    public void BFS() {
        java.util.Queue<TreeNode<T>> kolejka = new java.util.LinkedList<TreeNode<T>>();
        kolejka.add(root);
        while(!kolejka.isEmpty()) {
            TreeNode<T> node = kolejka.poll();
            System.out.println(node.getItem());
            if (node.getLeft() != null)
                kolejka.add(node.getLeft());
            if (node.getRight() != null)
                kolejka.add(node.getRight());
        }
    }
    public void printBinaryTree() {
        System.out.println("=== PRINT TREE ===");
        printBinaryTree(root, 0);
    }

    /**
     * Drukowanie od lewej do prawej
     * @param root
     * @param level
     */
    public static void printBinaryTree(TreeNode root, int level){
        if(root == null)
            return;
        printBinaryTree(root.getLeft(), level + 1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-----" + root.getItem());
        }
        else
            System.out.println(root.getItem());
        printBinaryTree(root.getRight(), level + 1);
    }

    public void showTree() {
        printBinaryTree();
        System.out.println("=== SHOW TREE (PRE ORDER TRAVERSAL) ===");
        preOrder(root);
        System.out.println("=== SHOW TREE (IN ORDER TRAVERSAL) ===");
        inOrder(root);
        System.out.println("=== SHOW TREE (POST ORDER TRAVERSAL) ===");
        postOrder(root);
        System.out.println("=== SHOW TREE BF S( BREAD FIRST TRAVERSAL) ===");
        BFS();
    }
}
