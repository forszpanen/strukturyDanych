package struktury;

/**
 * Element skladowy dynamicznej listy, kolejki lub stosu
 * @param <T> typ generyczny (dowolny)
 */
public class Item<T> {
    /**
     * Element zapamietujacy dane
     */
    private T item;
    private Item<T> nextItem;
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public Item<T> getNextItem() {
        return nextItem;
    }
    public void setNextItem(Item<T> nextItem) {
        this.nextItem = nextItem;
    }

    public Item(T item) {
        this.item = item;
        this.nextItem = null;
    }
    @Override
    public String toString() {
        return item.toString();
    }

    public static void main(String[] args) {
            Item<String> item1 = new Item<>("Dwa");
            Item<String> item2 = new Item<>("Trzy");
            Item<String> item3 = new Item<>("Cztery");
            Item<String> item4 = new Item<>("Pięć");
            Item<String> item5 = new Item<>("Sześć");
            item1.setNextItem(item4);
            item3.setNextItem(item5);
            item4.setNextItem(item3);
            Item<String> i = item1;
            while (i != null) {
                System.out.println(i.getItem());
                if (i.getItem().compareTo("Cztery") == 0) {
                    Item<String> rob = i.getNextItem();
                    i.setNextItem(item2);
                    item2.setNextItem(rob);
                }
                i = i.getNextItem();
                // write your code here
            }
        }
    }



