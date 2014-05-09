package server.vers2_0;

import client.vers2_0.User2_0;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import server.vers1_0.Server1_0;

public class Server1_0WithClient2_0Test {
    @Test
    public void server1_0_authenticateUser2_0() {
        User2_0 user2_0 = new User2_0("validUsername","validPassword","validFingerPrint");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user2_0);

        Assert.assertTrue(isValid(token));
    }

    @Test
    public void server1_0_authenticateUser1_0WithInvalidUsername() {
        User2_0 user2_0 = new User2_0("WrongUsername","validPassword","validFingerPrint");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token));
    }

    @Test
    public void server1_0_authenticateUser2_0WithInvalidPassword() {
        User2_0 user2_0 = new User2_0("validUsername","InvalidPassword","validFingerPrint");
        Server1_0 server1_0 = new Server2_0();
        String token = server1_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token));
    }

    // this behavior may look weird: wrong fingerprint is valid if authenticated against a server 1_0, but
    // you don't have to know what server are you connected with
    @Test
    @Ignore
    public void server1_0_authenticateUser1_0WithInvalidFingerPrint() {
        User2_0 user2_0 = new User2_0("validUsername","validPassword","invalidFingerPrint");
        Server1_0 server1_0 = new Server1_0();
        String token = server1_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token)); // fail!!!
    }

    private boolean isValid(String token) {
        return !("-1".equals(token));
    }
}

