package W02.task3;

import java.util.ArrayList;

public class SelectSort implements Sorter {
    private int[] nums;
    private ArrayList<String> process;

    @Override
    public void loadData(int[][] items) {
        nums = new int[items.length * items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[0].length; j++) {
                this.nums[i * items.length + j] = items[i][j];
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
                process.add(i + "<->" + index);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
