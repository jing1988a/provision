package medium;
//Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//        Example 1:
//
//        Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//        Output: true
//        Example 2:
//
//        Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//        Output: false
//        Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.


import java.util.HashMap;

public class GraphValidTree261 {

    public boolean validTree(int n, int[][] edges) {
        Union u = new Union();
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int pa = u.findP(a);
            int pb = u.findP(b);
            if (pa == pb) {
                return false;// cycle
            }
            u.unionP(pa, pb);
        }
        int p = u.findP(0);
        for (int i = 1; i < n; i++) {
            if (u.findP(i) != p) {
                return false; // not in same tree
            }
        }// we need this fucing for loop for the sutuation that there might be 2 or more connected part of the graph
        return true;
    }


}

class Union {
    HashMap<Integer, Integer> dict = new HashMap<>();

    public int findP(int v) {
        if (!this.dict.containsKey(v)) {
            this.dict.put(v, v);
        }

        if (this.dict.get(v) == v) {
            return v;
        }
        int p = findP(this.dict.get(v));
        this.dict.put(v, p);
        return p;
    }

    public void unionP(int pa, int pb) {
        if (pa == pb) {
            return;
        }
        this.dict.put(pa, pb);
    }
}
