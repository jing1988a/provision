//Two elements of a binary search tree (BST) are swapped by mistake.
//
//        Recover the tree without changing its structure.
//
//        Example 1:
//
//        Input: [1,3,null,null,2]
//
//        1
//        /
//        3
//        \
//        2
//
//        Output: [3,1,null,null,2]
//
//        3
//        /
//        1
//        \
//        2
//        Example 2:
//
//        Input: [3,1,4,null,null,2]
//
//        3
//        / \
//        1   4
//        /
//        2
//
//        Output: [2,1,4,null,null,3]
//
//        2
//        / \
//        1   4
//        /
//        3
//        Follow up:
//
//        A solution using O(n) space is pretty straight forward.
//        Could you devise a constant space solution?


import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {

//    public void recoverTree(TreeNode root) {
//        List<TreeNode> inorderNodes=new ArrayList<>();
//        List<Integer> inordeVals=new ArrayList<>();
//        dfs(root  ,  inorderNodes , inordeVals);
//        inordeVals.sort((x , y)->x-y);
//        for(int i=0 ; i<inorderNodes.size();i++){
//            inorderNodes.get(i).val=inordeVals.get(i);
//        }
//    }
//    private void dfs(TreeNode node , List<TreeNode> inorderNodes , List<Integer> inorderVals){
//        if(node==null){
//            return;
//        }
//        dfs(node.left , inorderNodes , inorderVals);
//        inorderNodes.add(node);
//        inorderVals.add(node.val);
//        dfs(node.right , inorderNodes , inorderVals);
//
//
//    }



    //alow dubplicate??????

    TreeNode n1=null;
    TreeNode n2=null;
    TreeNode pre=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=this.n1.val;
        this.n1.val=this.n2.val;
        this.n2.val=temp;
    }

    private void inorder(TreeNode node){
        if(node==null){return;}
        inorder(node.left);
        if(this.pre!=null && this.pre.val>node.val){
            this.n2=node;
            if(this.n1==null){
                this.n1=this.pre;
            }
        }
        this.pre=node;
        inorder(node.right);
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
