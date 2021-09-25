package W02.task2;

public class Ground {
    private Position[] positions;

    public Ground(int length) {
        positions = new Position[length];
    }

    public void put(Item item, int index) {
        this.positions[index] = new Position(item);
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
        for (Item item : items) {
            sb.append(item.toString());
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
