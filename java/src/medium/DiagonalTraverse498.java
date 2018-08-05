package medium;
//Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
//
//        Example:
//        Input:
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        Output:  [1,2,4,7,5,3,6,8,9]
//        Explanation:
//
//        Note:
public class DiagonalTraverse498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n=matrix.length;
        if(n==0){return new int[] {};}
        int m=matrix[0].length;
        if(m==0){return new int[] {};}
        int[][] direction={{-1 ,1} , {1 , -1} };
        int d=0;
        int cur=0;
        int i=0;
        int j=0;
        int[] ans=new int[m*n];
        while(cur<m*n){
            ans[cur]=matrix[i][j];
            if(d==0){
                if(j==(m-1) ){
                    i++;
                    d=1;

                }else if(i==0){
                    j++;
                    d=1;
                }else{
                    i+=direction[d][0];
                    j+=direction[d][1];
                }
            }else{
                if(i==(n-1)){
                    j++;
                    d=0;
                }else if(j==0){
                    i++;
                    d=0;
                }else{
                    i+=direction[d][0];
                    j+=direction[d][1];
                }
            }

            cur++;
        }
        return ans;
    }
}
