package eight_hundred_plus;
//Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//        For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//        Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//        Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
//        Note:
//
//        Both of the given trees will have between 1 and 100 nodes.

import fb.easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return isSame(getNodeSeq(root1) , getNodeSeq(root2));
    }
    private List<Integer> getNodeSeq(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        preorder(root , ans);
        return ans;
    }
    private void preorder(TreeNode root , List<Integer> ans){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            ans.add(root.val);
            return;
        }
        preorder(root.left , ans);
        preorder(root.right , ans);
    }
    private boolean isSame(List<Integer> A, List<Integer> B){
        int la=A.size();
        int lb=B.size();
        if(la!=lb){
            return false;
        }
        for(int i =0 ; i< la ; i++){
            if(A.get(i)!=B.get(i)){
                return false;
            }
        }
        return true;
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
