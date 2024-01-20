package backTracking;
import java.util.*;

public class TwodMazePath {

    public static void TwodMazePath(int sr, int sc, int er, int ec, String s, boolean[][] isVisited) {
        if (sr > er || sc > ec || sr < 0 || sc < 0 || isVisited[sr][sc] == true) return;

        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }

        isVisited[sr][sc] = true;

        // Going down
        TwodMazePath(sr + 1, sc, er, ec, s + "D", isVisited);
        // Going right
        TwodMazePath(sr, sc + 1, er, ec, s + "R", isVisited);
        // Going left
        TwodMazePath(sr, sc - 1, er, ec, s + "L", isVisited);
        // Going up
        TwodMazePath(sr - 1, sc, er, ec, s + "U", isVisited);

        isVisited[sr][sc] = false;
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        boolean[][] isVisited = new boolean[rows][cols]; //by default it has false values in it.
        TwodMazePath(0, 0, rows - 1, cols - 1, "", isVisited);
    }
}
