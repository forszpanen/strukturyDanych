package struktury;

public class LinkedList<T> {
    private LinkedListItem<T> head;
    private LinkedListItem<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void pushBack(T element) {
        LinkedListItem<T> item = new LinkedListItem<T>(element, null, null);
        if (isEmpty()) {
            head = item;
            tail = item;
        } else {
            tail.setNext(item);
            item.setNext(null);
            item.setPrev(tail);
            tail = item;
        }
    }
    public void pushFront(T element) {
        LinkedListItem<T> item = new LinkedListItem<T>(element, null, null);
        if (head == null) {
            head = item;
            tail = item;
        } else {
            head.setPrev(item);
            item.setNext(head);
            head = item;
        }
    }
    public LinkedListItem<T> popFront() {
        if (head == null)
            return null;
        if (head == tail) {
            LinkedListItem<T> item = head;
            head = null;
            tail = null;
            return item;
        }
        LinkedListItem<T> item = head;
        head = head.getNext();
        head.setPrev(null);
        return item;
    }
    public LinkedListItem<T> popBack() {
        if (head == null)
            return null;
        if (head == tail) {
            LinkedListItem<T> item = head;
            head = null;
            tail = null;
            return item;
        }
        LinkedListItem<T> item = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        return item;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void show() {
        LinkedListItem<T> item = head;
        System.out.println("== LIST ===");
        while (item != null) {
            System.out.println(item.getElement());
            item = item.getNext();
        }
    }

    public void showInReverseOrder() {
        LinkedListItem<T> item = tail;
        System.out.println("=== LIST IN REVERSE ORDER ===");
        while (item != null) {
            System.out.println(item.getElement());
            item = item.getPrev();
        }
    }
    public int size() {
        LinkedListItem<T> item = head;
        int i = 0;
        while (item != null) {
            i++;
            item = item.getNext();
        }
        return i;
    }
}
