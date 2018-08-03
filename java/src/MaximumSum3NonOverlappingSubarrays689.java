//In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
//
//        Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
//
//        Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
//
//        Example:
//        Input: [1,2,1,2,6,7,5,1], 2
//        Output: [0, 3, 5]
//        Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
//        We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
//        Note:
//        nums.length will be between 1 and 20000.
//        nums[i] will be between 1 and 65535.
//        k will be between 1 and floor(nums.length / 3).


import java.util.ArrayList;
import java.util.List;

public class MaximumSum3NonOverlappingSubarrays689 {
    //brute force
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        int[] ans=new int[3];
//        int candidateMax=0;
//        int l=nums.length;
//        for(int i=0 ; i<=l-3*k ; i++){
//            for(int j=i+k ; j<=l-2*k;j++){
//                for(int m=j+k;  m <=l-k ; m++){
//                    int curSum=getSum(nums , i , j , m , k);
//                    if(curSum>candidateMax){
//                        candidateMax=curSum;
//                        ans[0]=i;
//                        ans[1]=j;
//                        ans[2]=m;
//                    }
//                }
//            }
//        }
//        return ans;
//
//    }
//    private int getSum(int[] nums , int i , int j , int m , int k){
//        int ans=0;
//        for(int x=0 ; x<k ; x++){
//            ans+=nums[i+x];
//            ans+=nums[j+x];
//            ans+=nums[m+x];
//        }
//        return ans;
//    }


//    above is O(n^3)

//improve.
//1. lots of duplicate caculation for the kSum
//we can precaculate a Sum array
//2. with this Sum array , we need find i j  m , each has a k distance with max sum
//3. there is still a lot of duplicate caculation for above question . we can precaculate the left max and right max for each element.
//4. loop [k , l-k] and find the max pair

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> nSum=new ArrayList<>();
        int curSum=0;
        for(int i=0 ; i<nums.length; i++){
            curSum+=nums[i];
            if(i>=k){
                curSum-=nums[i-k];
            }
            if(i>=k-1){
                nSum.add(curSum);
            }
        }
        int l=nSum.size();
        int[] leftMaxIdxs=new int[l];
        int[] rightMaxIdxs=new int[l];
        int curMaxIdx=0;
        for(int i=0 ; i<nSum.size();i++){
            if(nSum.get(curMaxIdx)<nSum.get(i)){
                curMaxIdx=i;
            }
            leftMaxIdxs[i]=curMaxIdx;
        }
        curMaxIdx=nSum.size()-1;
        for(int i=nSum.size()-1 ; i>-1 ; i--){
            if(nSum.get(i)>=nSum.get(curMaxIdx)){
                curMaxIdx=i;
            }
            rightMaxIdxs[i]=curMaxIdx;
        }
        curSum=0;
        int[] ans=new int[3];
        for(int i=k ; i<nSum.size()-k ; i++){
            int temp=nSum.get(leftMaxIdxs[i-k])+nSum.get(i)+nSum.get(rightMaxIdxs[i+k]);
            if(temp>curSum){
                curSum=temp;
                ans[0]=leftMaxIdxs[i-k];
                ans[1]=i;
                ans[2]=rightMaxIdxs[i+k];
            }
        }
        return ans;
    }


}
