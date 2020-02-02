package dc.main;

import struktury.Item;
import struktury.Queue;
import struktury.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> stosNapisów = new Stack<String>();
        Item<String> napis1 = new Item<String>("ala");
        Item<String> napis2 = new Item<String>("ma");
        Item<String> napis3 = new Item<String>("kota");
        stosNapisów.push(napis1);
        stosNapisów.push(napis2);
        stosNapisów.push(napis3);
        Item<String> elem1 = stosNapisów.pop();
        System.out.println(elem1);
        Item<String> elem2 = stosNapisów.pop();
        System.out.println(elem2);
        Item<String> napis4 = new Item<String>("i");
        Item<String> napis5 = new Item<String>("psa");
        stosNapisów.push(napis3);
        stosNapisów.push(napis4);
        stosNapisów.push(napis5);
        System.out.println("=== STACK === ");
        // przyklad ze przeslanie stosu do kolejki i z kolejki do stosu odwraca stos
        // ladujemy stos do kolejki
        Queue<String> kolejka = new Queue<>();
        while(stosNapisów.getSize() > 0) {
            Item<String> item = stosNapisów.pop();
            kolejka.addItem(item);
            System.out.println(item.getItem());
        }
        // ladujemy kolejke do stosu
        while(!kolejka.isEmpty())
            stosNapisów.push(kolejka.pop());
        System.out.println("=== STACK === ");
        while(stosNapisów.getSize() > 0) {
            Item<String> item = stosNapisów.pop();
            System.out.println(item.getItem());
        }
    }
}
