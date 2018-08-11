package hard;
//
//class Solution:
//        def findMedianSortedArrays(self, nums1, nums2):
//        """
//        :type nums1: List[int]
//        :type nums2: List[int]
//        :rtype: float
//        """
//        def findk(nums1 , nums2 , k):
//        l1=len(nums1)
//        l2=len(nums2)
//        if l1==0:
//        return nums2[k-1]
//        if l2==0:
//        return nums1[k-1]
//        if k ==1:
//        return min(nums1[0] , nums2[0])
//
//        a=nums1[k//2-1] if l1>=k//2 else None
//        b=nums2[k//2-1] if l2>=k//2 else None
//
//        if a==None:
//        #return findk(nums1 , nums2[k//2:]  , k//2)   k 又不是一直是偶数， K-K//2 和 K//2是不一样的。。。
//        return findk(nums1 , nums2[k//2:]  , k-k//2)
//        elif b==None:
//        return findk(nums1[k//2:] , nums2 , k-k//2)
//        elif a<=b:
//        return findk(nums1[k//2:] , nums2 , k-k//2)
//        else:
//        return findk(nums1 , nums2[k//2:]  , k-k//2)
//
//
//
//
//        n=len(nums1)+len(nums2)
//        if n%2:
//        return findk(nums1 , nums2 , n//2+1)
//        else:
//        # print(findk(nums1 , nums2 , n//2+1))
//        # print(findk(nums1 , nums2 , n//2))
//        return float(findk(nums1 , nums2 , n//2+1)+findk(nums1 , nums2 , n//2))/2



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


import java.util.Arrays;

public class MedianTwoSortedArrays4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int l1=nums1.length;
//        int l2=nums2.length;
//        int k=(l1+l2)/2;
//        int i=0;
//        int j=0;
//        //get k
//        int count=0;
//        int cur=0;
//        while(count<k){
//            if(i<l1 &&j<l2) {
//                if (nums1[i] < nums2[j]) {
//
//                    cur = nums1[i];
//                    i++;
//                } else {
//
//                    cur = nums2[j];
//                    j++;
//                }
//            }
//            else if(i<l1){
//
//                cur = nums1[i];
//                i++;
//            }else {
//
//                cur=nums2[j];
//                j++;
//            }
//            count++;
//        }
//
//
//
//        if((l1+l2)%2==1){
//            //looking for k+1
//            if(i<l1 &&j<l2){
//                if(nums1[i]<nums2[j]){
//                    return (double) nums1[i];
//                }else{
//                    return (double) nums2[j];
//                }
//            }else if(i<l1){
//                return (double) nums1[i];
//            }else{
//                return (double) nums2[j];
//            }
//
//        }else{
//            //looking for both k , k+1
//            if(i<l1 &&j<l2){
//                if(nums1[i]<nums2[j]){
//                    return (double) (nums1[i]+cur)/2;
//                }else{
//                    return (double) (nums2[j]+cur)/2;
//                }
//            }else if(i<l1){
//                return (double) (nums1[i]+cur)/2;
//            }else{
//                return (double) (nums2[j]+cur)/2;
//            }
//        }
//    }
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1=nums1.length;
    int l2=nums2.length;
    int k=(l1+l2)/2;
    if((l1+l2)%2==1){
        return (double)findK(nums1 , nums2 , k+1);
    }else{
        return (double)(findK(nums1 , nums2 , k)+findK(nums1 , nums2 , k+1))/2;
    }
}

    private int findK(int[] nums1 , int[] nums2 , int k){
        int l1=nums1.length;
        int l2=nums2.length;
        if(l1==0){
            return nums2[k-1];
        }
        if(l2==0){
            return nums1[k-1];

        }
        if(k==1){
            return Math.min(nums1[0] , nums2[0]);
        }

        Integer a=null;
        Integer b=null;
        if(l1>=k/2){
            a=nums1[k/2-1];
        }
        if(l2>=k/2){
            b=nums2[k/2-1];
        }
        if(b==null){
            return findK( Arrays.copyOfRange(nums1 , k/2 , l1) , nums2 , k-k/2 );   //讲道理  K不是一直是整数的 K-K/2  不是一直和 K/2 一样的
        }else if(a==null){
            return findK( nums1 , Arrays.copyOfRange(nums2 , k/2 , l2)  , k-k/2 );
        }
        if(a<b){
            return findK( Arrays.copyOfRange(nums1 , k/2 , l1) , nums2 , k-k/2 );
        }else{
            return findK( nums1,  Arrays.copyOfRange(nums2 , k/2 ,l2) , k-k/2 );
        }

    }

}
