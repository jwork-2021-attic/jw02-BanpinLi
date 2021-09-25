package W02.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {
    public static void main(String[] args) throws IOException {
        String[] colors = ColorMap.getColors();
        shuffle(colors);
        Ground ground = new Ground(8, 8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Item item = new LittleDevil();
                item.color = colors[i * 8 + j];
                ground.put(item, i, j);
            }
        }

        Snake snake = new Snake();

        Sorter sorter = new SelectSort();
        // Sorter sorter = new QuickSort();

        snake.setSorter(sorter);
        snake.sortGround(ground);

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
