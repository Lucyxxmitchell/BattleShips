package BattleShips;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestBoard {
    @Test
    public void TestCheckFreeSpace(){
        Board testBoard = new Board();
        testBoard.board[1][1] = BoardStates.CONTAINS_SHIP;

        int[] points = {2,3};
        Direction direction = Direction.RIGHT;
        Assert.assertEquals(true, testBoard.checkFreeSpace(points, direction));
    }
    @Test
    public void TestFailCheckFreeSpaceTaken(){
        Board testBoard = new Board();
        testBoard.board[2][3] = BoardStates.CONTAINS_SHIP;

        int[] points = {2,3};
        Direction direction = Direction.RIGHT;
        Assert.assertEquals(false, testBoard.checkFreeSpace(points, direction));
    }
    @Test
    public void TestCheckFreeSpaceOffBoard(){
        Board testBoard = new Board();

        int[] points = {10,3};
        Direction direction = Direction.DOWN;
        Assert.assertEquals(false, testBoard.checkFreeSpace(points, direction));
    }
    @Test
    public void testPlace(){
        Board testBoard = new Board();
        int[] points = {1,1};
        Direction direction = Direction.RIGHT;

        testBoard.place(points, direction);
        boolean condition = true;
        for (int i = 0; i < 5; i++) {
            if (testBoard.board[points[0]][points[1] + i] != BoardStates.CONTAINS_SHIP){
                condition = false;
            }
        }
        Assert.assertEquals(true, condition);
    }

}
