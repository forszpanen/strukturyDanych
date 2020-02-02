package struktury;

import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<Node<T>> nodes;
    public Graph() {
        nodes = new ArrayList<Node<T>>();
    }
    public void addNode(Node<T> node) {
        nodes.add(node);
    }
    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }
}
