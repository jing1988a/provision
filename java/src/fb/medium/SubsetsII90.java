package fb.medium;//import java.util.List;Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int l =nums.length;
        if(l==0){return ans;}
        Arrays.sort(nums);
        dfs(nums , 0, l , new ArrayList<Integer>() , ans);
        return ans;
    }
    private void dfs(int[] nums  , int idx , int l , List<Integer> candidate , List<List<Integer>> ans){
        ans.add(deepCopy(candidate));
        if(idx==l){return;}
        for(int i=idx ; i<l ; i++){
            if(i>idx && nums[i]==nums[i-1]){continue;}
            candidate.add(nums[i]);
            dfs(nums  , i+1  , l , candidate , ans);
            candidate.remove(candidate.size()-1);
        }
    }
    private List<Integer> deepCopy(List<Integer> original){
        List<Integer> copy= new ArrayList<>();
        for(Integer i :original){
            copy.add(i);
        }
        return copy;
    }

}
