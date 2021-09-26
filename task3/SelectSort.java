package W02.task3;

import java.util.ArrayList;

public class SelectSort implements Sorter {
    private int[] nums;
    private int m;
    private int n;
    private ArrayList<String> process;

    @Override
    public void loadData(int[][] items) {
        // 二位数组展开成一维进行排序
        this.m = items.length;
        this.n = items[0].length;
        nums = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.nums[i * m + j] = items[i][j];
            }
        }
    }

    @Override
    public void sort() {
        process = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int curMin = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < curMin) {
                    curMin = nums[j];
                    index = j;
                }
            }
            if (i != index) {
                swap(i, index);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // 将一维变换映射到二维变换
        process.add(i / n + "," + i % n + "," + j / n + "," + j % n);
    }

    @Override
    public String[] getProcess() {
        String[] ret = new String[process.size()];
        for (int i = 0; i < process.size(); i++) {
            ret[i] = process.get(i);
        }
        return ret;
    }
}
