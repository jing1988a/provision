package fb.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
//
//        Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
//
//        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//
//        The right-most node is also defined by the same way with left and right exchanged.
//
//        Example 1
//        Input:
//        1
//        \
//        2
//        / \
//        3   4
//
//        Ouput:
//        [1, 3, 4, 2]
//
//        Explanation:
//        The root doesn't have left subtree, so the root itself is left boundary.
//        The leaves are node 3 and 4.
//        The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
//        So order them in anti-clockwise without duplicates and we have [1,3,4,2].
//        Example 2
//        Input:
//        ____1_____
//        /          \
//        2            3
//        / \          /
//        4   5        6
//        / \      / \
//        7   8    9  10
//
//        Ouput:
//        [1,2,4,7,8,9,10,6,3]
//
//        Explanation:
//        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
//        The leaves are node 4,7,8,9,10.
//        The right boundary are node 1,3,6,10. (10 is the right-most node).
//        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
public class BoundaryofBinaryTree545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){return ans;}
        ans.add(root.val);
        if(root.left!=null){
            List<Integer> leftB=getLeftBoundary(root.left);
            ans.addAll(leftB.subList(0 , leftB.size()-1));
        }if(root.right!=null || root.left!=null) {
            List<Integer> leafs = getLeafs(root);
            ans.addAll(leafs);
        }
        if(root.right!=null){
            List<Integer> rightB=getRightBoundary(root.right);
            Collections.reverse(rightB);
            ans.addAll(rightB.subList(1 , rightB.size()));
        }
        return ans;
    }
    private ArrayList<Integer> getLeftBoundary(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        while(root!=null){
            ans.add(root.val);
            if(root.left!=null){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ans;
    }
    private ArrayList<Integer> getRightBoundary(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        while(root!=null){
            ans.add(root.val);
            if(root.right!=null){
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return ans;
    }
    private ArrayList<Integer> getLeafs(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(root , ans);
        return ans;
    }
    private void dfs(TreeNode root , ArrayList<Integer> ans){
        if(root.right==null&&root.left==null){
            ans.add(root.val);
            return;
        }
        if(root.left!=null){
            dfs(root.left , ans);
        }
        if(root.right!=null){
            dfs(root.right , ans);
        }
    }
}
