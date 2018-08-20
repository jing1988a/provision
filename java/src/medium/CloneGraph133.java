package medium;//public class Solution {
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) {
//            return null;
//        }
//        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
//        HashMap<Integer, UndirectedGraphNode> dict = new HashMap<Integer, UndirectedGraphNode>();
//        dict.put(node.label, new_node);
//        // ArrayDeque<UndirectedGraphNode> q=new ArrayDeque<UndirectedGraphNode>();
//        Stack<UndirectedGraphNode> q = new Stack<UndirectedGraphNode>();
//        q.push(node);
//        // q.offer(node);
//        // q.offerLast(node);
//        while (q.size() != 0) {
//            UndirectedGraphNode cur_node = q.pop();
//            // q.remove();
//            // q.removeLast();
//            // q.pollLast();
//            for (Iterator<UndirectedGraphNode> iter = cur_node.neighbors.iterator(); iter.hasNext(); ) {
//                UndirectedGraphNode neighbor = iter.next();
//                if (!dict.containsKey(neighbor.label)) {
//                    dict.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
//                    q.push(neighbor);
//                }
//                dict.get(cur_node.label).neighbors.add(dict.get(neighbor.label));
//            }
//        }
//        return new_node;
//
//    }
//}


//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//        OJ's undirected graph serialization:
//        Nodes are labeled uniquely.
//
//        We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//        As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//        The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//        First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//        Second node is labeled as 1. Connect node 1 to node 2.
//        Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//        Visually, the graph looks like the following:
//
//        1
//        / \
//        /   \
//        0 --- 2
//        / \
//        \_/


import java.util.*;

public class CloneGraph133 {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }



    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){return null;}
        UndirectedGraphNode cloneRoot=new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode , UndirectedGraphNode> orignToClone=new HashMap<>();
        orignToClone.put(node , cloneRoot);
//    Queue                   |  Offer   | Peak |   Poll   | Remove | Size | Data Structure
//    ------------------------|----------|------|----------|--------|------|---------------
//    LinkedList              | O(1)     | O(1) | O(1)     |  O(1)  | O(1) |  Linked List
//    ArrayDequeue            | O(1)     | O(1) | O(1)     |  O(n)  | O(1) |  Array
//        Deque<UndirectedGraphNode> q=new ArrayDeque<>();
        Deque<UndirectedGraphNode> q=new LinkedList<>(); // 其实不用deque  stack也行啊 ， 就是个dfs 嘛
        q.add(node);
        while(!q.isEmpty()){
            UndirectedGraphNode cur=q.removeFirst();
            for(UndirectedGraphNode  n:  cur.neighbors){
                if(!orignToClone.containsKey(n)){
                    orignToClone.put(n , new UndirectedGraphNode(n.label));
                    q.add(n);
                }
                orignToClone.get(cur).neighbors.add(orignToClone.get(n));

            }

        }
        return cloneRoot;
    }

}
