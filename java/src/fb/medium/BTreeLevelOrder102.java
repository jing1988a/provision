package fb.medium;//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its level order traversal as:
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]


import java.util.ArrayList;
import java.util.List;

public class BTreeLevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){return ans;}
        List<TreeNode> q=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<TreeNode> p=new ArrayList<>();
            List<Integer> temp=new ArrayList<>();
            for(TreeNode node: q){
                temp.add(node.val);
                if(node.left!=null){
                    p.add(node.left);
                }
                if(node.right!=null){
                    p.add(node.right);
                }
            }
            q=p;
            ans.add(temp);
        }
        return ans;
    }
}
