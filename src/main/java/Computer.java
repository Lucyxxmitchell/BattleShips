import java.util.Random;
import java.util.Scanner;

public class Computer {
    private static Random rand = new Random();

    public static int[] getComputerPoints(){

        int[] points = new int[2];
        points[0] = rand.nextInt(10);
        points[1] = rand.nextInt(10);
        return points;
    }
    public static Direction getComputerDirection(){
        String[] directions = {"R", "D"};
        int select = rand.nextInt(directions.length);
        String compDirection = directions[select];
        return (compDirection.equals("R")) ? Direction.RIGHT : Direction.DOWN;
    }
}
