package Login;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Login {
    @Test
    public void testLogin() {
        Scanner mockScanner = mock(Scanner.class);
        LogIn mockLogin = new LogIn();
        when(mockScanner.nextLine()).thenReturn("admin@admin.com").thenReturn("Password1");

        mockLogin.userInput.setUserInput(mockScanner);

        assertEquals(true, mockLogin.logIn());
    }

    @Test
    public void testFailedLogin() {
        Scanner mockScanner = mock(Scanner.class);
        LogIn mockLogin = new LogIn();
        when(mockScanner.nextLine())
                .thenReturn("admin@admin.com")
                .thenReturn("IncorrectPassword");

        mockLogin.userInput.setUserInput(mockScanner);

        assertEquals(false, mockLogin.logIn());
    }
}

