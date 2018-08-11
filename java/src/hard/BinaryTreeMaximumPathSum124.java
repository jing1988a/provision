package hard;//
//Given a non-empty binary tree, find the maximum path sum.
//
//        For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//        Example 1:
//
//        Input: [1,2,3]
//
//        1
//        / \
//        2   3
//
//        Output: 6
//        Example 2:
//
//        Input: [-10,9,20,null,null,15,7]
//
//        -10
//        / \
//        9  20
//        /  \
//        15   7
//
//        Output: 42



public class BinaryTreeMaximumPathSum124 {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){return 0;}
        int l=maxOneWay(root.left);
        int r=maxOneWay(root.right);
        return Math.max(this.ans , root.val+Math.max(0 , l) +Math.max(0 , r));

    }
    private int maxOneWay(TreeNode node){
        if(node==null){return 0;}
        int l=maxOneWay(node.left);
        int r=maxOneWay(node.right);
        this.ans=Math.max(ans , node.val+Math.max(0 , l)+Math.max(0 , r));
        return Math.max(Math.max(l , r) , 0)+node.val;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
}
