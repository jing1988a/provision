package eight_hundred_plus;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImageOverlap835 {
    //    Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
//
//    We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
//
//            (Note also that a translation does not include any kind of rotation.)
//
//    What is the largest possible overlap?
//
//    Example 1:
//
//    Input: A = [[1,1,0],
//            [0,1,0],
//            [0,1,0]]
//    B = [[0,0,0],
//            [0,1,1],
//            [0,0,1]]
//    Output: 3
//    Explanation: We slide A to right by 1 unit and down by 1 unit.
//            Notes:
//
//            1 <= A.length = A[0].length = B.length = B[0].length <= 30
//            0 <= A[i][j], B[i][j] <= 1
    public int largestOverlap(int[][] A, int[][] B) {
        Set<Pair<Integer , Integer>> pointsA=new HashSet<>();
        Set<Pair<Integer , Integer>> pointsB=new HashSet<>();
        int n=A.length;
        int m=A[0].length;
        for(int i=0 ; i<n ; i++){
            for( int j=0 ; j<m  ;  j++){
                if(A[i][j]==1){
                    pointsA.add(new Pair(i , j));
                }
                if(B[i][j]==1){
                    pointsB.add(new Pair(i , j));
                }
            }
        }
        Set<Pair<Integer , Integer>> visitedDelta=new HashSet<>();
        int ans=0;
        for(Pair<Integer, Integer> pa:pointsA){
            for(Pair<Integer , Integer> pb:pointsB){
                int dx=pa.getKey()-pb.getKey();
                int dy=pa.getValue()-pb.getValue();
                Pair<Integer , Integer> delta=new Pair<>(dx , dy);
                if(!visitedDelta.contains(delta)){
                    visitedDelta.add(delta);
                    int temp=0;
                    for(Pair<Integer, Integer> p:pointsA){
                        Pair<Integer , Integer> target=new Pair(p.getKey()-dx , p.getValue()-dy);
                        if(pointsB.contains(target)){
                            temp++;
                        }
                    }
                    ans=Math.max(ans , temp);
                }
            }
        }
        return ans;

    }
}
