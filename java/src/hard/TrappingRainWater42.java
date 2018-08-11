package hard;//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
//        Example:
//
//        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6


public class TrappingRainWater42 {
    public int trap(int[] height) {
        int l=height.length;
        if(l<3){return 0;}
        int[] leftMax=new int[l];
        int[] rightMax=new int[l];
        int cur=0;
        for(int i=0 ; i<l ; i++){
            leftMax[i]=cur;
            cur=Math.max(cur , height[i]);
        }
        cur=0;
        for(int i=l-1 ; i>=0 ; i--){
            rightMax[i]=cur;
            cur=Math.max(cur , height[i]);
        }
        int ans=0;
        for(int i=0 ; i<l ; i++){
            ans+=Math.max(Math.min(leftMax[i] , rightMax[i])-height[i] , 0);
        }
        return ans;
    }
}
