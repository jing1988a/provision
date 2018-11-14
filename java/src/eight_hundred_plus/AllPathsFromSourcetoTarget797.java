package eight_hundred_plus;
//Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
//
//        The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
//
//        Example:
//        Input: [[1,2], [3], [3], []]
//        Output: [[0,1,3],[0,2,3]]
//        Explanation: The graph looks like this:
//        0--->1
//        |    |
//        v    v
//        2--->3
//        There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
//        Note:
//
//        The number of nodes in the graph will be in the range [2, 15].
//        You can print different paths in any order, but you should keep the order of nodes inside one path.
//        Seen this question in a real interview before?

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        int N=graph.length-1;
        dfs(0 , N ,graph , new ArrayList<Integer>(), ans);
        return ans;
    }
    private void dfs(int cur , int target , int[][] graph , ArrayList<Integer> candidate , List<List<Integer>> ans){
        candidate.add(cur);
        if(cur==target){
            ans.add(new ArrayList<>(candidate));
            candidate.remove(candidate.size()-1);
            return;
        }
        for(int nextNode:graph[cur]){
            dfs(nextNode , target , graph , candidate , ans);
        }
        candidate.remove(candidate.size()-1);

    }

}
