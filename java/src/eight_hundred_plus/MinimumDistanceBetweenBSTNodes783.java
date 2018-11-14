package eight_hundred_plus;
//Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
//
//        Example :
//
//        Input: root = [4,2,6,1,3,null,null]
//        Output: 1
//        Explanation:
//        Note that root is a TreeNode object, not an array.
//
//        The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//        4
//        /   \
//        2      6
//        / \
//        1   3
//
//        while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
//        Note:
//
//        The size of the BST will be between 2 and 100.
//        The BST is always valid, each node's value is an integer, and each node's value is different.

public class MinimumDistanceBetweenBSTNodes783 {
    int ans=Integer.MAX_VALUE;
    Integer pre=null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return this.ans;
    }
    private void inorder(TreeNode  root){
        if(root==null){
            return;
        }

        inorder(root.left);
        if(this.pre!=null){
            this.ans=Math.min(this.ans , root.val-pre);
        }
        this.pre=root.val;
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
