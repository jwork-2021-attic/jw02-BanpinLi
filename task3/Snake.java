package W02.task3;

import W02.task3.Ground.Position;

public class Snake {
    Sorter sorter;
    StringBuilder sortLog;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sortGround(Ground ground) {
        Position[] positions = ground.getPositions();

        int[][] ranks = new int[ground.m][ground.n];
        for (int i = 0; i < ground.m; i++) {
            for (int j = 0; j < ground.n; j++) {
                ranks[i][j] = positions[i * ground.m + j].item.getRank();
            }
        }

        sorter.loadData(ranks);
        sorter.sort();

        String[] process = sorter.getProcess();

        sortLog = new StringBuilder();
        for (String step : process) {
            String[] s = step.split("<->");
            swapPosition(positions[Integer.parseInt(s[0])], positions[Integer.parseInt(s[1])]);
            sortLog.append(ground.toString()).append("\n[frame]\n");
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
