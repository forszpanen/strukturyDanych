package struktury;

import java.util.ArrayList;

public class Node<T> {
    private T item;
    private ArrayList<Node<T>> nextItems;
    public Node(T item) {
        this.item = item;
        this.nextItems = new ArrayList<Node<T>>();
    }
    public void addNode(Node<T> item) {
        this.nextItems.add(item);
    }
    public void addNext(Node<T> node) {
        this.nextItems.add(node);
    }
    public void print(int number) {
        System.out.println("For node: " + number + ", value =" + this.item.toString() +" :");
        for(Node<T> n : this.nextItems)
            System.out.print(n.item.toString() + " ");
        System.out.println();
    }
}
