//
//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
//
//        According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
//
//        Example:
//
//        Input: citations = [3,0,6,1,5]
//        Output: 3
//        Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
//        received 3, 0, 6, 1, 5 citations respectively.
//        Since the researcher has 3 papers with at least 3 citations each and the remaining
//        two with no more than 3 citations each, her h-index is 3.
//        Note: If there are several possible values for h, the maximum one is taken as the h-index.
//


import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int l=citations.length;
//        int i=l-1;
//        while(i>-1){
//            if(citations[i]<l-i){
//                break;
//            }
//            i--;
//        }
//        return l-i-1;
//        above is O(log(n))  can you improve it to O(n)???
        int n=citations.length;
        int[] count= new int[n+1];
        for(int c :citations){
            if(c>=n){
                count[n]++;
            }else{
                count[c]++;
            }
        }
        int cur=0;
        int i=n;
        while(i>-1){
            if(cur+count[i]>=i){
                return i;
            }else{
                cur+=count[i];
            }
            i--;
        }
        return i;

    }
}
