package W02.task2;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort implements Sorter {
    private int[] nums;
    private ArrayList<String> process;

    @Override
    public void loadData(int[] items) {
        this.nums = items;
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
        process.add(start + "<->" + randomSub);

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
                process.add(left + "<->" + right);
            }
        }
        int flagSub = left;
        if (nums[left] > flagNum) {
            flagSub = left - 1;
            swap(left - 1, start);
            process.add(left - 1 + "<->" + start);
        } else {
            swap(left, start);
            process.add(left + "<->" + start);
        }

        quickSort(nums, start, flagSub);
        quickSort(nums, flagSub + 1, end);
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
