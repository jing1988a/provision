package fb.medium;
//Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
//        Note: If the given node has no in-order successor in the tree, return null.
//
//        Example 1:
//
//        Input: root = [2,1,3], p = 1
//
//        2
//        / \
//        1   3
//
//        Output: 2
//        Example 2:
//
//        Input: root = [5,3,6,2,4,null,null,1], p = 6
//
//        5
//        / \
//        3   6
//        / \
//        2   4
//        /
//        1
//
//        Output: null

public class InorderSuccessorBST285 {
    TreeNode ans;
    TreeNode pre;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {


        if (root == null) {
            return null;
        }
        inorder(root , p);
        return this.ans;


//        if(root==null){
//            return null;
//        }
//        if(this.ans!=null){
//            return this.ans;
//        }
//        inorderSuccessor(root.left , p);
//        if(this.pre==p){
//            this.ans=root;
//            this.pre=root; // 这一步要把 pre 改成别的 不然 返回到前面  pre 还是满足条件就会把 ans overwrite 。。。
//            return this.ans;
//        }
//        this.pre=root;
//        inorderSuccessor(root.right , p);
//        return this.ans;
    }


    private void inorder(TreeNode n , TreeNode p) {
        if (n == null || this.ans!=null) {
            return;
        }
        inorder(n.left , p);
        if(this.pre==p){
            this.ans=n;
            this.pre=n;
            return;
        }
        this.pre=n;
        inorder(n.right , p);
    }
}
