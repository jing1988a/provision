package ms.easy;



//A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
//
//        Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
//
//        Given two (axis-aligned) rectangles, return whether they overlap.
//
//        Example 1:
//
//        Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//        Output: true
//        Example 2:
//
//        Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//        Output: false
//        Notes:
//
//        Both rectangles rec1 and rec2 are lists of 4 integers.
//        All coordinates in rectangles will be between -10^9 and 10^9.



//The solution itself does not worth noticing too much as it is really easy.
//
//        The take away of this problem is when trying to check if a condition is
//
//        true or false, we can do it in two ways. Either check if all the true conditions
//
//        are met; Or check if all the false conditions are met.
//
//
//
//        For this problem, checking if the two given rectangles overlap directly is complicated.
//
//        So we check if they do not overlap, then return the reversed check result.



public class RectangleOverlap836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0]>=rec2[2] || rec1[2]<=rec2[0] || rec1[3]<=rec2[1] || rec1[1]>=rec2[3] );
    }
}
