package fb.medium;//
//Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
//
//        Example 1:
//        Input: 2736
//        Output: 7236
//        Explanation: Swap the number 2 and the number 7.
//        Example 2:
//        Input: 9973
//        Output: 9973
//        Explanation: No swap.
//        Note:
//        The given number is in the range [0, 108]


public class MaximumSwap670 {
//    public int maximumSwap(int num) {
//        if(num<10){return num;}
//        int[] nums=intToArray(num);
//        int l=nums.length;
//        int[][] rightMax=new int[l][2];
//        int[] cur={0 , l};
//        for(int i=l-1 ; i>-1 ; i-- ){
//            rightMax[i]= Arrays.copyOf(cur , cur.length);
//            if(rightMax[i][0]<nums[i]){
//                cur[0]=nums[i];
//                cur[1]=i;
//            }
//        }
//        for(int i=0 ; i<l-1 ; i++){
//            if (rightMax[i][0]>nums[i]) {
//                int idx=rightMax[i][1];
//                int temp=nums[idx];
//                nums[idx]=nums[i];
//                nums[i]=temp;
//                return toInt(nums);
//            }
//        }
//        return num;
//    }
    public int maximumSwap2(int num) {
        if(num<10){return num;}
        int[] nums=intToArray(num);
        int l=nums.length;
        int[]rightMaxIdx=new int[l];
        int curIdx=l-1;
        for(int i=l-2 ; i>-1 ; i-- ){
            rightMaxIdx[i]=curIdx;
            if(nums[rightMaxIdx[i]]<nums[i]){
                curIdx=i;
            }
        }
        for(int i=0 ; i<l-1 ; i++){
            if (nums[rightMaxIdx[i]]>nums[i]) {
                int idx=rightMaxIdx[i];
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                return toInt(nums);
            }
        }
        return num;
    }
    private int[] intToArray(int num){
        String nStr=String.valueOf(num);
        int l =nStr.length();
        int[] ans=new int[l];
        for(int i=0; i<l ; i++){
            ans[i]=Character.getNumericValue(nStr.charAt(i));
        }
        return ans;

    }
    private int toInt(int[] nums){
        int ans=0;
        for(int n :nums){
            ans=ans*10+n;
        }
        return ans;
    }

    static public void main(String[] arg){
        int nums=9973;
        MaximumSwap670 test= new MaximumSwap670();
        test.maximumSwap2(nums);
    }
}
