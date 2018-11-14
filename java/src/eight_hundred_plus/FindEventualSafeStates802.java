package eight_hundred_plus;
//In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
//
//        Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
//
//        Which nodes are eventually safe?  Return them as an array in sorted order.
//
//        The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
//
//        Example:
//        Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//        Output: [2,4,5,6]
//        Here is a diagram of the above graph.
//
//        Illustration of graph
//
//        Note:
//
//        graph will have length at most 10000.
//        The number of edges in the graph will not exceed 32000.
//        Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].

import java.util.*;

public class FindEventualSafeStates802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //topology sort reverse
        HashMap<Integer , List<Integer> > reverseGraph=new HashMap<>();
        HashMap<Integer , Integer> degree=new HashMap<>();
        Set<Integer> notVisited=new HashSet<>();
        Set<Integer> q=new HashSet<>();
//        {{1,2},{2,3},{5},{0},{5},{},{}}
        for(int i=0 ; i<graph.length ; i++){
            degree.put(i , 0);
            notVisited.add(i);
            for(int j=0 ; j <graph[i].length ; j++){
                if(reverseGraph.containsKey(graph[i][j])){
                    reverseGraph.get(graph[i][j]).add(i);

                }else{
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    reverseGraph.put(graph[i][j] , temp);
                }
                degree.put(i , degree.get(i)+1);
            }
            if(degree.get(i)==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            Set<Integer> p=new HashSet<>();
            for(int cur:q){
                ans.add(cur);
                notVisited.remove(cur);
                if(reverseGraph.containsKey(cur)) {
                    for (int child : reverseGraph.get(cur)) {
                        degree.put(child, degree.get(child) - 1);
                        if (degree.get(child) == 0) {
                            if (notVisited.contains(child)) {
                                p.add(child);
                            }

                        }
                    }
                }
            }
            q=p;
        }
        Collections.sort(ans);
        return ans;

    }

    static public void main(String[] str){
        FindEventualSafeStates802 test=new FindEventualSafeStates802();
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(test.eventualSafeNodes(graph));
    }
}
