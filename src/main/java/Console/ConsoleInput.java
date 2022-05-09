package Console;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner userInput = new Scanner(System.in);

    public String input(String message) {
        System.out.println(message);
        return userInput.nextLine();
    }

    public void setUserInput(Scanner userInput){
        this.userInput = userInput;
    }

}
