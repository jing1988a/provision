package fb.easy;
//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//        Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//        _______6______
//        /              \
//        ___2__          ___8__
//        /      \        /      \
//        0      _4       7       9
//        /  \
//        3   5
//        Example 1:
//
//        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//        Output: 6
//        Explanation: The LCA of nodes 2 and 8 is 6.
//        Example 2:
//
//        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//        Output: 2
//        Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
//        according to the LCA definition.
//        Note:
//
//        All of the nodes' values will be unique.
//        p and q are different and both values will exist in the BST.


// can i assume it is always valid?
//
public class LowestCommonAncestor235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        int i;
        int j;
        if(p.val>q.val){
           i=q.val;
           j=p.val;
        }else{
            i=p.val;
            j=q.val;
        }
//        System.out.println(root.val);
        return realFind(root , i , j);
    }
    private TreeNode realFind(TreeNode node , int p , int q){
        if(node==null){
            return null;
        }
        if(node.val>q){
            return realFind(node.left , p , q);
        }
        else if(node.val<p){
            return realFind(node.right , p , q);
        }

        return node;

    }
}
