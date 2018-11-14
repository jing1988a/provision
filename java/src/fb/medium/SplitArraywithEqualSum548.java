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




//解题思路：
//        利用数组sums记录前n项和
//
//        利用字典idxs统计sums元素对应的下标列表
//
//        根据sums和idxs枚举满足(0, i - 1) == (i + 1, j - 1)条件的i，j。利用字典jlist记录子数组和对应的j值列表
//
//        最后遍历k，枚举jlist中子数组和(k + 1, n - 1)对应的j值，然后判断是否存在 (j + 1, k - 1)  与 (k + 1, n - 1) 相等
//
//        Python代码：
//class Solution(object):
//        def splitArray(self, nums):
//        """
//        :type nums: List[int]
//        :rtype: bool
//        """
//        size = len(nums)
//        sums = [0] * (size + 1)
//        for x in range(size):
//        sums[x + 1] += sums[x] + nums[x]
//
//        idxs = collections.defaultdict(list)
//        for x in range(size):
//        idxs[sums[x + 1]].append(x)
//
//        jlist = collections.defaultdict(list)
//        for i in range(1, size):
//        for j in idxs[2 * sums[i] + nums[i]]:
//        if i < j < size:
//        jlist[sums[i]].append(j + 1)
//
//        for k in range(size - 2, 0, -1):
//        for j in jlist[sums[size] - sums[k + 1]]:
//        if j + 1 > k: continue
//        if sums[k] - sums[j + 1] == sums[size] - sums[k + 1]:
//        return True
//        return False
