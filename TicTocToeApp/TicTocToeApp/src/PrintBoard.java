public class PrintBoard {

    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                board[row][col] = ' ';
                System.out.print(board[row][col]+ " | ");
            }
            System.out.println();
        }
    }
}
