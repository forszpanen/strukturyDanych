package struktury;

/**
 * Implementacja kolejki w wersji listowej
 * @author Dariusz Ceglarek
 * @version 1.01
 * @param <T> typ generyczny
 */
public class Queue<T> {
    public static void main(String[]args){

        Queue<String> kol = new Queue<>();
        kol.addItem(new Item<String>("aaaa"));
        kol.addItem("aaa");
    }
    private Item<T> head;
    private Item<T> tail;
    private int size;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public void addItem(Item<T> item) {
        size++;
        if (head == null) {
            head = item;
            tail = head;
        } else {
            tail.setNextItem(item);
            tail = item;
        }
    }

    public void addItem(T element) {
        size++;
        if (head == null) {
            Item<T> item = new Item<T>(element);
            head = item;
            tail = head;
        } else {
            Item<T> item = new Item<T>(element);
            tail.setNextItem(item);
            tail = item;
        }
    }
    public void showItems() {
        System.out.println("=== QUEUE ===");
        Item<T> it = head;
        while (it != null) {
            System.out.println(it.getItem());
            it = it.getNextItem();
        }
    }
    public Item<T> pop() {
        if (size == 0)
            return null;
        Item<T> item = head;
        head = head.getNextItem();
        size--;
        return item;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
