package medium;//Input: [3,5,1,6,2,0,8,null,null,7,4]
//        Output: [2,7,4]
//        Explanation:
//
//
//
//        We return the node with value 2, colored in yellow in the diagram.
//        The nodes colored in blue are the deepest nodes of the tree.
//        The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
//        The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
//        Both the input and output have TreeNode type.


//public class SmallestSubtreeDeepestNodes865 {
//
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        if(root==null){return null;}
//        NodeAndHeight nodeAndHeight=dfs(root);
//        return nodeAndHeight.node;
//    }
//    private NodeAndHeight dfs(TreeNode root){
//        if(root==null){
//            return new NodeAndHeight(null , 0);
//        }
//        NodeAndHeight l=dfs(root.left);
//        NodeAndHeight r=dfs(root.right);
//        if(l.height>r.height){return new NodeAndHeight(l.node , l.height+1);}
//        if(l.height<r.height){return new NodeAndHeight(r.node , r.height+1);}
//        return new NodeAndHeight(root , l.height+1);
//    }
//
//}
//
//class NodeAndHeight{
//    TreeNode node;
//    int height;
//    NodeAndHeight(TreeNode root , int height){
//        this.node=root;
//        this.height=height;
//    }
//}
//
//


import java.util.Vector;

public class SmallestSubtreeDeepestNodes865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){return null;}
        Vector ans=dfs(root);
        return (TreeNode)ans.get(0);
    }
    private Vector dfs(TreeNode root){
        Vector ans=new Vector(2);
        if(root==null){

            ans.add(null);
            ans.add(0);
            return ans;
        }
        Vector l=dfs(root.left);
        Vector r=dfs(root.right);
        if((int)l.get(1)>(int)r.get(1)){
            ans.add(l.get(0));
            ans.add((int)l.get(1)+1);
            return ans;
        }
        if((int)r.get(1)>(int)l.get(1)){
            ans.add(r.get(0));
            ans.add((int)r.get(1)+1);
            return ans;
        }
        ans.add(root);
        ans.add((int)r.get(1)+1);
        return ans;
    }

}
