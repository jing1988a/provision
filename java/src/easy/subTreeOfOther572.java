package easy;//
//Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
//
//        Example 1:
//        Given tree s:
//
//        3
//        / \
//        4   5
//        / \
//        1   2
//        Given tree t:
//        4
//        / \
//        1   2
//        Return true, because t has the same structure and node values with a subtree of s.
//        Example 2:
//        Given tree s:
//
//        3
//        / \
//        4   5
//        / \
//        1   2
//        /
//        0
//        Given tree t:
//        4
//        / \
//        1   2
//        Return false.


public class subTreeOfOther572 {
    boolean found=false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        recur(s , t );
        return this.found;
    }
    private void recur(TreeNode s , TreeNode  t ){
        if(found==true || s==null){return;}
        if(s.val==t.val){
            if(realCheck(s , t)==true){
                this.found=true;
                return;
            };

        }
        recur(s.left ,  t);
        recur(s.right , t);
    }
    private boolean realCheck(TreeNode s , TreeNode t){
        if(s==null && t==null){ return true; }
        if(s==null){ return false;}
        if(t==null){ return false;}
        if(s.val!=t.val){return false;}
        return realCheck(s.left , t.left) && realCheck(s.right , t.right);
    }
}
