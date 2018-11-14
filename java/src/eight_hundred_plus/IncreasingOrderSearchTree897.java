package eight_hundred_plus;
//Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
//
//        Example 1:
//        Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//        5
//        / \
//        3    6
//        / \    \
//        2   4    8
//        /        / \
//        1        7   9
//
//        Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
//        \
//        7
//        \
//        8
//        \
//        9
//        Note:
//
//        The number of nodes in the given tree will be between 1 and 100.
//        Each node will have a unique integer value from 0 to 1000.
public class IncreasingOrderSearchTree897 {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy=new TreeNode(0);
        this.cur=dummy;
        inorder(root );
        return dummy.right;
    }

    private void inorder(TreeNode root ) {
        if(root==null){return ;}
        inorder(root.left );
        root.left=null;
        this.cur.right=root;
        this.cur=this.cur.right;
        inorder(root.right );
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    // public TreeNode increasingBST(TreeNode root) {
    //     List<Integer> ans=new ArrayList<>();
    //     inorder(root , ans);
    //     TreeNode dummy=new TreeNode(0);

    //     TreeNode cur=dummy;
    //     for(Integer i:ans){
    //         cur.right=new TreeNode(i);
    //         cur=cur.right;
    //     }
    //     return dummy.right;
    // }
    // private void inorder(TreeNode root , List<Integer> ans){
    //     if(root==null){return;}
    //     inorder(root.left , ans);
    //     ans.add(root.val);
    //     inorder(root.right , ans );
    // }
}
