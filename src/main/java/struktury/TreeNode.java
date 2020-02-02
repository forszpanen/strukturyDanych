package struktury;

public class TreeNode<T> {
    private T item;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public TreeNode<T> getLeft() {
        return left;
    }
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    public TreeNode<T> getRight() {
        return right;
    }
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    public TreeNode(T item)  {
        this.item = item;
        this.left = null;
        this.right = null;
    }
}
