package server.vers1_0;

import client.vers1_0.User1_0;
import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void server1_0_authenticateUser1_0WithValidCredentials() {
        User1_0 user1_0 = new User1_0("validUsername","validPassword");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user1_0);

        Assert.assertTrue(isValid(token));
    }

    @Test
    public void server1_0_authenticateUser1_0WithInvalidUsername() {
        User1_0 user1_0 = new User1_0("WrongUsername","validPassword");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user1_0);

        Assert.assertFalse(isValid(token));
    }

    @Test
    public void server1_0_authenticateUser1_0WithInvalidPassword() {
        User1_0 user1_0 = new User1_0("validUsername","InvalidPassword");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user1_0);

        Assert.assertFalse(isValid(token));
    }

    @Test
    public void functionality1_0Test() {
        Server1_0 server1_0 = new Server1_0();
        Assert.assertTrue(server1_0.only1_0Functionality().contains("this function is available only in the version 1_0"));
    }

    private boolean isValid(String token) {
        return !("-1".equals(token));
    }
}

