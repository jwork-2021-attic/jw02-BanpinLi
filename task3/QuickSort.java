package W02.task3;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort implements Sorter {
    private int[] nums;
    private int m;
    private int n;
    private ArrayList<String> process;

    @Override
    public void loadData(int[][] items) {
        // 二维数组展开成一维进行排序
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
        quickSort(nums, 0, nums.length);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start == end || start + 1 == end) {
            return;
        }

        Random r = new Random();
        int randomSub = r.nextInt(end - start) + start;
        int flagNum = nums[randomSub];
        swap(start, randomSub);

        int left = start + 1;
        int right = end - 1;
        while (left < right) {
            while (left < right && nums[left] <= flagNum) {
                left++;
            }
            while (left < right && nums[right] > flagNum) {
                right--;
            }
            if (left != right) {
                swap(left, right);
            }
        }
        int flagSub = left;
        if (nums[left] > flagNum) {
            flagSub = left - 1;
            swap(left - 1, start);
        } else {
            swap(left, start);
        }

        quickSort(nums, start, flagSub);
        quickSort(nums, flagSub + 1, end);
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
