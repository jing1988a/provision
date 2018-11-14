package fb.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//you are given an array A of strings.
//
//        Two strings S and T are special-equivalent if after any number of moves, S == T.
//
//        A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
//
//        Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
//
//        Return the number of groups of special-equivalent strings from A.
//
//
//
//        Example 1:
//
//        Input: ["a","b","c","a","c","c"]
//        Output: 3
//        Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
//        Example 2:
//
//        Input: ["aa","bb","ab","ba"]
//        Output: 4
//        Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
//        Example 3:
//
//        Input: ["abc","acb","bac","bca","cab","cba"]
//        Output: 3
//        Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
//        Example 4:
//
//        Input: ["abcd","cdab","adcb","cbad"]
//        Output: 1
//        Explanation: 1 group ["abcd","cdab","adcb","cbad"]
//
//
//        Note:
//
//        1 <= A.length <= 1000
//        1 <= A[i].length <= 20
//        All A[i] have the same length.
//        All A[i] consist of only lowercase letters.
public class GroupsofSpecialEquivalentStrings839 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> groups=new HashSet<>();
        for(String s:A){
            PriorityQueue<Character> part1=new PriorityQueue<>();
            PriorityQueue<Character> part2=new PriorityQueue<>();
            for(int i=0 ; i<s.length() ; i++){
                if(i%2==0){
                    part1.add(s.charAt(i));
                }else{
                    part2.add(s.charAt(i));
                }
            }
            StringBuilder temp=new StringBuilder();
            while(!part1.isEmpty()){
                temp.append(part1.poll());
            }
            temp.append('_');
            while(!part2.isEmpty()){
                temp.append(part2.poll());
            }
            groups.add(temp.toString());
        }
        return groups.size();
    }

    static public void main(String[] str){
        GroupsofSpecialEquivalentStrings839 test=new GroupsofSpecialEquivalentStrings839();
        String[] A={"couxuxaubw","zsptcwcghr","kkntvvhbcc","nkhtcvvckb","crcwhspgzt"};
        test.numSpecialEquivGroups(A);
    }

}
