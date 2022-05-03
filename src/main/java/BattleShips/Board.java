package BattleShips;

import java.util.Arrays;

public class Board {
    public BoardStates[][] board;
    private Ship[] ships = new Ship[5];
    private int pointer = 0;

    public Board() {
        board = new BoardStates[10][10];
        for (BoardStates[] arr : board) {
            Arrays.fill(arr, BoardStates.EMPTY);
        }
    }

    public Boolean checkFreeSpace(int[] points, Direction direction) {
//        points; [0] = y; [1] = x
        boolean enoughSpace;
        if (direction.equals(Direction.RIGHT)) {
            enoughSpace = points[1] + 5 < 10;
            if (!enoughSpace) return false;

            for (int i = 0; i < 5; i++) {
                if (!board[points[0]][points[1] + i].equals(BoardStates.EMPTY)) {
                    return false;
                }
            }

        } else {
            enoughSpace = points[0] + 5 < 10;
            if (!enoughSpace) return false;

            for (int i = 0; i < 5; i++) {
                if (!board[points[0] + i][points[1]].equals(BoardStates.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void place(int[] points, Direction direction) {
        System.out.println("Done");
        if (direction.equals(Direction.RIGHT)) {

            for (int i = 0; i < 5; i++) {
                //System.out.println((points[1]+i));
                board[points[0]][points[1] + i] = BoardStates.CONTAINS_SHIP;
            }
        } else {

            for (int i = 0; i < 5; i++) {
                board[points[0] + i][points[1]] = BoardStates.CONTAINS_SHIP;
            }
        }
        ships[pointer] = new Ship(points[1], points[0], direction);
        pointer += 1;
    }


}
