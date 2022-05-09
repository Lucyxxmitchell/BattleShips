package Login;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLogin {
    @Test
    public void testLogin() {
        Scanner mockScanner = mock(Scanner.class);
        LogIn loginMock = new LogIn();
        when(mockScanner.nextLine()).thenReturn("Lucy@iscool.com").thenReturn("Password1");

        loginMock.userInput.setUserInput(mockScanner);

        assertTrue(loginMock.logIn());
    }

    @Test
    public void testFailedLogin() {
        Scanner mockScanner = mock(Scanner.class);
        LogIn mockLogin = new LogIn();
        when(mockScanner.nextLine())
                .thenReturn("Lucy@iscool.com")
                .thenReturn("password");

        mockLogin.userInput.setUserInput(mockScanner);

        assertFalse(mockLogin.logIn());
    }
}