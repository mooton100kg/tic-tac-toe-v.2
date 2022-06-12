import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private ArrayList<Integer> player1Po;
    private ArrayList<Integer> player2Po;
    private String player, winner;
    private boolean playing;

    public Game(String player){
        this.player = player;
        this.player1Po = new ArrayList<>();
        this.player2Po = new ArrayList<>();
        this.playing = true;
        this.winner = null;
    }

    public static void main(String[] args) {
        Game game = new Game("O");
        game.gameLoop();
    }

    private void gameLoop(){
        Scanner sc = new Scanner(System.in);
    
        printBoard(getEmptyBoard());
        
        while (playing){
    
            int newPo = sc.nextInt();
            System.out.println("");
            System.out.println("---------------------------");
            System.out.println("");
            String[][] board = setBorad(newPo, player, player1Po, player2Po);
            savePo(newPo);
            setPlayer();
            setWinner();
            printBoard(board);
            
        }
    
        System.out.println("WINNER: " + winner);
    }
    
    private void savePo(int newPo) {
        if (player.equals("O")){
            player1Po.add(newPo);
        }
        else if (player.equals("X")){
            player2Po.add(newPo);
        }
    }
    
    private void printBoard(String[][] board) {
        for (int j = 0; j < board.length; j++){
            for (int i = 0; i < board[j].length; i++){
                if (i == board[j].length - 1){
                    System.out.println(board[j][i]);
                }
                else {
                    System.out.print(board[j][i]);
                }
            }
        }
        if (playing != false){
            System.out.print("PLAYER: " + player + " > ");
        }
    }

    private void setPlayer(){
        if (player.equals("O")){
            player = "X";
        }
        else{
            player = "O";
        }
    }

    private void setWinner(){
        int[][] winCase = getWinCase();
        for (int[] c: winCase){
            if (player1Po.contains(c[0]) && player1Po.contains(c[1]) && player1Po.contains(c[2])){
                playing = false;
                winner = "O";
                return;
            }
            else if (player2Po.contains(c[0]) && player2Po.contains(c[1]) && player2Po.contains(c[2])){
                playing = false;
                winner = "X";
                return;
            }
        }

        if (player1Po.size() + player2Po.size() == 7){
            playing = false;
            winner = "tie";
        }
    }

    private int[][] getWinCase() {
        int[][] winCase = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {1,5,9},
            {3,5,7},
            {1,4,7},
            {2,5,8},
            {3,6,9}
        };
        return winCase;
    }
    private String[][] getEmptyBoard(){
        String[][] emptyBoard = {
            {" ", "|", " ", "|", " ", "     |     1|2|3"},
            {"-", "+", "-", "+", "-", "     |     -+-+-"},
            {" ", "|", " ", "|", " ", "     |     4|5|6"},
            {"-", "+", "-", "+", "-", "     |     -+-+-"},
            {" ", "|", " ", "|", " ", "     |     7|8|9"},
        };

        return emptyBoard;
    }

    private int[] convertPo(int po){
        int x = 0,y = 0;

        if (po == 1){
            y = 0;
            x = 0;
        }
        else if (po == 2){
            y = 0;
            x = 2;
        }
        else if (po == 3){
            y = 0;
            x = 4;
        }
        else if (po == 4){
            y = 2;
            x = 0;
        }
        else if (po == 5){
            y = 2;
            x = 2;
        }
        else if (po == 6){
            y = 2;
            x = 4;
        }
        else if (po == 7){
            y = 4;
            x = 0;
        }
        else if (po == 8){
            y = 4;
            x = 2;
        }
        else if (po == 9){
            y = 4;
            x = 4;
        }
        int[] index = new int[]{y,x};
        return index;
    }

    private String[][] setBorad(int newPo, String player, ArrayList<Integer> oldPo1, ArrayList<Integer> oldPo2){
        String[][] board = getEmptyBoard();

        int[] index = convertPo(newPo);
        board[index[0]][index[1]] = player;

        for (int i: oldPo1){
            index = convertPo(i);
            board[index[0]][index[1]] = "O";
        }

        for (int i: oldPo2){
            index = convertPo(i);
            board[index[0]][index[1]] = "X";
        }
        return board;
    }
}