package struktury;

public class StringItem {
        private String item;
        private StringItem nextItem;
        public String getItem() {
            return item;
        }
        public void setItem(String item) {
            this.item = item;
        }

        public StringItem getNextItem() {
            return nextItem;
        }
        public void setNextItem(StringItem nextItem) {
            this.nextItem = nextItem;
        }

        public StringItem(String item) {
            this.item = item;
            this.nextItem = null;
        }
        @Override
        public String toString() {
            return item;
        }
}

