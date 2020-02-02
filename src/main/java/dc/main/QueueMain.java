package dc.main;

import struktury.Item;
import struktury.Queue;


public class QueueMain {
    public static void main(String[] args) {
        Item<String> napis1 = new Item<>("ala");
        Item<String> napis2 = new Item<>("ma");
        Item<String> napis3 = new Item<>("kota");
        Item<String> napis4 = new Item<>("i");
        Item<String> napis5 = new Item<>("psa");
        Queue<String> kolejka = new Queue<>();
        kolejka.addItem(napis1);
        kolejka.addItem(napis2);
        kolejka.addItem(napis3);
        Item<String> item = kolejka.pop();
        System.out.println(item.getItem());
        item = kolejka.pop();
        System.out.println(item.getItem());
        kolejka.addItem(napis4);
        kolejka.addItem(napis5);
        kolejka.showItems();


    }
}
