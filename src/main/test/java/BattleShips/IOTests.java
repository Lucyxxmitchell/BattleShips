package BattleShips;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IOTests {
    IO io = new IO();
    @Test
    void testGetDirection(){
        Scanner mockScanner = mock(Scanner.class);
        io.userInput.setUserInput(mockScanner);
        when(mockScanner.nextLine()).thenReturn("R");

        assertEquals(Direction.RIGHT, io.getDirection());

    }

    @Test
    void testValidDirection(){
        assertTrue(io.validDirection("R"));
    }

    @Test
    void testFailValidDirection(){
        assertFalse(io.validDirection("L"));
    }
    @Test
    void TestGetPointsY(){
        Scanner mockScanner = mock(Scanner.class);
        io.userInput.setUserInput(mockScanner);
        when(mockScanner.nextLine()).thenReturn("A3");

        int[] ExpectedPoints = {0,3};
        assertEquals(ExpectedPoints[0], io.getPoints()[0]);
    }
    @Test
    void TestGetPointsX(){
        Scanner mockScanner = mock(Scanner.class);
        io.userInput.setUserInput(mockScanner);
        when(mockScanner.nextLine()).thenReturn("A3");

        int[] ExpectedPoints = {0,3};
        assertEquals(ExpectedPoints[1], io.getPoints()[1]);
    }
    @Test
    void TestIsOnBoard(){
        assertTrue(io.isOnBoard(7));
    }
    @Test
    void TestFailIsOnBoard(){
        assertFalse(io.isOnBoard(20));
    }

    @Test
    void TestAis0Zis25Converter(){
        assertEquals(0, io.Ais0Zis25Converter('A'));
    }

}
