package backTracking;
public class nQueens {

    public static boolean isSafe(char[][]board,int row,int col){
        int n = board.length;
        //check rows
        for(int j=0;j<n;j++){
            if(board[row][j] == 'Q') return false;
        }
        //check columns
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q') return false;
        }

        //check north east
        int i =row;
        int j = col;
        while(i>=0 && j<n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        //check south east
        i =row;
        j = col;
        while(i<n && j<n){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        //check south west
        i =row;
        j = col;
        while(i<n && j>=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        //check north west
        i =row;
        j = col;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        return true;
    }

    public static void nqueens(char[][]board,int row){
        int n = board.length;
        if(row==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nqueens(board, row+1);
                board[row][j] = 'X';
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }
        nqueens(board,0);
    }
}
/*
 * Program Flow:
1.Initialization:
The chessboard is initialized with all cells marked as 'X'.

2.The nqueens function is called with the initial row set to 0.
nqueens 

3.Function Execution:
The nqueens function processes each row one by one.
For each row, it iterates through all columns and attempts to place a queen in a safe position.
If a safe position is found, the function proceeds to the next row recursively.
If the function reaches the last row (row == n), it prints the current configuration of the chessboard.

4.Backtracking:
If placing a queen in a particular position leads to a valid solution or a dead end is reached, the function backtracks by undoing the placement (setting 'X' again) and exploring other possibilities.

5.Print Solutions:
The program prints all valid solutions when the nqueens function reaches the last row.
Completion:

Once all possibilities are explored, the program completes execution.
 */
