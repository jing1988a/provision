package eight_hundred_plus;

public class MagicSquaresInGrid840 {
    public int numMagicSquaresInside(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0 ; i<n-2  ; i++){
            for(int j=0 ; j<m-2 ; j++){
                if(check(i , j , grid)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int i , int j , int[][] grid){
        boolean[] temp=new boolean[10];
        int target=0;
        for(int x=0 ; x<3 ; x++){
            target+=grid[i][j+x];
        }
        for(int x=0 ; x<3 ; x++){
            int candidate=0;
            for(int y=0 ; y<3 ; y++){
                if(grid[i+x][j+y]<1 || grid[i+x][j+y]>9){
                    return false;
                }
                if(temp[grid[i+x][j+y]]){
                    return false;
                }
                temp[grid[i+x][j+y]]=true;
                candidate+=grid[i+x][j+y];
            }
            if(candidate!=target){
                return false;
            }
        }
        for(int y=0 ; y<3 ; y++){
            int candidate=0;
            for(int x=0 ; x<3 ; x++){
                candidate+=grid[i+x][j+y];
            }
            if(candidate!=target){
                return false;
            }
        }
        int d1=0;
        int d2=0;
        for(int x=0 ; x<3 ; x++){

            d1+=grid[i+x][j+x];
            d2+=grid[i+x][j+2-x];
        }
        if(d1!=target ||d2!=target){
            return false;
        }

        return true;
    }
}
