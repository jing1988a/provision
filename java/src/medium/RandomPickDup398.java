package medium;
//Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
//
//        Note:
//        The array size can be very large. Solution that uses too much extra space will not pass the judge.
//
//        Example:
//
//        int[] nums = new int[] {1,2,3,3,3};
//        Solution solution = new Solution(nums);
//
//// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
//        solution.pick(3);
//
//// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
//        solution.pick(1);


public class RandomPickDup398 {
    int[] nums;

    public RandomPickDup398(int[] nums) {

        this.nums = nums;
    }

    public int pick(int target) {
        int idx = 0;
        int count = 0;
        int ans = -1;
        for (int n : this.nums) {
            if (n == target) {
                count++;
                if (randInt(count) == 0) {
                    ans = idx;
                }
            }
            idx++;
        }
        return ans;
    }

    private int randInt(int end) {
        return (int) (Math.random() * end);
    }
}
