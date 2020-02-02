package struktury;

public class LinkedListItem<T> {
    private T element;
    private LinkedListItem<T> next;
    private LinkedListItem<T> prev;

    public LinkedListItem() {
         next = null;
         prev = null;
    }
    public LinkedListItem(T elem, LinkedListItem<T> next, LinkedListItem prev) {
         this.element = elem;
         this.next = next;
         this.prev = prev;
    }
    public T getElement() {
         return element;
    }
    public LinkedListItem<T> getNext() {
         return next;
    }
    public void setNext(LinkedListItem<T> next) {
            this.next = next;
        }

        public LinkedListItem<T> getPrev() {
            return prev;
        }
        public void setPrev(LinkedListItem<T> poprzedni) {
            this.prev = poprzedni;
        }
}
