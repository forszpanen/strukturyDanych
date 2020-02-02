package dc.main;

import struktury.TableStack;

import java.util.HashSet;

public class TableStackMain {
    public static void main(String[] args) {
        TableStack<String> stos = new TableStack<>(20);
        stos.push("ala");
        stos.push("ma");
        stos.push("kota");
        while(!stos.isEmpty())
            System.out.println(stos.pop());
    }
}
