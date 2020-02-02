package struktury;

public class Pair<T1,T2> {
    T1 elem1;
    T2 elem2;

    public T1 getElem1() {
        return elem1;
    }
    public T2 getElem2() {
        return elem2;
    }

    public Pair(T1 e1, T2 e2) {
        this.elem1 = e1;
        this.elem2 = e2;
    }

    public static void main(String[] args) {
        Pair<String, Integer> para1 = new Pair<>("alal", 12);
        Pair<Integer, Double> para2 = new Pair<>(12, 123.2);
    }
}
