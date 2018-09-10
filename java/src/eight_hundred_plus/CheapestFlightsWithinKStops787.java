package eight_hundred_plus;

import javafx.util.Pair;

import java.util.*;

//There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
//
//        Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
//
//        Example 1:
//        Input:
//        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//        src = 0, dst = 2, k = 1
//        Output: 200
//        Explanation:
//        The graph looks like this:
//
//
//        The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
//        Example 2:
//        Input:
//        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//        src = 0, dst = 2, k = 0
//        Output: 500
//        Explanation:
//        The graph looks like this:
//
//
//        The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
//        Note:
//
//        The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
//        The size of flights will be in range [0, n * (n - 1) / 2].
//        The format of each flight will be (src, dst, price).
//        The price of each flight will be in the range [1, 10000].
//        k is in the range of [0, n - 1].
//        There will not be any duplicated flights or self cycles.
public class CheapestFlightsWithinKStops787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //bell-ford  . if you know it , then it is easy , if not , the it is hard
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        for (int i = 0; i < K + 1; i++) {
            int[] temp = costs.clone();
            for (int[] f : flights) {
                if (costs[f[0]] != Integer.MAX_VALUE) {
                    temp[f[1]] = Math.min(temp[f[1]], costs[f[0]] + f[2]);
                }
            }
            costs = temp;
        }
        if (costs[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return costs[dst];
        }
    }


    static public void main(String[] str){
        CheapestFlightsWithinKStops787 test=new CheapestFlightsWithinKStops787();
        int n=3;
        int[][] flights={{0 , 1 , 100} , {1 , 2 , 100} , {0 , 2 , 500}};
        int start=0;
        int end=2;
        int k=1;
        test.findCheapestPrice(n , flights , start ,end , k);

    }

//        Input:
//        3
//                [[0,1,100],[1,2,100],[0,2,500]]
//        0
//        2
//        0
//        Output:
//        200
//        Expected:
//        500



//    int ans=Integer.MAX_VALUE;
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        //    1.dfs or bfs , do k times
//        Map<Integer , List<Pair<Integer , Integer>>> graph=format(flights);
//        int[] curDis=new int[n];
//        for(int i=1 ; i<n ; i++){
//            curDis[i]=Integer.MAX_VALUE;
//        }
//        if(!graph.containsKey(src)){return -1;}
//        dfs(graph , src , dst , K+1 , 0 , curDis);
//        if(this.ans==Integer.MAX_VALUE){
//            return -1;
//        }else{
//            return this.ans;
//        }
//    }
//    private HashMap<Integer , List<Pair<Integer , Integer>>>format(int[][] flights){
//        HashMap<Integer , List<Pair<Integer , Integer>>> ans=new HashMap<>();
//        for(int i=0 ; i<flights.length; i++ ){
//            if(!ans.containsKey(flights[i][0])){
//                List<Pair<Integer , Integer>> temp=new ArrayList<>();
//                Pair<Integer , Integer> tempP=new Pair<>(flights[i][1] , flights[i][2]);
//                temp.add(tempP);
//                ans.put(flights[i][0] , temp);
//            }else{
//                Pair<Integer , Integer> tempP=new Pair<>(flights[i][1] , flights[i][2]);
//                ans.get(flights[i][0]).add(tempP);
//            }
//        }
//        return ans;
//    }
//    private void dfs(Map<Integer , List<Pair<Integer , Integer>>> graph , int src , int dst , int K , int dis , int[] curDis){
//        curDis[src]=dis;
//        if(src==dst){
//            this.ans=Math.min(this.ans , dis);
//            return ;
//        }
//        if(K==0){
//            return ;
//        }
//        for(Pair<Integer , Integer> n: graph.get(src)){
//            int node=n.getKey();
//            int price=n.getValue();
//            if(dis+price<curDis[node]){
//                dfs(graph , node , dst , K-1 ,dis+price , curDis );
//            }
//
//        }
//    }
//
//    static public void main(String[] str){
//        CheapestFlightsWithinKStops787 test=new CheapestFlightsWithinKStops787();
//        int n=3;
//        int[][] flights={{0 , 1 , 100} , {1 , 2 , 100} , {0 , 2 , 500}};
//        int start=0;
//        int end=1;
//
//    }
//    3
//            [[0,1,100],[1,2,100],[0,2,500]]
//            0
//            2
//            1
}
