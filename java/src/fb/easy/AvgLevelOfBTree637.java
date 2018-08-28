package fb.easy;
//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//        Example 1:
//        Input:
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Output: [3, 14.5, 11]
//        Explanation:
//        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//        Note:
//        The range of node's value is in the range of 32-bit signed integer.


import java.util.ArrayList;
import java.util.List;

public class AvgLevelOfBTree637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<Double>();
        List<TreeNode> q=new ArrayList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            List<TreeNode> p=new ArrayList<TreeNode>();
            double curTotal=0;
            int l=q.size();
            for(int i=0 ; i<l;  i++){
                TreeNode curNode=q.get(i);
                curTotal+=curNode.val;
                if(curNode.left!=null){
                    p.add(curNode.left);
                }
                if(curNode.right!=null){
                    p.add(curNode.right);
                }
            }
            ans.add(curTotal/l);
            q=p;
        }
        return ans;

    }
}
