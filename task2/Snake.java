package W02.task2;

import W02.task2.Line.Position;

public class Snake {
    Sorter sorter;
    StringBuilder sortLog;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sortLine(Line line) {
        Position[] positions = line.getPositions();

        int[] ranks = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            ranks[i] = positions[i].item.getRank();
        }

        sorter.loadData(ranks);
        sorter.sort();

        String[] process = sorter.getProcess();

        sortLog = new StringBuilder();
        for (String step : process) {
            String[] s = step.split(",");
            swapPosition(positions[Integer.parseInt(s[0])], positions[Integer.parseInt(s[1])]);
            sortLog.append(line.toString()).append("\n[frame]\n");
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
