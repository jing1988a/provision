import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return all root-to-leaf paths.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input:
//
//        1
//        /   \
//        2     3
//        \
//        5
//
//        Output: ["1->2->5", "1->3"]
//
//        Explanation: All root-to-leaf paths are: 1->2->5, 1->3
public class BTreePath257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        travel(root ,  new ArrayList<String>()  ,  ans);
        return ans;

    }
    private void travel(TreeNode root , ArrayList<String> candidate , List<String>  ans ){
        if(root==null){
            return;
        }
        candidate.add(Integer.toString(root.val));
        if(root.left!=null){
            travel(root.left , candidate , ans);
        }
        if(root.right!=null){
            travel(root.right , candidate , ans);
        }
        if(root.left==null && root.right==null){
            ans.add(String.join("->"  , candidate));
        }
        candidate.remove(candidate.size()-1);

    }

}
