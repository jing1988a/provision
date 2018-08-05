package medium;

//Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
//
//        The returned array must be in sorted order.
//
//        Expected time complexity: O(n)
//
//        Example:
//        nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
//
//        Result: [3, 9, 15, 33]
//
//        nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
//
//        Result: [-23, -5, 1, 7]
public class SortTransformedArray360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l = nums.length;
        if (l == 0) {
            return nums;
        }
        int[] ans = new int[l];
        if (a == 0) {
            linerTransfer(nums, ans, b, c, l);
        } else if (a > 0) {
            upTransfer(nums, ans, a, b, c, l);
        } else {
            downTransfer(nums, ans, a, b, c, l);
        }
        return ans;
    }

    private void linerTransfer(int[] nums, int[] ans, int a, int b, int l) {
        if (b > 0) {
            for (int i = 0; i < l; i++) {
                ans[i] = a * nums[i] + b;
            }
        }else{
            for (int i = 0; i < l; i++) {
                ans[l-1-i] = a * nums[i] + b;
            }
        }
    }

    private void upTransfer(int[] nums, int[] ans, int a, int b, int c, int l) {
        int i = 0;
        int j = l - 1;
        int cur = l - 1;
        while (cur >= 0) {
            int left = nums[i] * nums[i] * a + nums[i] * b + c;
            int right = nums[j] * nums[j] * a + nums[j] * b + c;
            if (left > right) {
                ans[cur] = left;
                i++;
            } else {
                ans[cur] = right;
                j--;
            }
            cur--;
        }
    }

    private void downTransfer(int[] nums, int[] ans, int a, int b, int c, int l) {
        int i = 0;
        int j = l - 1;
        int cur = 0;
        while (cur < l) {
            int left = nums[i] * nums[i] * a + nums[i] * b + c;
            int right = nums[j] * nums[j] * a + nums[j] * b + c;
            if (left < right) {
                ans[cur] = left;
                i++;
            } else {
                ans[cur] = right;
                j--;
            }
            cur++;
        }
    }


}
