import java.util.Arrays;

public class findGCDArray {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[0];

        for(int n :nums){
            if(n<min){
                min=n;
            }
            if(n>max){
                max=n;
            }
        }
        while(min!=0){
            int rem=max%min;
            max=min;
            min=rem;
        }
        return max;
    }
}
