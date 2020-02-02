package struktury;

/**
 * Implementacja listy z uchwytem dla glowy i ogona
 * @param <T> TYP GENERYCZNY (DOWOLNY)
 */
public class List<T> {
    private Item<T> head;
    private Item<T> tail;
    private int size;

    public List() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Wstawienie elementu na koncu listy
     * @param item wstawiany element generyczny
     */
    public void pushBack(Item<T> item) {
        size++;
        if (head == null) {
            head = item;
            tail = head;
        } else {
            tail.setNextItem(item);
            tail = item;
            tail.setNextItem(null);
        }
    }
    public void pushFront(Item<T> item) {
        size++;
        if (head == null) {
            head = item;
            tail = head;
        }
        else {
            head.setNextItem(item);
            head = item;
        }
    }

    /**
     * Wstawienie na koncu elementu, ktory moze miec caly lancuch wertosci
     * @param item
     */
    public void pushBackElement(Item<T> item) {
        if (item.getNextItem() != null) {
            tail.setNextItem(item);
            while(item != null) {
                tail = item;
                item = item.getNextItem();
            }
        }
    }
    public void pushFront(T elem) {
        size++;
        if (head == null) {
            head = new Item(elem);
            tail = head;
        }
        else {
            Item<T> item = new Item(elem);
            item.setNextItem(head);
            head = item;
        }
    }
    public Item<T> popFront() {
        if (head == null)
            return null;
        Item<T> item = head;
        head = head.getNextItem();
        size--;
        return item;
    }
    public Item<T> popBack(){
        if (head == null)
            return null;
        Item<T> item = head;
        while(item.getNextItem() != tail)
            item = item.getNextItem();
        Item<T> it = item.getNextItem();
        tail = item;
        tail.setNextItem(null);
        return it;
    }
    public void showList() {
        System.out.println("=== LIST ===");
        Item<T> it = head;
        while (it != null) {
            System.out.println(it.getItem());
            it = it.getNextItem();
        }
    }
    public boolean deleteItem(int number) {
        int nr = 0;
        Item<T> it = head;
        if (size == 0 || number < 0)
            return false;
        if (number == 0) {
            head = head.getNextItem();
            size--;
            if (size == 0)
                tail = null;
            return true;
        } else {
            while (it != null) {
                nr++;
                Item<T> prev = it;
                it = it.getNextItem();
                if (nr == number) {
                    if (nr < size-1) {
                        prev.setNextItem(it.getNextItem());
                        size--;
                    }
                    else {
                        size--;
                        it = null;
                        tail = prev;
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public Item<T> getItem(int number) {
        if (number < 0 || number >= size)
            return null;
        if (number == 0)
            return head;
        else {
            Item<T> it = head;
            int nr = 0;
            while(it != null) {
                nr++;
                it = it.getNextItem();
                if (nr == number)
                    return it;
            }
        }
        // jesteśmy za listą, ale nigdy tu nie zajdziemy
        return null;
    }

    /**
     * Zwrocenie elementu o okreslonej wartosci
     * @param value szukana wartosc
     * @return element o szukanej wartosci lub null jesli go nie ma na liscie
     */
    public Item<T> find(T value) {
      if (head == null)
          return null;
      Item<T> item = head;
      do {
          if (item.getItem().equals(value))
              return item;
          item = item.getNextItem();
      } while(item != null);
      return null;
    }
    public void insertItem(Item<T> item, int number) {
        //TODO: zaimplementować wstawianie elementu za elementem o numerze 'number'
    }
}
