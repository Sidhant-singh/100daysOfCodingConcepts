package backTracking;
import java.util.*;
public class ratInDeadMazeFourDirections {

    public static void mazepath(int sr,int sc,int er,int ec,String s,int maze[][] , boolean[][]isVisited){
        if(sr<0 || sc<0 || sr>er || sc>ec) return;

        if(sr==er || sc == ec){
            System.out.println(s);
            return;
        }
        if(maze[sr][sc] == 0) return;
        if(isVisited[sr][sc] == true) return;

        //check
        isVisited[sr][sc] = true;
        
        // Going down
        mazepath(sr + 1, sc, er, ec, s + "D", maze,isVisited);
        // Going right
        mazepath(sr, sc + 1, er, ec, s + "R", maze,isVisited);
        // Going left
        mazepath(sr, sc - 1, er, ec, s + "L", maze,isVisited);
        // Going up
        mazepath(sr - 1, sc, er, ec, s + "U", maze,isVisited);

        isVisited[sr][sc] = false;


    }
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        int[][] maze = {{1, 0, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 1}
                        };
        boolean isVisited[][] = new boolean[rows][cols];
        mazepath(0, 0, rows - 1, cols - 1, "", maze,isVisited);
    }
}
