//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//        Example 1:
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 9
//
//        Output: True
//        Example 2:
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 28
//
//        Output: False

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    boolean found=false;
    private void preorder(TreeNode root , int k , Set values){
        if(root==null || this.found==true){
            return;
        }

        if(values.contains(k-root.val)){
            this.found=true;
            return;
        }
        values.add(root.val);
        preorder(root.left , k , values);
        preorder(root.right , k , values);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> values=new HashSet<>();
        preorder(root , k , values);
        return this.found;

    }
}
