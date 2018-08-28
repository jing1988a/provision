package fb.easy;
//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//        Note:
//
//        Given target value is a floating point.
//        You are guaranteed to have only one unique value in the BST that is closest to the target.
//        Example:
//
//        Input: root = [4,2,5,1,3], target = 3.714286
//
//        4
//        / \
//        2   5
//        / \
//        1   3
//
//        Output: 4
public class ClosestBinarySearchTreeValue270 {
    double distance=Double.POSITIVE_INFINITY;
    int ans;
    public int closestValue(TreeNode root, double target) {
        bSearch(root , target);
        return this.ans;
    }
    private void bSearch(TreeNode node , double target){
        if(node ==null){return;}
        double curDis=Math.abs(target-node.val);
        if(curDis==0){
            this.ans=node.val;
            this.distance=curDis;
            return;
        }//ha好像不需要这块吧。。
        if(curDis<this.distance){
            this.ans=node.val;
            this.distance=curDis;
        }
        if(node.val>target){
            bSearch(node.left , target);
        }else if(node.val<target){
            bSearch(node.right , target);
        }
    }
}
