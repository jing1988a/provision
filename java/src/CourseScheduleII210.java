//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        Example 1:
//
//        Input: 2, [[1,0]]
//        Output: [0,1]
//        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
//        course 0. So the correct course order is [0,1] .
//        Example 2:
//
//        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,1,2,3] or [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
//        courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//        Note:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.


;

import java.lang.reflect.Array;
import java.util.*;

public class CourseScheduleII210 {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> graph=buildgraph(numCourses , prerequisites);
//        Stack<Integer> stack=new Stack<>();
//        boolean[] visited=new boolean[numCourses];
//        Arrays.fill(visited , false);
//        for(int node=0 ; node<numCourses; node++){
//            if(!visited[node]){
//                dfs(graph , node , visited , stack );
//            }
//        }
//        List<Integer> ans=new ArrayList<>(stack);  // stack 转化为 arraylist
//        Collections.reverse(ans); // reverse arrayList
//        return ans.stream().mapToInt(x->x).toArray();  //应为要把 INTEGER 换成INT
//
//
//    }
//
//    private List<List<Integer>> buildgraph(int numCourses , int[][] prerequisites){
//        List<List<Integer>> graph=new ArrayList<>();
//        for(int i=0;i<numCourses;i++){
//            graph.add(new ArrayList<Integer>());
//        }
//        for(int[] pair:prerequisites){
//            int b=pair[0];
//            int a=pair[1];
//            graph.get(a).add(b);
//
//        }
//        return graph;
//
//    }
//
//    private void dfs(List<List<Integer>> graph , int node , boolean[] visited , Stack stack    ){
//        visited[node]=true;
//        for(Integer child:graph.get(node)){
//            if(!visited[child]){
//                dfs(graph , child , visited , stack);
//            }
//        }
//        stack.push(node);
//
//    }



//    上面那个只能用无环的情况

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Object> v=buildGraphAndDegree(numCourses , prerequisites);
            HashMap<Integer ,Integer> degrees=(HashMap<Integer, Integer>) v.get(1);
            List<List<Integer>> graph=(List<List<Integer>>)v.get(0);
            List<Integer> ans= new ArrayList<>();

            boolean found=true;
            HashSet<Integer> notVisited= new HashSet<>();
            for(int i=0 ; i<numCourses ; i++){
                notVisited.add(i);
            }
            while(!notVisited.isEmpty() && found){
                found=false;
                List<Integer> toRemove=new ArrayList<>();
                for(Integer node:degrees.keySet()){
                    if(!notVisited.contains(node)){continue;}
                    int degree=degrees.get(node);
                    if(degree==0){
                        found=true;
                        ans.add(node);
                        notVisited.remove(node);
                        //degrees.remove(node);
                        //
                        // Python 可以这么搞   java 会报错哦。。。
                        // Exception in thread "main" java.util.ConcurrentModificationException
                        //	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1399)
                        //	at java.util.HashMap$KeyIterator.next(HashMap.java:1423)
                        //	at Solution.findOrder(Solution.java:56)
                        //	at __DriverSolution__.__helper__(__Driver__.java:10)
                        //	at __Driver__.main(__Driver__.java:56)
                        for(Integer child:graph.get(node)){
                            degrees.put(child , degrees.get(child)-1);
                        }
                    }
                }
                if(!found){
                    // there is cycle
                    return new int[0];
                }

            }
            return ans.stream().mapToInt(x->x).toArray();
        }
        private List<Object> buildGraphAndDegree(int numCourses, int[][] prerequisites ){
            List<List<Integer>> graph=new ArrayList<>();
            HashMap<Integer , Integer> degrees=new HashMap<>();
            for(int i=0 ; i<numCourses ; i++){
                graph.add(new ArrayList<>());
                degrees.put(i , 0);
            }
            for(int[] pairs:prerequisites){
                int b=pairs[0];
                int a=pairs[1];
                graph.get(a).add(b);
                degrees.put(b , degrees.get(b)+1);
            }


            List<Object> ans =new ArrayList<>();
            ans.add(graph);
            ans.add(degrees);
            return ans;
        }


        static public void main(String args[]){
            CourseScheduleII210 test= new CourseScheduleII210();
            int n=2 ;
            int[][] prerequisites={{1, 0}};
            test.findOrder(n , prerequisites);
        }
}
