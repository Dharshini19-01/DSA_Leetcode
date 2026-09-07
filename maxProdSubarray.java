public class maxProdSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(n, max * n);
            min = Math.min(n, min * n);
            result = Math.max(result, max);
        }
        return result;
    }

}
