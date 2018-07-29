//Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
//
//        However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
//
//        You need to return the least number of intervals the CPU will take to finish all the given tasks.
//
//        Example 1:
//        Input: tasks = ["A","A","A","B","B","B"], n = 2
//        Output: 8
//        Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//        Note:
//        The number of tasks is in the range [1, 10000].
//        The integer n is in the range [0, 100].


import java.util.HashMap;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character , Integer> charCount=new HashMap<>();
        charCount=countChar(tasks);
        int maxFreq=getMaxFreq(charCount);
        int maxFreqCharCount=getMaxFreqCount(charCount , maxFreq);
        return Math.max(   (n+1)*(maxFreq-1)+maxFreqCharCount , tasks.length );
    }
    private  HashMap<Character , Integer> countChar(char[] tasks){
        HashMap<Character , Integer> ans=new HashMap<>();
        for(char c: tasks){
            if(ans.containsKey(c)){ans.put(c , ans.get(c)+1);}
            else{ans.put(c , 1);}
        }
        return ans;
    }
    private  int getMaxFreq(HashMap<Character , Integer> charCount ){
        int ans=0;
        for(int v :charCount.values()){
            ans=Math.max(ans , v);
        }
        return ans;
    }
    private int getMaxFreqCount(HashMap<Character , Integer> charCount ,     int maxFreq){
        int ans=0;
        for(int v :charCount.values()){
            if(v==maxFreq){
                ans++;
            }
        }
        return ans;
    }

}
