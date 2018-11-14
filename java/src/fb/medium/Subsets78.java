package fb.medium;//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: nums = [1,2,3]
//        Output:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]


import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int l=nums.length;
        dfs(nums , 0 , l , new ArrayList<Integer>() , ans);
        return ans;

    }
    private void dfs(int[] nums , int idx , int l , List<Integer> candidate , List<List<Integer>> ans){
        ans.add(deepCopy(candidate));
        if(idx==l){
            return;
        }
        for(int i=idx ; i<l;i++){
            candidate.add(nums[i]);
            dfs(nums ,i+1 ,l , candidate , ans);
            candidate.remove(candidate.size()-1);
        }


    }
    private List<Integer> deepCopy(List<Integer> original){
        List<Integer> copy=new ArrayList<>();
        for(Integer i:original){
            copy.add(i);
        }
        return copy;
    }
}
