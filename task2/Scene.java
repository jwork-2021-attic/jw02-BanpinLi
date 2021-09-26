package W02.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {
    public static void main(String[] args) throws IOException {
        String[] colors = ColorMap.getColors();
        shuffle(colors);
        Line line = new Line(64);
        for (int i = 0; i < 64; i++) {
            Item item = new LittleDevil();
            item.color = colors[i];
            line.put(item, i);
        }

        Snake snake = new Snake();

        Sorter sorter;
        // 通过创建不同的对象来实现不同的排序方法
        sorter = new SelectSort();
        // sorter = new QuickSort();

        snake.setSorter(sorter);
        snake.sortLine(line);

        String sortLog = snake.getSortLog();

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(sortLog);
        writer.flush();
        writer.close();
    }

    private static void shuffle(String[] strs) {
        int len = strs.length;
        for (int i = len - 1; i > 0; i--) {
            int index = new Random().nextInt(i);
            String temp = strs[i];
            strs[i] = strs[index];
            strs[index] = temp;
        }
    }
}
