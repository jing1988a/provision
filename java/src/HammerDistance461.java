//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//        Given two integers x and y, calculate the Hamming distance.
//
//        Note:
//        0 ≤ x, y < 231.
//
//        Example:
//
//        Input: x = 1, y = 4
//
//        Output: 2
//
//        Explanation:
//        1   (0 0 0 1)
//        4   (0 1 0 0)
//        ↑   ↑
//
//        The above arrows point to positions where the corresponding bits are different.
//


import java.util.Arrays;

public class HammerDistance461 {
    public int hammingDistance(int x, int y) {
        char[] binaryFormat=Integer.toBinaryString(x^y).toCharArray();
        int ans=0;
        for(char c : binaryFormat){
            if(c=='1'){
                ans++;
            }
        }
        return ans;

    }
    static public void main(String[] args) {
        HammerDistance461 test=new HammerDistance461();
        test.hammingDistance(1 , 4);
//        System.out.println("what");

    }
}


