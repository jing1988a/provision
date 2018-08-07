//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        You may assume nums1 and nums2 cannot be both empty.
//
//
//
//        Example 1:
//
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5




//obvious there is an O(n) way to do this.


public class MedianTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int k=(l1+l2)/2;
        int i=0;
        int j=0;
        //get k
        int count=0;
        int cur=0;
        while(count<k){
            if(i<l1 &&j<l2) {
                if (nums1[i] < nums2[j]) {

                    cur = nums1[i];
                    i++;
                } else {

                    cur = nums2[j];
                    j++;
                }
            }
            else if(i<l1){

                cur = nums1[i];
                i++;
            }else {

                cur=nums2[j];
                j++;
            }
            count++;
        }



        if((l1+l2)%2==1){
            //looking for k+1
            if(i<l1 &&j<l2){
                if(nums1[i]<nums2[j]){
                    return (double) nums1[i];
                }else{
                    return (double) nums2[j];
                }
            }else if(i<l1){
                return (double) nums1[i];
            }else{
                return (double) nums2[j];
            }

        }else{
            //looking for both k , k+1
            if(i<l1 &&j<l2){
                if(nums1[i]<nums2[j]){
                    return (double) (nums1[i]+cur)/2;
                }else{
                    return (double) (nums2[j]+cur)/2;
                }
            }else if(i<l1){
                return (double) (nums1[i]+cur)/2;
            }else{
                return (double) (nums2[j]+cur)/2;
            }
        }
    }
}
