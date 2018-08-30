package eight_hundred_plus;



import java.util.ArrayList;
import java.util.List;

//A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//
//        Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
//
//        Each node of each tree in the answer must have node.val = 0.
//
//        You may return the final list of trees in any order.
//
//
//
//        Example 1:
//
//        Input: 7
//        Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//        Explanation:
//
//
//
//        Note:
//
//        1 <= N <= 20
public class AllPossibleFullBinaryTrees894 {
    public List<TreeNode> allPossibleFBT(int N) {
        if(N==0){
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> ans=new ArrayList<>();
        if(N==1){
            TreeNode root=new TreeNode(0);
            ans.add(root);
            return ans;
        }
        for(int i=1 ; i<N-1 ; i++){
            int j= N-i-1;
            for(TreeNode l: allPossibleFBT(i)){
                for(TreeNode r:allPossibleFBT(j)){
                    TreeNode root=new TreeNode(0);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;

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
