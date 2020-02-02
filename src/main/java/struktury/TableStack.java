package struktury;

/**
 * Realizacja tablicowa stosu (o okreslonym maksymalnym rozmiarze)
 * @author Dariusz Ceglarek
 * @param <T>
 */
public class TableStack<T> {
    T[] table;
    int size;

    /**
     * Konstruktor
     * @param MaxSize przewidywany maksymalny rozmiar stosu
     */
    public TableStack(int MaxSize) {
        table = (T[])new Object[MaxSize];
        size = 0;
    }

    /**
     * Pobranie maksymalnego rozmiaru stosu
     * @return
     */
    public int getMaximumStackSize() {
        return table.length;
    }

    /**
     * Sprawdzenie czy stos jest pusty
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else
            return false;
    }

    /**
     * Pobranie aktualnego rozmiaru stosu
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Wstawienie elementu na szczyt stosu
     * @param element
     * @throws ArrayIndexOutOfBoundsException
     */
    public void push(T element) throws ArrayIndexOutOfBoundsException {
        if (size < table.length) {
            table[size] = element;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException(
                    "Stack is full, operation failed");
        }
    }

    /**
     * Pobranie elementu ze stosu
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T pop() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException(
                    "Stack is empty, operation failed");
        }
        T temp = table[size - 1];
        size--;
        return temp;
    }

    /**
     * Wyswietlenie elementu na szczycie stosu (bez pobierania go)
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T peek() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException(
                    "Stack is empty, operation failed");
        }
        return table[size - 1];
    }
    /**
     * Wyswietlenie zawartosci stosu
     * @throws IndexOutOfBoundsException wyjatek, ktory jest zglaszany gdy stos jest pusty
     */
    public void show() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException(
                    "Stack is empty, operation failed");
        }
        int temp = size - 1;
        do {
            System.out.println(table[temp]);
            temp--;
        } while (temp > -1);

    }

    /**
     * Oproznienie stosu
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
        size = 0;
    }

    /**
     * Odwrocenie kolejnosci w stosie
     */
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = table[i];
            table[i] = table[size - 1 - i];
            table[size - 1 - i] = temp;

        }
    }
}
