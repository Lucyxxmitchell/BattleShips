package Console;

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner userInput = new Scanner(System.in);

    public static String input(String message) {
        System.out.println(message);
        return userInput.nextLine();
    }

}
