package dc.main;

import struktury.BinaryTree;
import struktury.TreeNode;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree<String> drzewo = new BinaryTree<String>();
        TreeNode<String> n1 = new TreeNode<>("ala");
        TreeNode<String> n2 = new TreeNode<>("ela");
        TreeNode<String> n3 = new TreeNode<>("ola");
        TreeNode<String> n4 = new TreeNode<>("ula");
        TreeNode<String> n5 = new TreeNode<>("uma");
        TreeNode<String> n6 = new TreeNode<>("uta");
        drzewo.add(n1);
        drzewo.add(n2);
        drzewo.add(n3);
        drzewo.add(n4);
        drzewo.add(n5);
        drzewo.add(n6);
        drzewo.showTree();
        drzewo.deleteAll();
    }
}
