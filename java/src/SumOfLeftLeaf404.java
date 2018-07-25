//
//Find the sum of all left leaves in a given binary tree.
//
//        Example:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//question , if there is nonly root node , is it treat as a left node or not????
public class SumOfLeftLeaf404 {
    int ans=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){return 0;}
//        if(root.right==null && root.left==null){
//            return root.val;
//        }
        preorder(root.left , 1);
        preorder(root.right , 0);
        return this.ans;
    }
    private void preorder(TreeNode node  ,int flag){
        if(node==null){return;}
        if(node.right==null && node.left==null && flag==1){
            this.ans+= node.val;
            return;
        }
        preorder(node.left , 1);
        preorder(node.right , 0);
    }
}
