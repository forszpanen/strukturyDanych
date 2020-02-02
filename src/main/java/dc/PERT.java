package dc;

import struktury.PERTItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PERT {
    private static Map<String, PERTItem> mapa;
    static int czas = 0;

    public static void main(String[] args) {
        mapa = readItems();
        DFS();
        showTime();
    }
    private static void DFSVisit(PERTItem item) {
        item.setColor(1);
        for (String napis : item.getDepending())
            if (mapa.get(napis).getColor() == 0) DFSVisit(mapa.get(napis));
        System.out.println(item.getText() + ", position : " + ++czas);
    }
    public static void DFS()
    {
        czas = 0;
        for (Map.Entry<String, PERTItem> entry : mapa.entrySet())
        {
            if (entry.getValue().getColor() == 0)
                DFSVisit(entry.getValue());
        }
    }
    private static void DFSVisitTime( PERTItem item) {
        if (item.getDepending().size() == 0) {
            item.setTime(0);
            return;
        }
        int max = 0;
        for (String napis : item.getDepending())
            if (mapa.get(napis).getTime() == -1) DFSVisitTime(mapa.get(napis));
        for(String napis : item.getDepending())
            if (mapa.get(napis).getTime() > max)
                max = mapa.get(napis).getTime() + mapa.get(napis).getTimeOfRealize();
        item.setTime(max + 1);
    }
    public static void DFSTime()
    {
        for (Map.Entry<String, PERTItem> entry : mapa.entrySet())
        {
            if (entry.getValue().getTime() == -1)
                DFSVisitTime(entry.getValue());
        }
    }
    public static Map<String, PERTItem> readItems() {
        Map<String, PERTItem> mapa = new HashMap<String, PERTItem>();
        String[][] tablica = new String[][] {
                new String[] {"posadzka", "5", "ściany", "rury z wodą", "izolacja pozioma"},
                new String[] {"wykop", "2"},
                new String[] {"fundamenty", "5", "wykop"},
                new String[] {"okna", "1", "ściany", "tynki wewnętrzne"},
                new String[] {"drzwi", "1", "tynki wewnętrzne", "podłoga"},
                new String[] {"ściany", "4", "fundamenty", "izolacja pozioma"},
                new String[] {"podłoga", "1", "posadzka"},
                new String[] {"zasypka", "1", "fundamenty"},
                new String[] {"izolacja pozioma", "1", "zasypka"},
                new String[] {"rury z wodą", "2", "fundamenty", "zasypka"},
                new String[] {"przewody elektryczne", "2", "ściany", "strop"},
                new String[] {"tynki wewnętrzne", "3", "przewody elektryczne", "strop"},
                new String[] {"przełączniki światła", "1", "tynki wewnętrzne"},
                new String[] {"grzejniki", "2", "tynki wewnętrzne", "rury z wodą"},
                new String[] {"parapety", "1", "tynki wewnętrzne", "okna"},
                new String[] {"sufit", "2", "przewody elektryczne", "ściany"},
                new String[] {"strop", "7", "ściany"},
                new String[] {"ogrodzenie", "3"},
                new String[] {"ściany kolankowe", "2", "strop"},
                new String[] {"schody wejściowe", "2", "ściany"},
                new String[] {"belki dachowe", "2", "ściany kolankowe"},
                new String[] {"kontrłaty", "2", "belki dachowe"},
                new String[] {"dachówki", "3", "membrana dachowa"},
                new String[] {"membrana dachowa", "1", "kontrłaty"},
                new String[] {"malowanie ścian", "2", "tynki wewnętrzne"},
                new String[] {"malowanie elewacji", "2", "tynki zewnętrzne", "parapety zewnętrzne"},
                new String[] {"tynki zewnętrzne", "2", "ocieplenie ścian"},
                new String[] {"parapety zewnętrzne", "1", "tynki zewnętrzne"},
                new String[] {"ocieplenie ścian", "2", "strop", "okna", "drzwi"},
                new String[] {"oświetlenie", "1", "tynki wewnętrzne", "przełączniki światła"}
        };
        for(String[] linia : tablica){

            PERTItem item = new PERTItem(linia[0], Integer.parseInt(linia[1]));
            if (linia.length > 2) {
                for(int i = 2; i < linia.length; i++)
                    item.addDepending(linia[i]);
            }
            mapa.put(item.getText(), item);
        }
        return mapa;
    }
    public static void showTime() {
        DFSTime();
        System.out.println("=== TIME OF REALIZE ===");
        List<Map.Entry<String, PERTItem>> entries =
                mapa.entrySet()
                .stream()
                .sorted((p1,p2) -> (int)(p1.getValue().getTime() - p2.getValue().getTime()))
                .collect(Collectors.toList());

        for(Map.Entry<String, PERTItem> entry : entries)
            System.out.println(entry.getKey() + " , time = " + entry.getValue().getTime());
    }
}
