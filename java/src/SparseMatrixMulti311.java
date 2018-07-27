//Given two sparse matrices A and B, return the result of AB.
//
//        You may assume that A's column number is equal to B's row number.
//
//        Example:
//
//        Input:
//
//        A = [
//        [ 1, 0, 0],
//        [-1, 0, 3]
//        ]
//
//        B = [
//        [ 7, 0, 0 ],
//        [ 0, 0, 0 ],
//        [ 0, 0, 1 ]
//        ]
//
//        Output:
//
//        |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//        AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//        | 0 0 1 |
public class SparseMatrixMulti311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int na=A.length;
        int ma=A[0].length;
        int nb=B.length;
        int mb=B[0].length;
        if(ma!=nb){
            throw new RuntimeException("invalid input");
        }
        int[][] ans=new int[na][mb];
        for(int i=0 ; i <na; i++){
            for(int k=0 ; k<ma; k++){
                if(A[i][k]!=0){
                    for(int j=0; j<mb;j++){
                        if(B[k][j]!=0){
                            ans[i][j]+=A[i][k]*B[k][j];
                        }
                    }
                }
            }
        }
        return ans;
        // int na=A.length;
        // int ma=A[0].length;
        // int nb=B.length;
        // int mb=B[0].length;
        // if(ma!=nb){
        //     throw new RuntimeException("invalid input");
        // }
        // int[][] ans=new int[na][mb];
        // for(int i=0 ; i <na; i++){
        //     for(int j=0; j<mb;j++){
        //         for(int k=0 ; k<ma; k++){
        //             if(A[i][k]==0 || B[k][j]==0){continue;}
        //             ans[i][j]+=A[i][k]*B[k][j];
        //         }
        //     }
        // }
        // return ans;
    }
}
