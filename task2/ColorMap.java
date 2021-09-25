package W02.task2;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    private static final Map<String, Integer> colorMap;

    static {
        // 产生一行颜色，按照颜色渐变来进行排序
        colorMap = new HashMap<>();
        // f00->f0f->00f->0ff->0f0
        int r = 255;
        int g = 0;
        int b = 0;
        for (int i = 0; i < 64; i++) {
            String color = r + ";" + g + ";" + b;
            colorMap.put(color, i + 1);
            if (i < 16) {
                b += (b == 240 ? 15 : 16);
            } else if (i >= 16 && i < 32) {
                r -= (r == 15 ? 15 : 16);
            } else if (i >= 32 && i < 48) {
                g += (g == 240 ? 15 : 16);
            } else {
                b -= (b == 15 ? 15 : 16);
            }
        }
    }

    private ColorMap() {
    }

    // 获得所有颜色
    public static String[] getColors() {
        String[] colors = new String[colorMap.size()];
        int index = 0;
        for (String color : colorMap.keySet()) {
            colors[index++] = color;
        }
        return colors;
    }

    // 获得颜色color所对应的rank
    public static int getRank(String color) {
        return colorMap.get(color);
    }
}
