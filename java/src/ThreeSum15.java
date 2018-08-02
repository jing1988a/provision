//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //2 ways, HashMap, sliding window(2 pointer)
        int l=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(l<3){return ans;}
        Arrays.sort(nums);
        int i=0;
        while(i<l-2){
            while(i>0 && i<l-2 && nums[i]==nums[i-1]){i++;}
            int j=i+1;
            int k=l-1;
            while(j<k){
                int temp=nums[i]+nums[j]+nums[k];
                if(temp==0){
                    ans.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                    while(j+1<=k && nums[j+1]==nums[j]){
                        j++;
                    }
                    j++;
                    k--;
                }else if(temp>0){
                    k--;
                }else{
                    j++;
                }

            }
            i++;
        }
        return ans;
    }

    static public void main(String[] a){
        ThreeSum15 test=new ThreeSum15();
        int[] nums={0,0,0,0};
        List<List<Integer>> ans=test.threeSum(nums);
        System.out.println(ans);


//
//        Input:
//[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
//        Output:
//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2],[-2,0,2]]
//        Expected:
//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
    }
}
