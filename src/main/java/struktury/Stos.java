package struktury;

public class Stos {
    public static void main(String[] args) {
        Stos stosik = new Stos(100);
        stosik.push("ala");
        stosik.push("ma");
        stosik.push("kota");
        String napis = stosik.pop();
        System.out.println("Ze stosu: " + napis);
        while(!stosik.isEmpty())
            System.out.println("zdjęto:  " + stosik.pop());
    }
    private String[] tablica;
    private int size;

    public Stos(int maxSize) {
        tablica = new String[maxSize];
        size = 0;
    }
    public boolean isFull() {
        return size == tablica.length;
    }
    public boolean isEmpty() {
        if (size > 0)
            return false;
        else
            return true;
    }
    public void push(String text) throws IndexOutOfBoundsException {
        if (isFull())
            throw new IndexOutOfBoundsException("stack is full, operation failed!");
        tablica[size] = text;
        size++;
    }

    /**
     *  Zdejmowanie
     * @return
     * @throws IndexOutOfBoundsException
     */
    public String pop() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException("stack is empty, operation failed!");
        String text = tablica[size - 1];
        size--;
        return text;
    }

    /**
     * Metoda zwraca element ze szczytu stosu bez zdejmowania go ze stosu
     * @return
     * @throws IndexOutOfBoundsException
     */
    public String peek() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException("stack is empty, operation failed!");
        return tablica[size];
    }
}







