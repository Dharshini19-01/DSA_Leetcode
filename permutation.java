import java.util.ArrayList;
import java.util.List;

public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        f(nums,0,res);
        return res;
    }
    private void f(int[] nums,int idx,List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer> cur=new ArrayList<>();
            for(int x: nums) cur.add(x);
            res.add(cur);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            f(nums,idx+1,res);
            swap(nums,i,idx);
        }
    }
    private void swap(int[] nums,int i,int j){
        int t=nums[i];nums[i]=nums[j];nums[j]=t;
    }
}
