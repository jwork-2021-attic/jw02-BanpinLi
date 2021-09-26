package W02.task3;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    private static final Map<String, Integer> colorMap;

    static {
        // 方阵的配色
        colorMap = new HashMap<>();
        int r = 255;// += 42
        int g = 0;// += 31
        int b = 0;// += 31
        for (int i = 0; i < 3; i++) {
            g = b = 0;
            for (int j = 0; j < 8; j++) {
                g += 30;
                b += 30;
                colorMap.put(r + ";" + g + ";" + 0, (i * 3) * 8 + j + 1);
                colorMap.put(r + ";" + 0 + ";" + b, (i * 3 + 1) * 8 + j + 1);
                if (i != 2) {
                    colorMap.put(r + ";" + g + ";" + b, (i * 3 + 2) * 8 + j + 1);
                }
            }
            r -= 80;
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