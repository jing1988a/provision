package fb.easy;

public class Sqrt69 {
    public int mySqrt(int x) {
        if(x<2){return x;}
        int s=0;
        int e=x/2;
        while (s<=e){
            long mid=(s+e)/2;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid>x){
                e=(int)mid-1;
            }else{
                s=(int)mid+1;
            }
        }
        return e;
    }
}
