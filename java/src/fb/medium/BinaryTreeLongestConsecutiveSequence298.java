package fb.medium;

//
//Given a binary tree, find the length of the longest consecutive sequence path.
//
//        The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
//
//        Example 1:
//
//        Input:
//
//        1
//        \
//        3
//        / \
//        2   4
//        \
//        5
//
//        Output: 3
//
//        Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
//        Example 2:
//
//        Input:
//
//        2
//        \
//        3
//        /
//        2
//        /
//        1
//
//        Output: 2
//
//        Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

public class BinaryTreeLongestConsecutiveSequence298 {
    int ans=0;
    public int longestConsecutive(TreeNode root) {
        if(root==null){return 0;}
        int lSeq=recur(root.left);
        int rSeq=recur(root.right);
        int seq=1;
        if(root.left!=null&&root.left.val==root.val+1){
            seq=Math.max(seq , lSeq+1);
        }
        if(root.right!=null&&root.right.val==root.val+1){
            seq=Math.max(seq , rSeq+1);
        }
        return Math.max(this.ans , seq);
    }

    private  int recur(TreeNode root){
        if(root==null){return 0;}
        int lSeq=recur(root.left);
        int rSeq=recur(root.right);
        int seq=1;
        if(root.left!=null&&root.left.val==root.val+1){
            seq=Math.max(seq , lSeq+1);
        }
        if(root.right!=null&&root.right.val==root.val+1){
            seq=Math.max(seq , rSeq+1);
        }
        this.ans= Math.max(this.ans , seq);
        return seq;
    }
}
