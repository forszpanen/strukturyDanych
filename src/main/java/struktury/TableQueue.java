package struktury;

import java.lang.reflect.Type;

/**
 * Tablicowa realizacja kolejki (o okreslonym maksymalnym rozmiarze)
 * @param <T> typ generyczny
 */
public class TableQueue<T> {
    private T[] table;
    private int front;
    private int rear;
    private int size;

    /**
     * Konstruktor kolejki typu T
     * @param maxSize maksymalny rozmiar kolejki
     */
    public TableQueue(int maxSize) {
        table = (T[]) new Object[maxSize];
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * Wstawienie elementu T na koniec kolejki
     * @param element
     */
    public void pushBack(T element) throws ArrayIndexOutOfBoundsException {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException(
                    "Queue is full, operation failed");
        table[rear % table.length] = element;
        rear++;
        size++;
    }

    /**
     * Zdjecie z poczatku kolejki elementu T
     * @return
     */
    public T popFront() throws ArrayIndexOutOfBoundsException {
        if (this.isEmpty())
            throw new ArrayIndexOutOfBoundsException(
                    "Queue is empty, operation failed");
        T temp  = table[ front % table.length];
        front++;
        size--;
        return temp;
    }

    /**
     * Sprawdzenie czy kolejka jest pusta
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Sprawdzenie czy kolejka jest pelna
     * @return
     */
    public boolean isFull() {
        return (size == table.length);
    }

    /**
     * Pobranie elementu z poczatku kolejki bez usuwania z kolejki (podejrzenie co jest na poczatku)
     * @return prawda gdy rozmiar kolejki jest rowny maksymalnemu rozmiarowi kolejki lub falsz jesli nie jest
     */
    public T peek() {
        return table[front % table.length];
    }

    /**
     * Pobranie rozmiaru kolejki
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Wyswietlenie zawartosci kolejki
     */
    public void show(){

        System.out.println("=== QUEUE type: " + this.getType() + "===");
        for (int i = front % table.length; i < front % table.length + size; i++)
          System.out.println(table[ i % table.length] + " ");
    }

    /**
     * Metoda zwraca typ elementu T (typ elementów w kolejce)
     * @return
     */
    public String getType() {
        String napis = this.table[front % table.length].getClass().getName();
        int nr = napis.lastIndexOf(".");
        return napis.substring(nr+1);
    }
}
