package eight_hundred_plus;

import java.util.ArrayList;
import java.util.List;

//given a string S of lowercase letters, these letters form consecutive groups of the same character.
//
//        For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
//
//        Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
//
//        The final answer should be in lexicographic order.
//
//
//
//        Example 1:
//
//        Input: "abbxxxxzzy"
//        Output: [[3,6]]
//        Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
//        Example 2:
//
//        Input: "abc"
//        Output: []
//        Explanation: We have "a","b" and "c" but no large group.
//        Example 3:
//
//        Input: "abcdddeeeeaabbbcd"
//        Output: [[3,5],[6,9],[12,14]]
//
//
//        Note:  1 <= S.length <= 1000
public class PositionsofLargeGroups830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        int l = S.length();
        List<List<Integer>> ans = new ArrayList<>();
        if (l < 3) {
            return ans;
        }
        int start = 0;
        int end = 1;
        int count = 1;
        while (end < l) {
            if (S.charAt(end) == S.charAt(end - 1)) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(end - 1);
                    ans.add(temp);


                }
                start = end;
                count = 1;
            }
            end++;
        }
        if (count >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end - 1);
            ans.add(temp);
        }
        return ans;
    }
}
