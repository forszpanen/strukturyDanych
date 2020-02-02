package dc.main;

import struktury.Item;
import struktury.List;

public class ListMain {
    public static void main(String[] args) {
        List<String> listaNapisów = new List<>();
        Item<String> item1 = new Item<>("ala");
        Item<String> item2 = new Item<>("ma");
        Item<String> item3 = new Item<>("kota");
        listaNapisów.pushBack(item1);
        listaNapisów.pushBack(item2);
        listaNapisów.pushBack(item3);
        listaNapisów.showList();
        Item<String> item4 = new Item<String>("i");
        Item<String> item5 = new Item<String>("psa");
        listaNapisów.deleteItem(2);
        listaNapisów.pushBack(item5);
        listaNapisów.pushBack(item4);
        listaNapisów.pushBack(item3);
        listaNapisów.showList();

        // wstawienie elementu za 1
        Item<String> item6 = new Item<>("ula");
        Item<String> it = item1.getNextItem();
        item1.setNextItem(item6);
        item6.setNextItem(it);

        Item<String> szukany = listaNapisów.find("ma");
        if (szukany != null) {
            System.out.println("Found: " + szukany);
            System.out.println("Next: " + szukany.getNextItem());
        }

        System.out.println("end of lista2");
        listaNapisów.showList();
        listaNapisów.pushFront("adam");
        Item<String> elem = listaNapisów.popBack();
        System.out.println("Pop from back of list: " + elem.getItem());
        listaNapisów.showList();
        elem = listaNapisów.popFront();
        System.out.println("Pop from front of list: " + elem.getItem());
        listaNapisów.showList();
    }
}
