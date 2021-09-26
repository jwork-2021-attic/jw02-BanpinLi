package W02.task3;

public class Ground {
    private Position[] positions;
    public int m;
    public int n;

    public Ground(int m, int n) {
        this.m = m;
        this.n = n;
        positions = new Position[m * n];
    }

    public void put(Item item, int row, int col) {
        this.positions[row * m + col] = new Position(item);
    }

    class Position {
        public Item item;

        public Position(Item item) {
            this.item = item;
        }
    }

    public Position[] getPositions() {
        return this.positions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Item[] items = getItems();
        int count = 0;
        for (Item item : items) {
            sb.append(item.toString());
            count++;
            if (count == m) {
                sb.append('\n');
                count = 0;
            }
        }
        return sb.toString();
    }

    public Item[] getItems() {
        Item[] items = new Item[positions.length];
        for (int i = 0; i < positions.length; i++) {
            items[i] = positions[i].item;
        }
        return items;
    }
}
