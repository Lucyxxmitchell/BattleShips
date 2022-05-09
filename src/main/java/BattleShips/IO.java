package BattleShips;
import Console.ConsoleInput;

public class IO {
    public final static char[] ALPHA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static ConsoleInput userInput = new ConsoleInput();

    public static void displayInstructions(){
        System.out.println("Now it's time to place your ships");
        System.out.println("You will place 5 ships, all will be 3 pegs in length.");
        System.out.println("First you will be asked to enter the starting co-ordinates of your ship. Enter the letter then the number like this: B3 ");
        System.out.println("Then you will be asked for the direction of your ships, Enter D for down and R for right.");
    }

    public static Direction getDirection() {
        boolean validDirection = false;
        String direction = null;
        String message = "Enter direction:";
        while (!validDirection) {
            direction = userInput.input(message);
            validDirection = validDirection(direction);
            message = "Invalid direction, Please re-enter";
        }

        return (direction.equals("R")) ? Direction.RIGHT : Direction.DOWN;
    }

    static boolean validDirection(String direction) {
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

            String coordinates = userInput.input(message);
            yInteger = Ais0Zis25Converter(coordinates.charAt(0));
            xInteger = Character.getNumericValue(coordinates.charAt(1));

            validY = isOnBoard(yInteger);
            validX = isOnBoard(xInteger);
            message = "Point invalid. Re-enter";
        }

        validPoints[0] = yInteger;
        validPoints[1] = xInteger;
        return validPoints;
    }

    static boolean isOnBoard(int point) {
        return ((point >= 0) && (point <= 9));
    }

    static int Ais0Zis25Converter(char yLetter) {
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
