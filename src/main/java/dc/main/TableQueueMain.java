package dc.main;

import struktury.TableQueue;

public class TableQueueMain {
    public static void main(String[] args) {
        TableQueue<String> kolejka = new TableQueue<>(5);
        kolejka.pushBack("ala");
        kolejka.pushBack("ma");
        kolejka.pushBack("kota");
        kolejka.pushBack("i");
        kolejka.pushBack("psa");
        //kolejka.pushBack("i");
        kolejka.show();
        System.out.println("=== QUEUE ===");
        while(!kolejka.isEmpty()) {
            System.out.println(kolejka.popFront());
        }
    }
}
