public class smallDivisorThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int num : nums) right = Math.max(right, num);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int total = 0;
            for (int num : nums) {
                total += (num + mid - 1) / mid;
            }
            if (total <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
