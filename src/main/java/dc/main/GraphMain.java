package dc.main;

import struktury.Graph;
import struktury.Node;

public class GraphMain {
    public static void main(String[] args) {
        Graph<Integer> graf = new Graph<Integer>();
        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(7);
        Node<Integer> node4 = new Node<>(2);
        Node<Integer> node5 = new Node<>(8);
        Node<Integer> node6 = new Node<>(2);
        Node<Integer> node7 = new Node<>(3);
        node1.addNext(node2);
        node1.addNext(node3);
        node2.addNext(node4);
        node3.addNext(node5);
        node4.addNext(node6);
        node3.addNext(node6);
        node3.addNext(node7);
        graf.addNode(node1);
        graf.addNode(node2);
        graf.addNode(node3);
        graf.addNode(node4);
        graf.addNode(node5);
        // czy jest trasa z node1 do node6, a jeśli tak, to jaka? ile jest tras?
        int number = 1;
        /*
         do grafu zostały dodane wierzchołki od 1 do 5,
         ale one są połączone z kolejnymi wierzchołkami
        */
        for(Node<Integer> node : graf.getNodes())
            node.print(number++);
    }
}
