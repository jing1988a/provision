//We have two integer sequences A and B of the same non-zero length.
//
//        We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
//
//        At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
//
//        Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
//
//        Example:
//        Input: A = [1,3,5,4], B = [1,2,3,7]
//        Output: 1
//        Explanation:
//        Swap A[3] and B[3].  Then the sequences are:
//        A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
//        which are both strictly increasing.
//        Note:
//
//        A, B are arrays with the same length, and that length will be in the range [1, 1000].
//        A[i], B[i] are integer values in the range [0, 2000].


import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing801 {
//    int curAns=Integer.MAX_VALUE;
//    public int minSwap(int[] A, int[] B) {
//        //cann i  assume A & B has the same size???
//        int l=A.length;
//        if(l==0){return 0;}
//        dfs(1 , l , A , B , 0);
//        swap(A , B , 0);
//        dfs(1 , l , A , B , 1);
//        swap(A , B , 0);
//        return this.curAns;
//    }
//    private void dfs(int idx , int l , int[] A , int[] B , int candidate){
//        if(candidate>=this.curAns){return;}
//        if(idx==l){
//            this.curAns=Math.min(this.curAns , candidate);
//            return;
//        }
//        if(A[idx]>A[idx-1] && B[idx]>B[idx-1]){
//            dfs(idx+1 , l , A , B , candidate);
//        }
//
//        if(B[idx]>A[idx-1] && A[idx]>B[idx-1]){
//            swap(A , B , idx);
//            dfs(idx+1 , l , A , B , candidate+1);
//            swap(A , B , idx);
//        }
//
//    }
//    private void swap(int[] A , int[] B , int idx){
//        int temp=A[idx];
//        A[idx]=B[idx];
//        B[idx]=temp;
//    }

// 上面这方法完全没有问题 就是 2^n 的时间复杂度  会TLE。  道理我都懂 面试的时候这题能想到DP 算是见鬼了。。。

    public int minSwap(int[] A, int[] B) {
        //cann i  assume A & B has the same size???
        int l=A.length;
        if(l==0){return 0;}
        int[] noSwap=new int[l];
        Arrays.fill(noSwap , Integer.MAX_VALUE);
        int[] swap=new int[l];
        Arrays.fill(swap , Integer.MAX_VALUE);
        swap[0]=1;
        noSwap[0]=0;
        for(int i=1 ; i<l ; i++){
            if(A[i]>A[i-1] && B[i]>B[i-1]){
                noSwap[i]=noSwap[i-1];
                swap[i]=swap[i-1]+1;
            }
            if(B[i]>A[i-1] && A[i]>B[i-1]){
                noSwap[i]=Math.min(noSwap[i] , swap[i-1]);
                swap[i]=Math.min(swap[i] , noSwap[i-1]+1);
            }
        }
        return Math.min(noSwap[l-1] , swap[l-1]);
    }

}
