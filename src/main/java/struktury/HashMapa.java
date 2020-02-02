package struktury;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapa {
    public static void main(String[] args) {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Kowal", 1);
        mapa.put("Nowak", 1);
        mapa.put("Nowakowska", 1);
        String[] wyrazy = new String[]{"Alasz", "Nowicka", "Kowal", "Grzybowska", "Nowak"};
        for (String wyraz : wyrazy)
            if (mapa.containsKey(wyraz)) {
                int value = mapa.get(wyraz) + 1;
                mapa.put(wyraz, value);
            } else {
                mapa.put(wyraz, 1);
            }
        for (Map.Entry<String, Integer> entry : mapa.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        // słownik
        String napis = "abandon drilling well:zaniechać wiercenia otworu\n" +
                "abandon ship bill:rozkład alarmu łodziowego (żegl.)\n" +
                "abandon ship:opuścić statek (żegl.)\n" +
                "abaque:nomogram (mat.);nomograf (mat.)\n" +
                "abatacept:abatacept (farm.)\n" +
                "abate:upokorzyć;poniżyć;zmniejszyć się;osłabnąć;znieść do niższego poziomu;skurczyć się;zwęzić się;pokonać;zniszczyć;zrównać z ziemią;potrącić;odjąć z ceny;wykluczyć;wyłączyć;zabronić;zakazać;stępić (rzadko);pozbawić;odebrać;stracić szacunek;unieważnić;osłabić;zmniejszyć się;osłabnąć;doświadczać osłabienia siły lub zmniejszenia gęstości;zostać pokonanym lub poniżonym;załamać się;zawieść;redukcja;osłabienie;obniżenie;opat\n" +
                "abatement:zmiejszenie;osłabienie";
        String[] hasla = napis.split("\n");
        Map<String, ArrayList<String>> dict = new HashMap<>();
        for (String haslo : hasla) {
            String[] wyr = haslo.split(":");
            String klucz = wyr[0];
            String[] polskieZnaczenia = wyr[1].split(";");
            ArrayList<String> polskie = new ArrayList<>();
            for (String w : polskieZnaczenia)
                polskie.add(w);
            dict.put(klucz, polskie);
        }
        for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()) {
            System.out.print("Haslo: " + entry.getKey() + " polskie znaczenia: ");
            for (String slowo : entry.getValue())
                System.out.print(slowo + ", ");
            System.out.println();
        }
        Map<String, ArrayList<String>> dictPL = new HashMap<>();
        ArrayList<String> lista;
        for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()) {
            for (String slowo : entry.getValue()) {
                if (dictPL.containsKey(slowo)) {
                    lista = dictPL.get(slowo);
                } else {
                    lista = new ArrayList<>();
                }
                lista.add(entry.getKey());
                dictPL.put(slowo, lista);
            }
        }
        System.out.println("=== DIC PL-EN ==");
        for (Map.Entry<String, ArrayList<String>> entry : dictPL.entrySet()) {
            System.out.print("Haslo: " + entry.getKey() + " angielskie znaczenia: ");
            for (String slowo : entry.getValue())
                System.out.print(slowo + ", ");
            System.out.println();
        }
    }
}
