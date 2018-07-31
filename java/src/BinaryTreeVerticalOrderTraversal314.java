
//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
//        If two nodes are in the same row and column, the order should be from left to right.
//
//        Examples 1:
//
//        Input: [3,9,20,null,null,15,7]
//
//        3
//        /\
//        /  \
//        9  20
//        /\
//        /  \
//        15   7
//
//        Output:
//
//        [
//        [9],
//        [3,15],
//        [20],
//        [7]
//        ]
//        Examples 2:
//
//        Input: [3,9,8,4,0,1,7]
//
//        3
//        /\
//        /  \
//        9   8
//        /\  /\
//        /  \/  \
//        4  01   7
//
//        Output:
//
//        [
//        [4],
//        [9],
//        [3,0,1],
//        [8],
//        [7]
//        ]
//        Examples 3:
//
//        Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
//
//        3
//        /\
//        /  \
//        9   8
//        /\  /\
//        /  \/  \
//        4  01   7
//        /\
//        /  \
//        5   2
//
//        Output:
//
//        [
//        [4],
//        [9,5],
//        [3,0,1],
//        [8,2],
//        [7]
//        ]


import java.util.*;

public class BinaryTreeVerticalOrderTraversal314 {
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        HashMap<Integer  , List<Integer>> orderVal=new HashMap<>();
//        dfs(root , 0 , orderVal);
//        Set<Integer> temp=orderVal.keySet();
//        Integer[] orders=temp.toArray(new Integer[0]);
//        Arrays.sort(orders);
//        List<List<Integer>> ans= new ArrayList<>();
//        for(int o:orders){
//            ans.add(orderVal.get(o));
//        }
//        return ans;
//    }
//    private void dfs(TreeNode node , int order , HashMap<Integer , List<Integer>> orderVal){
//        if(node==null){return;}
//        if(!orderVal.containsKey(order)){
//            List<Integer> temp= new ArrayList<>();
//            temp.add(node.val);
//            orderVal.put(order  , temp);
//        }else{
//            orderVal.get(order).add(node.val);
//        }
//        dfs(node.left , order-1 , orderVal);
//        dfs(node.right , order+1 , orderVal);
//    }
//    上面的 肯定 DFS 不能保证 高层的出现在低层的前面  所以只能用BFS， 很僵！！！！！


    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> orderVal = new HashMap<>();
        List<Vector> q=new ArrayList<>();
        if(root!=null){
            Vector temp=new Vector();
            temp.add(root);
            temp.add(1);
            q.add(temp);
        }
        while(!q.isEmpty()){
            List<Vector> p=new ArrayList<>();
            for(Vector v:q){
                TreeNode node=(TreeNode)v.get(0);
                int order=(int)v.get(1);
                if(!orderVal.containsKey(order)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(node.val);
                    orderVal.put(order , temp);
                }else{
                    orderVal.get(order).add(node.val);
                }

                if(node.left!=null){
                    Vector vt=new Vector();
                    vt.add(node.left);
                    vt.add(order-1);
                    p.add(vt);
                }
                if(node.right!=null){
                    Vector vt=new Vector();
                    vt.add(node.right);
                    vt.add(order+1);
                    p.add(vt);
                }
            }
            q=p;
        }


        Set<Integer> temp = orderVal.keySet();
        Integer[] orders = temp.toArray(new Integer[0]);
        Arrays.sort(orders);
        List<List<Integer>> ans = new ArrayList<>();
        for (int o : orders) {
            ans.add(orderVal.get(o));
        }
        return ans;
    }
}
