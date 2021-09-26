package W02.task3;

public class Matrix {
    private Position[][] positions;

    public Matrix(int m, int n) {
        positions = new Position[m][n];
    }

    public void put(Item item, int row, int col) {
        this.positions[row][col] = new Position(item);
    }

    class Position {
        public Item item;

        public Position(Item item) {
            this.item = item;
        }
    }

    public Position[][] getPositions() {
        return this.positions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Item[][] items = getItems();
        for (Item[] item : items) {
            for (Item i : item) {
                sb.append(i.toString());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Item[][] getItems() {
        Item[][] items = new Item[positions.length][positions[0].length];
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[0].length; j++) {
                items[i][j] = positions[i][j].item;
            }
        }
        return items;
    }
}
