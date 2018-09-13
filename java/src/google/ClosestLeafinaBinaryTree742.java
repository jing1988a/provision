package google;

import java.util.*;

//Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
//
//        Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
//
//        In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
//
//        Example 1:
//
//        Input:
//        root = [1, 3, 2], k = 1
//        Diagram of binary tree:
//        1
//        / \
//        3   2
//
//        Output: 2 (or 3)
//
//        Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
//        Example 2:
//
//        Input:
//        root = [1], k = 1
//        Output: 1
//
//        Explanation: The nearest leaf node is the root node itself.
//        Example 3:
//
//        Input:
//        root = [1,2,3,4,null,null,null,5,null,6], k = 2
//        Diagram of binary tree:
//        1
//        / \
//        2   3
//        /
//        4
//        /
//        5
//        /
//        6
//
//        Output: 3
//        Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
//        Note:
//        root represents a binary tree with at least 1 node and at most 1000 nodes.
//        Every node has a unique node.val in range [1, 1000].
//        There exists some node in the given binary tree for which node.val == k.
public class ClosestLeafinaBinaryTree742 {
    TreeNode start;
    public int findClosestLeaf(TreeNode root, int k) {

        HashMap<TreeNode , List<TreeNode>> graph=generateGraph(root ,  k);

        List<TreeNode> q=new ArrayList<>();
        q.add(this.start);
        Set<TreeNode> visited=new HashSet<>();
        visited.add(this.start);

        while(!q.isEmpty()){
            List<TreeNode> p=new ArrayList<>();
            for(TreeNode cur:q){
                if(cur.left==null && cur.right==null){
                    return cur.val;
                }
                for(TreeNode next:graph.get(cur)){
                    if(!visited.contains(next)){
                        visited.add(next);
                        p.add(next);
                    }
                }
            }
            q=p;

        }
        return -1;

    }

    private HashMap<TreeNode , List<TreeNode>> generateGraph(TreeNode root  , int k){
        HashMap<TreeNode , List<TreeNode>> graph=new HashMap<>();

        if(root==null){

            return graph;
        }
        if(root.val==k){
            this.start=root;
        }
        dfs(root.left , root  , graph , k);
        dfs(root.right , root , graph , k);
        return graph;
    }

    private void dfs(TreeNode cur , TreeNode pre , HashMap<TreeNode , List<TreeNode>> graph , int k){
        if(cur==null){
            return;
        }
        if(cur.val==k){
            this.start=cur;
        }
        if(graph.containsKey(pre)){
            graph.get(pre).add(cur);
        }else{
            List<TreeNode> temp=new ArrayList<>();
            temp.add(cur);
            graph.put(pre , temp);
        }


        if(graph.containsKey(cur)){
            graph.get(cur).add(pre);
        }else{
            List<TreeNode> temp=new ArrayList<>();
            temp.add(pre);
            graph.put(cur , temp);
        }
        dfs(cur.left , cur , graph , k);
        dfs(cur.right , cur , graph , k);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
