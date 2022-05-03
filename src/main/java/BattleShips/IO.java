package BattleShips;

import Console.ConsoleInput;

import java.util.Scanner;

public class IO {
    public final static char[] ALPHA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public static Direction getDirection() {
        boolean validDirection = false;
        String direction = null;
        String message = "Enter direction:";
        while (!validDirection) {
            direction = ConsoleInput.input(message);
            validDirection = validDirection(direction);
            message = "Invalid direction, Please re-enter";
        }

        return (direction.equals("R")) ? Direction.RIGHT : Direction.DOWN;
    }

    private static boolean validDirection(String direction) {
        return direction.equals("R") || direction.equals("D");
    }


    public static int[] getPoints() {
        boolean validY = false;
        boolean validX = false;
        int[] validPoints = new int[2];
        int yInteger = 0;
        int xInteger = 0;

        String message = "Enter starting co-ordinates:";
        while (!validY || !validX) {
            System.out.println(message);

            String coordinates = ConsoleInput.input(message);
            yInteger = A1Z26Converter(coordinates.charAt(0));
            xInteger = Character.getNumericValue(coordinates.charAt(1));

            validY = isOnBoard(yInteger);
            validX = isOnBoard(xInteger);
            message = "Point invalid. Re-enter";
        }
        validPoints[0] = yInteger;
        validPoints[1] = xInteger;
        return validPoints;
    }

    private static boolean isOnBoard(int point) {
        return ((point >= 0) && (point <= 9));
    }


    private static int A1Z26Converter(char yLetter) {
        int yInteger = 0;
        int i;

        for (i = 0; i < ALPHA.length; i++) {
            if (ALPHA[i] == yLetter) {
                return i;
            }
        }
        return yInteger;
    }
}
