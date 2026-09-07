public class houseRobber {
    public int rob(int[] nums) {
        int pr2=0,pr1=0;
        for(int n:nums){
            int cur=Math.max(pr1,pr2+n);
            pr2=pr1;
            pr1=cur;
        } 
        return pr1;
    }
}
