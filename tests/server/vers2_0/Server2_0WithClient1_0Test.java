package server.vers2_0;

import client.vers1_0.User1_0;
import org.junit.Assert;
import org.junit.Test;

public class Server2_0WithClient1_0Test {
    @Test
    public void server2_0_authenticateUser1_0() {
        User1_0 user1_0 = new User1_0("validUsername","validPassword");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user1_0);
        Assert.assertTrue(isValid(token));
    }

    @Test
    public void server2_0_authenticateUser2_0WithInvalidUsername() {

        User1_0 user1_0 = new User1_0("WrongUsername","validPassword");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user1_0);
        Assert.assertFalse(isValid(token));
    }

    @Test
    public void server1_0_authenticateUser1_0WithInvalidPassword() {
        User1_0 user1_0 = new User1_0("validUsername","InvalidPassword");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user1_0);

        Assert.assertFalse(isValid(token));
    }

    @Test(expected=RuntimeException.class) // this behavior changes respect of the father class
    public void functionality1_0Test() {
        Server2_0 server2_0 = new Server2_0();
        Assert.assertTrue(server2_0.only1_0Functionality().contains("this function is available only in the version 1_0"));
    }

    @Test
    public void functionality2_0Test() {
        Server2_0 server2_0 = new Server2_0();
        Assert.assertTrue(server2_0.only2_0Functionality().contains("this function substitutes the previous only1_0Functionality"));
    }

    private boolean isValid(String token) {
        return !("-1".equals(token));
    }
}
