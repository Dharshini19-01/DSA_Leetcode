import java.util.Arrays;

public class wigglesortII{
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] result = nums.clone();
        Arrays.sort(result);
        int left = (n - 1) / 2;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = result[left--];
            } else {
                nums[i] = result[right--];
            }
        }
    }
}