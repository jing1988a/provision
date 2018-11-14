package eight_hundred_plus;
//You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
//
//        Example:
//        Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//        Output: 2
//        Explanation:
//        The five points are show in the figure below. The red triangle is the largest.
public class LargestTriangleArea812 {
    public double largestTriangleArea(int[][] points) {
        double ans=0;
        for(int i=0 ; i<points.length-2 ; i++){
            for(int j=i+1 ; j<points.length-1 ; j++){
                for(int k=j+1 ; k<points.length ; k++){
                    ans=Math.max(ans , area(points[i] , points[j] , points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] p1 , int[] p2  , int[] p3){
//        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]-P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
        return 0.5 * Math.abs(p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]-p1[1]*p2[0] - p2[1]*p3[0] - p3[1]*p1[0]);

    }
}
