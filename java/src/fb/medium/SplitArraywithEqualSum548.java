package fb.medium;

//Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
//
//        0 < i, i + 1 < j, j + 1 < k < n - 1
//        Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
//        where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
//        Example:
//        Input: [1,2,1,2,1,2,1]
//        Output: True
//        Explanation:
//        i = 1, j = 3, k = 5.
//        sum(0, i - 1) = sum(0, 0) = 1
//        sum(i + 1, j - 1) = sum(2, 2) = 1
//        sum(j + 1, k - 1) = sum(4, 4) = 1
//        sum(k + 1, n - 1) = sum(6, 6) = 1
//        Note:
//        1 <= n <= 2000.
//        Elements in the given array will be in range [-1,000,000, 1,000,000].

public class SplitArraywithEqualSum548 {
    public boolean splitArray(int[] nums) {
        int l=nums.length;
        if(l<7){
            return false;
        }
        int[] leftSum=new int[l];
        int cur=0;
        for(int i=0 ; i<l ; i++){
            cur+=nums[i];
            leftSum[i]=cur;
        }
        for(int i=1  ; i<l-5 ; i++){
            for(int j=i+2 ;j<l-3 ; j++){
                for(int k=j+2; k<l-1 ; k++){
                    if(leftSum[i-1]==(leftSum[j-1]-leftSum[i]) &&  (leftSum[j-1]-leftSum[i]) == (leftSum[k-1]-leftSum[j]) && (leftSum[l-1]-leftSum[k])==(leftSum[k-1]-leftSum[j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
