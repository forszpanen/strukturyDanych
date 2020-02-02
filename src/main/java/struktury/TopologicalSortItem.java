package struktury;

import java.util.ArrayList;

public class TopologicalSortItem {
    private String text;
    private int color;
    private int time;
    private ArrayList<String> depending = new ArrayList<>();

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public ArrayList<String> getDepending() {
        return depending;
    }
    public void setDepending(ArrayList<String> depending) {
        this.depending = depending;
    }
    public void addDepending(String text) {
        depending.add(text);
    }
    public TopologicalSortItem(String text) {
        this.text = text;
        this.color = 0;
        this.time = -1;
        depending = new ArrayList<String>();
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }
}
