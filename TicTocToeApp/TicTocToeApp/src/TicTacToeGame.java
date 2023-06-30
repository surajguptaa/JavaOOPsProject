import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while (!gameOver){
            PrintBoard.printBoard(board);
            System.out.print("Player "+player + " enter : ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col]==' '){
                //Placed the element
                board[row][col] = player;
                gameOver = HaveWon.haveWon(board, player);
                if(gameOver){
                    System.out.println("Player "+player + " has won : ");
                }else{
                    if(player=='X'){
                        player='O';
                    }
                    else{
                        player='X';
                    }
                }

            }else{
                System.out.println("Invalid move, try again!");
            }
        }
    }

}