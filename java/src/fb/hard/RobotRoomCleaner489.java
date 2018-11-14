package fb.hard;//Given a robot cleaner in a room modeled as a grid.
//
//        Each cell in the grid can be empty or blocked.
//
//        The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
//
//        When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
//
//        Design an algorithm to clean the entire room using only the 4 given APIs shown below.
//
//interface Robot {
//    // returns true if next cell is open and robot moves into the cell.
//    // returns false if next cell is obstacle and robot stays on the current cell.
//    boolean move();
//
//    // Robot will stay on the same cell after calling turnLeft/turnRight.
//    // Each turn will be 90 degrees.
//    void turnLeft();
//    void turnRight();
//
//    // Clean the current cell.
//    void clean();
//}
//Example:
//
//        Input:
//        room = [
//        [1,1,1,1,1,0,1,1],
//        [1,1,1,1,1,0,1,1],
//        [1,0,1,1,1,1,1,1],
//        [0,0,0,1,0,0,0,0],
//        [1,1,1,1,1,1,1,1]
//        ],
//        row = 1,
//        col = 3
//
//        Explanation:
//        All grids in the room are marked by either 0 or 1.
//        0 means the cell is blocked, while 1 means the cell is accessible.
//        The robot initially starts at the position of row=1, col=3.
//        From the top left corner, its position is one row below and three columns right.
//        Notes:
//
//        The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
//        The robot's initial position will always be in an accessible cell.
//        The initial direction of the robot will be facing up.
//        All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
//        Assume all four edges of the grid are all surrounded by wall.


import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner489 {
    public void cleanRoom(Robot robot) {
        int[][] directions={{-1 , 0} , {0 , 1} ,{1 , 0} , {0 , -1} };
        Set<Pair<Integer , Integer>> visited=new HashSet<>();
        dfs(new Integer[] {0 , 0} , visited , 0  , directions, robot);
    }
    private void dfs(Integer[] loc , Set<Pair<Integer , Integer>> visited , int d , int[][] directions , Robot robot){
        robot.clean();
        visited.add(new Pair<>(loc[0] , loc[1]));
        Integer[] newLoc=new Integer[2];
        for(int i=0 ; i<4; i++){
            if(robot.move()) {
                newLoc[0] = loc[0] + directions[d][0];
                newLoc[1] = loc[1] + directions[d][1];
                Pair<Integer , Integer> newP=new Pair<>(newLoc[0] , newLoc[1]);
                if (!visited.contains(newP)) {
                    dfs(newLoc, visited, d, directions, robot);
                }
                goBack(robot);
            }
            robot.turnRight();
            d=(d+1)%4;
        }

    }
    private void goBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }




    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }





    // JAVA 是真他妈的蠢， 没有tuple    integer[] 不能直接放在SET里因为 不是用value  hash 的 估计使用 内存ID HASH 的。。。  [1  ,2] 和    [1 , 2] 是一样的  要自己想办法 override  hashcode  或者  自己把它 serialize 一下 ，  真滴蠢！！！！！！！！
}
