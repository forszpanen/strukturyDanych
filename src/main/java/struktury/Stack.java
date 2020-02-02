package struktury;
public class Stack<T> {
    private Item<T> head;

    public int getSize() {
        return size;
    }
    private int size;
    public Stack() {
        head = null;
        size = 0;
    }
    public void push(Item<T> item) {
        item.setNextItem(head);
        head = item;
        size++;
    }
    public Item<T> pop() {
        if (size == 0)
           return null;
        Item<T> item = head;
        head = head.getNextItem();
        size--;
        return item;
    }
    public Item<T> peek() {
        return head;
    }
}
