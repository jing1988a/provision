package fb.medium;//Given a binary tree
//
//        struct TreeLinkNode {
//        TreeLinkNode *left;
//        TreeLinkNode *right;
//        TreeLinkNode *next;
//        }
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.
//
//        Note:
//
//        You may only use constant extra space.
//        Recursive approach is fine, implicit stack space does not count as extra space for this problem.
//        Example:
//
//        Given the following binary tree,
//
//        1
//        /  \
//        2    3
//        / \    \
//        4   5    7
//        After calling your function, the tree should look like:
//
//        1 -> NULL
//        /  \
//        2 -> 3 -> NULL
//        / \    \
//        4-> 5 -> 7 -> NULL
//


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopulatingNextRightPointersEachNodeII117 {

    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> q=new ArrayList<>();
        if(root!=null){q.add(root);}
        while(!q.isEmpty()){
            List<TreeLinkNode> p=new ArrayList<>();
            int l=q.size();
            TreeLinkNode pre=null;
            for(int i=q.size()-1 ; i>-1 ; i--){
                TreeLinkNode cur=q.get(i);
                cur.next=pre;

                if(cur.right!=null){
                    p.add(cur.right);
                }
                if(cur.left!=null){
                    p.add(cur.left);
                }
                pre=cur;
            }
            Collections.reverse(p);
            q=p;
        }
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
