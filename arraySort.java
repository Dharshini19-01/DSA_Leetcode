
public class arraySort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int randIdx = low + (int) (Math.random() * (high - low + 1));
        swap(nums, randIdx, high);

        int pivot = nums[high], i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);

        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a]; nums[a] = nums[b]; nums[b] = t;
    }
}
