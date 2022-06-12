package main;

import java.util.ArrayList;

public class Board {
    public static String[][] getEmptyBoard(){
        String[][] emptyBoard = {
            {" ", "|", " ", "|", " ", "     |     1|2|3"},
            {"-", "+", "-", "+", "-", "     |     -+-+-"},
            {" ", "|", " ", "|", " ", "     |     4|5|6"},
            {"-", "+", "-", "+", "-", "     |     -+-+-"},
            {" ", "|", " ", "|", " ", "     |     7|8|9"},
        };

        return emptyBoard;
    }

    private static int[] convertPo(int po){
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

    public static String[][] setBorad(int newPo, String player, ArrayList<Integer> oldPo1, ArrayList<Integer> oldPo2){
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
