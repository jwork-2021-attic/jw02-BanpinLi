package W02.task3;

import W02.task3.Matrix.Position;

public class Snake {
    Sorter sorter;
    StringBuilder sortLog;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sortMatrix(Matrix matrix) {
        Position[][] positions = matrix.getPositions();
        int m = positions.length;
        int n = positions[0].length;

        int[][] ranks = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ranks[i][j] = positions[i][j].item.getRank();
            }
        }

        sorter.loadData(ranks);
        sorter.sort();

        String[] process = sorter.getProcess();

        sortLog = new StringBuilder();
        for (String step : process) {
            String[] index = step.split(",");
            int row1 = Integer.parseInt(index[0]);
            int col1 = Integer.parseInt(index[1]);
            int row2 = Integer.parseInt(index[2]);
            int col2 = Integer.parseInt(index[3]);
            swapPosition(positions[row1][col1], positions[row2][col2]);
            sortLog.append(matrix.toString()).append("\n[frame]\n");
        }
    }

    public String getSortLog() {
        return sortLog.toString();
    }

    private void swapPosition(Position p1, Position p2) {
        Item item = p1.item;
        p1.item = p2.item;
        p2.item = item;
    }
}
