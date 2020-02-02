package dc.main;

import struktury.Item;
import struktury.SimpleList;

public class SimpleListMain {
    public static void main(String[] args) {
        SimpleList<String> lista = new SimpleList<>();
        Item<String> item1 = new Item<String>("ala");
        Item<String> item2 = new Item<String>("ma");
        Item<String> item3 = new Item<String>("kota");
        lista.push(item1);
        lista.push(item2);
        lista.push(item3);
        lista.showAll();
        lista.pop();
        lista.push("psa");
        lista.showAll();
    }
}
