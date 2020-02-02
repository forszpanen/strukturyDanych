package struktury;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BST<T extends Comparable<T>>
{
    private BSTNode<T> root;
    private int size;

    public BST() {}

    private BSTNode<T> root()
    {
        return root;
    }

    private void addRoot(T data) throws Exception
    {
        if(root != null)
            throw new Exception("Root exists is the tree.");
        root = new BSTNode <>(data);
        size++;
    }

    public void add(T data) throws Exception
    {
        BSTNode<T> node = find(data);
        if (node == null) {
            addRoot(data);
            return;}
        /*
        else if (node.getData().compareTo(data) >= 0)
            addLeft(node, data);
        else if (node.getData().compareTo(data) < 0)
            addRight(node, data);
        */
        if (node.getData().compareTo(data) > 0) {
            addLeft(node, data);
            return;
        }
        if (node.getData().compareTo(data) < 0) {
            addRight(node, data);
            return;
        }
        else
         node.setData(data);
         node.setCount(node.getCount() + 1);

    }

    private void addLeft(BSTNode<T> parent, T data)
    {
        BSTNode<T> left = new BSTNode <>(data);
        parent.setLeft(left);
        left.setParent(parent);
        size++;
    }

    private void addRight(BSTNode<T> parent, T data)
    {
        BSTNode<T> right = new BSTNode <>(data);
        parent.setRight(right);
        right.setParent(parent);
        size++;
    }

    public void remove(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return;
        remove(node);
    }

    private BSTNode<T> remove(BSTNode<T> node)
    {
        if (isLeaf(node))
        {
            BSTNode<T> parent = node.getParent();
            if (parent == null) root = null;
            else parent.removeChild(node);
            size--;
            return parent;
        }
        BSTNode<T> descendant = descendant(node);
        promoteDescendant(node, descendant);
        return remove(descendant);
    }

    private void promoteDescendant(BSTNode<T> parent, BSTNode<T> descendant)
    {
        parent.setData(descendant.getData());
    }

    private BSTNode<T> descendant(BSTNode<T> parent)
    {
        BSTNode<T> child = parent.getLeft();
        if (child != null)
        {
            while (child.getRight() != null) child = child.getRight();
            return child;
        }
        child = parent.getRight();
        if (child != null)
        {
            while (child.getLeft() != null) child = child.getLeft();
            return child;
        }
        return child;
    }

    public T get(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return null;
        return node.getData();
    }

    public boolean contains(T data)
    {
        BSTNode<T> node = find(data);
        if(node == null || !node.getData().equals(data)) return false;
        return true;
    }

    private BSTNode<T> find(T data)
    {
        if(root() == null) return null;
        return findRecursively(root(), data);
    }

    private BSTNode<T> findRecursively(BSTNode<T> parent, T data)
    {
        int comparison = data.compareTo(parent.getData());
        if(comparison == 0) return parent;
        else if(comparison < 0 && parent.getLeft() != null) return findRecursively(parent.getLeft(), data);
        else if(comparison > 0 && parent.getRight() != null) return findRecursively(parent.getRight(), data);
        return parent;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int size()
    {
        return size;
    }

    private BSTNode<T> parent(BSTNode<T> child)
    {
        return child.getParent();
    }

    private boolean isInternal(BSTNode<T> node)
    {
        return node.children().hasNext();
    }

    private boolean isLeaf(BSTNode<T> node)
    {
        return !isInternal(node);
    }

    private int depth(BSTNode<T> node)
    {
        if(isLeaf(node)) return 0;
        return depth(node.getParent()) + 1;
    }

    private int height(BSTNode<T> node)
    {
        if(isLeaf(node)) return 0;

        int maxHeight = 0;
        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            int height = height(children.next());
            if(height > maxHeight) maxHeight = height;
        }
        return maxHeight + 1;
    }

    public int height()
    {
        if(root == null) return -1;
        return height(root);
    }

    public List<T> preOrder()
    {
        List<T> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(BSTNode<T> node, List<T> list)
    {
        if(node == null) return;
        for(int i = 0; i < node.getCount();i++)
            list.add(node.getData());

        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            preOrder(children.next(), list);
        }
    }

    public List<T> postOrder()
    {
        List<T> list = new LinkedList <>();
        postOrder(root(), list);
        return list;
    }

    private void postOrder(BSTNode<T> node, List<T> list)
    {
        if(node == null) return;

        Iterator<BSTNode> children = node.children();
        while (children.hasNext())
        {
            postOrder(children.next(), list);
        }
        for(int i = 0; i < node.getCount(); i++)
            list.add(node.getData());
    }

    /**
     * Przejscie przez drzewo poziomami (BFS = breadth-first search)
     * @return
     */
    public List<T> BFS()  {
        List<T> nodeList = new LinkedList <>();
        if(root() == null) return nodeList;
        Queue<BSTNode> nodeQueue = new ConcurrentLinkedQueue <>();
        try
        {
            nodeList.add(root().getData());
            nodeQueue.add(root());
            while (!nodeQueue.isEmpty())
            {
                BSTNode<T> node = nodeQueue.poll();
                Iterator<BSTNode> nodeItr = node.children();
                while (nodeItr.hasNext())
                {
                    BSTNode<T> treeNode = nodeItr.next();
                    nodeQueue.add(treeNode);
                    nodeList.add(treeNode.getData());
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return nodeList;
    }

    public List<T> inOrder()
    {
        List<T> answer = new LinkedList <>();
        inOrder(root(), answer);
        return answer;
    }
    private void inOrder(BSTNode<T> node, List<T> list)
    {
        if (node == null) return;
        inOrder(node.getLeft(), list);
        for(int i = 0; i < node.getCount();i++)
            list.add(node.getData());
        inOrder(node.getRight(), list);
    }
    @Override
    public String toString()
    {
        return inOrder().toString();
    }
    public void addAll(T...nodes) {
        try {
            for (T node : nodes)
                this.add(node);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}