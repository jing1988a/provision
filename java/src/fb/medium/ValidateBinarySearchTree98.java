package fb.medium;//
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//
//        Input:
//        2
//        / \
//        1   3
//        Output: true
//        Example 2:
//
//        5
//        / \
//        1   4
//        / \
//        3   6
//        Output: false
//        Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//        is 5 but its right child's value is 4.



public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        if(root==null){return true;}
        return realCheckValidBST(root.left , Double.NEGATIVE_INFINITY , root.val)&& realCheckValidBST(root.right,root.val,Double.POSITIVE_INFINITY);
    }
    private boolean realCheckValidBST(TreeNode node , double l , double r ){
        if(node==null){return true;}
        if(node.val<=l || node.val>=r){return false;}
        return realCheckValidBST(node.left , l, node.val)&& realCheckValidBST(node.right,node.val,r);
    }
}
