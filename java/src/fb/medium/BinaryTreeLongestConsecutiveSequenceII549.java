package fb.medium;

//Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
//
//        Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
//
//        Example 1:
//        Input:
//        1
//        / \
//        2   3
//        Output: 2
//        Explanation: The longest consecutive path is [1, 2] or [2, 1].
//        Example 2:
//        Input:
//        2
//        / \
//        1   3
//        Output: 3
//        Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
//        Note: All the values of tree nodes are in the range of [-1e7, 1e7].

public class BinaryTreeLongestConsecutiveSequenceII549 {
    int ans=0;
    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] lSeq=recur(root.left);
        int[] rSeq=recur(root.right);
        int incre=1;
        int decre=1;
        if(root.left!=null){
            if(root.left.val==root.val+1) {
                decre+=lSeq[0];
            }if(root.left.val==root.val-1){
                incre+=lSeq[1];
            }
        }
        if(root.right!=null){
            if(root.right.val==root.val-1){
                decre+=rSeq[1];
            }
            if(root.right.val==root.val+1){
                incre+=rSeq[0];
            }
        }
        return Math.max(this.ans , Math.max(decre , incre));
    }

    private int[] recur(TreeNode root){
        if(root==null){
            return new int[]{0  , 0};
        }
        int[] lSeq=recur(root.left);
        int[] rSeq=recur(root.right);
        int seq0=1;
        int seq1=1;
        int incre=1;
        int decre=1;
        if(root.left!=null){
            if(root.left.val==root.val+1) {
                decre+=lSeq[0];
                seq0=Math.max(seq0 , 1+lSeq[0]);
            }if(root.left.val==root.val-1){
                incre+=lSeq[1];
                seq1=Math.max(seq1 , 1+lSeq[1]);
            }
        }
        if(root.right!=null){
            if(root.right.val==root.val-1){
                decre+=rSeq[1];
                seq1=Math.max(seq1 , 1+rSeq[1]);
            }
            if(root.right.val==root.val+1){
                incre+=rSeq[0];
                seq0=Math.max(seq0 , 1+rSeq[0]);
            }
        }

        this.ans =Math.max(this.ans , Math.max(decre , incre));
        return new int[] {seq0 , seq1};

    }
}
