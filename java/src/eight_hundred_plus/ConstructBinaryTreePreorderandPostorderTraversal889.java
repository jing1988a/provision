package eight_hundred_plus;



import java.util.HashMap;
import java.util.Map;

//Return any binary tree that matches the given preorder and postorder traversals.
//
//        Values in the traversals pre and post are distinct positive integers.
//
//
//
//        Example 1:
//
//        Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//        Output: [1,2,3,4,5,6,7]
//
//
//        Note:
//
//        1 <= pre.length == post.length <= 30
//        pre[] and post[] are both permutations of 1, 2, ..., pre.length.
//        It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
public class ConstructBinaryTreePreorderandPostorderTraversal889 {
    int curPreIdx=0;
    int l=0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.l=pre.length;
        if(this.l==0){
            return null;
        }
        Map<Integer , Integer> postValToIdx=new HashMap<>();
        for(int i=0 ; i <this.l ; i++){
            postValToIdx.put(post[i] , i);
        }

        return recur(pre , post , 0 , this.l-1 , postValToIdx);

    }
    private TreeNode recur(int[] pre , int[] post , int start , int end   , Map<Integer , Integer> postValToIdx){
        if(start>end || this.curPreIdx==this.l){
            return null;
        }
        TreeNode root=new TreeNode(pre[this.curPreIdx]);
        this.curPreIdx++;
        if(start==end){  // why it is start==end?????
            return root;
        }
        int leftRootVal=pre[this.curPreIdx];
        int leftRootPostIdx=postValToIdx.get(leftRootVal);
        root.left=recur(pre , post , start , leftRootPostIdx , postValToIdx);
        root.right=recur(pre , post , leftRootPostIdx+1 , end-1 , postValToIdx);
        return root;

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    static public void main(String[] args){
        ConstructBinaryTreePreorderandPostorderTraversal889 test=new ConstructBinaryTreePreorderandPostorderTraversal889();
        int[] a={1,2,4,5,3,6,7};
        int[] b={4,5,2,6,7,3,1};
        test.constructFromPrePost(a , b);
    }
}
