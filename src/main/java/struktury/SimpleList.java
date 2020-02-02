package struktury;

public class SimpleList<T> {
    private Item<T> head;
    private int size;

    public SimpleList() {
        head = null;
        size = 0;
    }
    public void push(T elem) {
        Item<T> item = new Item<T>(elem);
        this.push(item);
    }
    public void push(Item<T> item) {
        if (head == null) {
            size++;
            head = item;
            head.setNextItem(null);
        }
        else {
            Item<T> it = head;
            while(it.getNextItem() != null)
                it = it.getNextItem();
            it.setNextItem(item);
            item.setNextItem(null);
            size++;
        }
    }
    public Item<T> pop() {
        if (size == 2) {
            Item<T> item = head.getNextItem();
            head.setNextItem(null);
            size = 1;
            return item;
        }
        if (head == null)
            return null;
        Item<T> previous = head;
        Item<T> it = head;
        while(it.getNextItem() != null) {
            previous = it;
            it = it.getNextItem();
        }
        Item<T> item = it;
        previous.setNextItem(null);
        size--;
        return item;
    }
    public Item<T> peek() {
        if (size == 2) {
            Item<T> item = head.getNextItem();
            return item;
        }
        if (head == null)
            return null;
        Item<T> previous = head;
        Item<T> it = head;
        while(it.getNextItem() != null) {
            it = it.getNextItem();
        }
        return it;
    }
    public void showAll() {
        System.out.println("=== LIST ===");
        Item<T> item = head;
        int nr = 0;
        while(item != null) {
            System.out.println(++nr + " " + item.getItem());
            item = item.getNextItem();
        }
    }
}
