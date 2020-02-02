package dc;

import struktury.TopologicalSortItem;

import java.util.HashMap;
import java.util.Map;

public class TopoligicalSorting {
    private static Map<String, TopologicalSortItem> mapa;
    static int czas = 0;

    public static void main(String[] args) {
        mapa = readItems2();
        DFS();
        showTime();
    }
    private static void DFSVisit( TopologicalSortItem item) {
        item.setColor(1);
        for (String napis : item.getDepending())
        if (mapa.get(napis).getColor() == 0) DFSVisit(mapa.get(napis));
        System.out.println(item.getText() + ", czas = " + ++czas);
    }
    public static void DFS()
    {
        czas = 0;
        for (Map.Entry<String, TopologicalSortItem> entry : mapa.entrySet())
        {
            if (entry.getValue().getColor() == 0)
                DFSVisit(entry.getValue());
        }
    }
    private static void DFSVisitTime( TopologicalSortItem item) {
        if (item.getDepending().size() == 0) {
            item.setTime(0);
            return;
        }
        int max = 0;
        for (String napis : item.getDepending())
            if (mapa.get(napis).getTime() == -1) DFSVisitTime(mapa.get(napis));
        for(String napis : item.getDepending())
            if (mapa.get(napis).getTime() > max)
                max = mapa.get(napis).getTime();
            item.setTime(max + 1);
    }
    public static void DFSTime()
    {
        for (Map.Entry<String, TopologicalSortItem> entry : mapa.entrySet())
        {
            if (entry.getValue().getTime() == -1)
                DFSVisitTime(entry.getValue());
        }
    }
    public static Map<String, TopologicalSortItem> readItems1() {
        Map<String, TopologicalSortItem> mapa = new HashMap<String, TopologicalSortItem>();
        String[][] tablica = new String[][] {
            new String[] {"spodnie", "kalesony"},
            new String[] {"majtki"},
            new String[] {"skarpetki"},
            new String[] {"sweter", "koszula", "krawat"},
            new String[] {"koszula", "podkoszulek"},
            new String[] {"krawat", "koszula"},
            new String[] {"podkoszulek"},
            new String[] {"kurtka", "sweter", "szalik"},
            new String[] {"szalik", "sweter"},
            new String[] {"kalesony", "majtki"},
            new String[] {"czapka", "sweter"},
            new String[]{"spinka", "krawat"},
            new String[] {"rękawiczki", "kurtka", "czapka", "buty"},
            new String[] {"buty", "spodnie", "skarpetki"}
        };
        for(String[] linia : tablica){

            TopologicalSortItem item = new TopologicalSortItem(linia[0]);
            if (linia.length > 1) {
                for(int i = 1; i < linia.length; i++)
                    item.addDepending(linia[i]);
            }
            mapa.put(item.getText(), item);
        }
        return mapa;
    }
    public static Map<String, TopologicalSortItem> readItems2() {
        Map<String, TopologicalSortItem> mapa = new HashMap<String, TopologicalSortItem>();
        String[][] tablica = new String[][] {
                new String[] {"posadzka", "ściany", "rury z wodą", "izolacja pozioma"},
                new String[] {"wykop"},
                new String[] {"fundamenty", "wykop"},
                new String[] {"okna", "ściany", "tynki wewnętrzne"},
                new String[] {"drzwi", "tynki wewnętrzne", "podłoga"},
                new String[] {"ściany", "fundamenty", "izolacja pozioma"},
                new String[] {"podłoga", "posadzka"},
                new String[] {"zasypka", "fundamenty"},
                new String[] {"izolacja pozioma", "zasypka"},
                new String[] {"rury z wodą", "fundamenty", "zasypka"},
                new String[] {"przewody elektryczne", "ściany", "strop"},
                new String[] {"tynki wewnętrzne", "przewody elektryczne", "strop"},
                new String[] {"przełączniki światła", "tynki wewnętrzne"},
                new String[] {"grzejniki", "tynki wewnętrzne", "rury z wodą"},
                new String[] {"parapety", "tynki wewnętrzne", "okna"},
                new String[] {"sufit", "przewody elektryczne", "ściany"},
                new String[] {"strop", "ściany"},
                new String[] {"ogrodzenie"},
                new String[] {"ściany kolankowe", "strop"},
                new String[] {"schody wejściowe", "ściany"},
                new String[] {"belki dachowe", "ściany kolankowe"},
                new String[] {"kontrłaty", "belki dachowe"},
                new String[] {"dachówki", "membrana dachowa"},
                new String[] {"membrana dachowa", "kontrłaty"},
                new String[] {"malowanie ścian", "tynki wewnętrzne"},
                new String[] {"malowanie elewacji", "tynki zewnętrzne", "parapety zewnętrzne"},
                new String[] {"tynki zewnętrzne", "ocieplenie ścian"},
                new String[] {"parapety zewnętrzne", "tynki zewnętrzne"},
                new String[] {"ocieplenie ścian", "strop", "okna", "drzwi"},
                new String[] {"oświetlenie", "tynki wewnętrzne", "przełączniki światła"}
        };
        for(String[] linia : tablica){

            TopologicalSortItem item = new TopologicalSortItem(linia[0]);
            if (linia.length > 1) {
                for(int i = 1; i < linia.length; i++)
                    item.addDepending(linia[i]);
            }
            mapa.put(item.getText(), item);
        }
        return mapa;
    }
    public static void showTime() {
        DFSTime();
        System.out.println("=== TIME ===");
        for(Map.Entry<String, TopologicalSortItem> entry : mapa.entrySet())
            System.out.println(entry.getKey() + " , time = " + entry.getValue().getTime());
    }
}
