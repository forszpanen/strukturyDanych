package dc.main;

import struktury.LinkedList;
import struktury.LinkedListItem;

public class LinkedListMain {
     public static void main(String[] args) {
         LinkedList<String> lista = new LinkedList<>();
         lista.pushBack("Metallica");
         lista.pushBack("Led Zeppelin");
         lista.pushFront("The Doors");
         lista.pushFront("Joe Satriani");
         lista.pushBack("Deep Purple");
         lista.pushFront("Black Sabbath");
         lista.pushFront("Steve Vai");
         lista.pushBack("Nirvana");
         int size = lista.size();
         lista.show();
         LinkedListItem<String> item = lista.popFront();
         System.out.println("Pop from front of list: " + item.getElement());
         lista.show();
         item = lista.popBack();
         System.out.println("Pop from back of list: " + item.getElement());
         lista.show();
         lista.showInReverseOrder();

        }
}