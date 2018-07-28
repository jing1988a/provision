//implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//        Calling next() will return the next smallest number in the BST.
//
//        Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
//
//        Credits:
//        Special thanks to @ts for adding this problem and creating all test cases.

import java.util.ArrayList;
import java.util.List;

public class BSTIterator173 {
    List<Integer> roots=new ArrayList<>();
    int curIdx=0;
    int totalLen;
    public BSTIterator173(TreeNode root) {
        inorder(root);
        totalLen=this.roots.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(this.totalLen==this.curIdx){return false;}
        return true;
    }

    /** @return the next smallest number */
    public int next(){
        // if(hasNext()==false){
        //     throw new Exception("end of nodes");
        // }
        int ans=this.roots.get(this.curIdx);
        this.curIdx++;
        return ans;
    }
    private void inorder(TreeNode root){

        if(root==null){
            return;
        }
        inorder(root.left);
        this.roots.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
