//A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
//        Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
//
//        If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
//
//        Note:
//
//        The number of stones is ≥ 2 and is < 1,100.
//        Each stone's position will be a non-negative integer < 231.
//        The first stone's position is always 0.
//        Example 1:
//
//        [0,1,3,5,6,8,12,17]
//
//        There are a total of 8 stones.
//        The first stone at the 0th unit, second stone at the 1st unit,
//        third stone at the 3rd unit, and so on...
//        The last stone at the 17th unit.
//
//        Return true. The frog can jump to the last stone by jumping
//        1 unit to the 2nd stone, then 2 units to the 3rd stone, then
//        2 units to the 4th stone, then 3 units to the 6th stone,
//        4 units to the 7th stone, and 5 units to the 8th stone.
//        Example 2:
//
//        [0,1,2,3,4,8,9,11]
//
//        Return false. There is no way to jump to the last stone as
//        the gap between the 5th and 6th stone is too large.
//

import javafx.util.Pair;

import java.util.*;

public class FrogJump403 {

    //recursve the runtime will be pretty bad, usually this true or false recursive question can be solved with dynamic programming
    boolean canVisit=false;
    public boolean canCross(int[] stones) {
        int l=stones.length;
        if(l<2){return true;}
        int target=stones[l-1];
        Set<Pair<Integer , Integer>> visited=new HashSet();
        // visited.add(new Pair(0 , 0));
        Set<Integer> stoneSet=new HashSet<>();
        for(int s:stones){
            stoneSet.add(s);
        }
        dfs(new Pair(0 , 0) , visited  , stoneSet , target);
        return this.canVisit;
    }
    private void dfs(Pair<Integer , Integer> cur , Set<Pair<Integer , Integer>> visited , Set<Integer> stoneSet , Integer target){
        visited.add(cur);
        int curLoc=cur.getKey();
        if(curLoc==target){this.canVisit=true;}
        if(this.canVisit){return;}

        int lastJump=cur.getValue();
        for(int i=-1 ; i<2 ; i++){
            int curJump=lastJump+i;
            Pair<Integer , Integer> nextState=new Pair(curLoc+curJump , curJump);
            if(curJump>0 && stoneSet.contains(curLoc+curJump)&& !visited.contains(nextState)  ){
                dfs(nextState ,  visited , stoneSet , target);
            }
        }

    }


    static public void main(String[] args){
        int[] stones={0,1,3,4,5,7,9,10,12};
        FrogJump403 test=new FrogJump403();
        boolean ans=test.canCross(stones);
        System.out.println(ans);
    }
}
