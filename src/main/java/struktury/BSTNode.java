package struktury;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTNode<T> {
    private BSTNode<T> parent;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private T data;
    private int count;

        public BSTNode(T data)
        {
            this(null, null, null, data);
        }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BSTNode(BSTNode<T> parent, BSTNode<T> leftChild, BSTNode<T> rightChild, T data)
        {
            this.parent = parent;
            this.left = leftChild;
            this.right = rightChild;
            this.data = data;
            this.count = 1;
        }

        public BSTNode <T> getParent()
        {
            return parent;
        }

        public void setParent(BSTNode <T> parent)
        {
            this.parent = parent;
        }

        public BSTNode <T> getLeft()
        {
            return left;
        }

        public void setLeft(BSTNode <T> left)
        {
            this.left = left;
        }

        public BSTNode <T> getRight()
        {
            return right;
        }

        public void setRight(BSTNode <T> right)
        {
            this.right = right;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public void removeChild(BSTNode<T> child)
        {
            if(child == null) return;
            if(this.getRight() == child)
            {
                this.setRight(null);
                return;
            }
            if(this.getLeft() == child)
                this.setLeft(null);
        }

        public Iterator<BSTNode> children()
        {
            List<BSTNode> childList = new LinkedList<>();
            if(this.left != null) childList.add(left);
            if(this.right != null) childList.add(right);
            return childList.iterator();
        }
}

