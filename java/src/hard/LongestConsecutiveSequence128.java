package hard;//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        Your algorithm should run in O(n) complexity.
//
//        Example:
//
//        Input: [100, 4, 200, 1, 3, 2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nSet=new HashSet<>();
        for(int n :nums){
            nSet.add(n);
        }
        int ans=0;
        for(Integer n:nSet){
            if(nSet.contains(n-1)){continue;}
            int count=1;
            while(nSet.contains(n+1)){
                n++;
                count++;
            }
            ans=Math.max(ans , count);
        }
        return ans;
    }
    // tricky part 是 time complexity.  看上去像是O(n^2)  其实是O(n)  因为最多只会把所有element  visit 2次  所以 worst case 是O(2N)
}
