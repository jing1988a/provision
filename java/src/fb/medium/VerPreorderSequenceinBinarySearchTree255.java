package fb.medium;
//Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
//        You may assume each number in the sequence is unique.
//
//        Consider the following binary search tree:
//
//        5
//        / \
//        2   6
//        / \
//        1   3
//        Example 1:
//
//        Input: [5,2,6,1,3]
//        Output: false
//        Example 2:
//
//        Input: [5,2,1,3,6]
//        Output: true
//        Follow up:
//        Could you do it using only constant space complexity?
public class VerPreorderSequenceinBinarySearchTree255 {
    public boolean verifyPreorder(int[] preorder) {
        int l=preorder.length;
        if(l==0){
            return true;
        }
        int rootVal=preorder[0];
        int i=1;
        while(i<l){
            if(preorder[i]>rootVal){
                break;
            }
            i++;
        }
        return realCheck(preorder , 1 , i-1 , Integer.MIN_VALUE , rootVal)&&realCheck(preorder , i , l-1 , rootVal , Integer.MAX_VALUE);

    }
    private boolean realCheck(int[] preorder , int start, int end , int leftBound , int rightBound){
        if(start>end){
            return true;
        }
        int rootVal=preorder[start];
        if(rootVal<=leftBound || rootVal>=rightBound){
            return false;
        }
        int i=start+1;
        while(i<=end){
            if(preorder[i]<=leftBound || preorder[i]>=rightBound){
                return false;
            }
            if(preorder[i]>rootVal){
                break;
            }
            i++;
        }
        return realCheck(preorder , start+1 , i-1 , leftBound , rootVal)&&realCheck(preorder , i , end , rootVal , rightBound);


    }

    static public void main(String[] strs){
        VerPreorderSequenceinBinarySearchTree255 test=new VerPreorderSequenceinBinarySearchTree255();
        int[] preorder={1 , 3 , 2};

        System.out.println(test.verifyPreorder(preorder));
    }
//
//    [1,3,2]
}
