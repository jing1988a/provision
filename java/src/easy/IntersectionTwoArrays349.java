package easy;

import medium.SubarraySumEqualsK560;

import java.util.*;

//Given two arrays, write a function to compute their intersection.
//
//        Example 1:
//
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2]
//        Example 2:
//
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [9,4]
//        Note:
//
//        Each element in the result must be unique.
//        The result can be in any order.
public class IntersectionTwoArrays349 {

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> n1=new HashSet<>();
            for(int n:nums1){
                n1.add(n);
            }
            Set<Integer> n2=new HashSet<>();
            for(int n:nums2){
                n2.add(n);
            }
            n1.retainAll(n2); //学到没
            int[] ans=new int[n1.size()];
            int i=0;
            for(Integer n:n1){
                ans[i]=n;
                i++;
            }
            return ans;


        }

    static  public  void  main(String[] arts){
        IntersectionTwoArrays349 test=new IntersectionTwoArrays349();
        int[] a={9 , 4 , 5};
        int[] b={9 ,  4, 9 , 8 , 4};
        System.out.println(test.intersection(a , b));
    }
}
