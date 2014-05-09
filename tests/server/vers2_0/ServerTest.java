package server.vers2_0;

import client.vers2_0.User2_0;
import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void server2_0_autenticateUser2_0() {
        User2_0 utente2_0 = new User2_0("validUsername","validPassword","validFingerPrint");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(utente2_0);

        Assert.assertTrue(isValid(token));
    }

    @Test
    public void server2_0_autenticateUser2_0WithInvalidUsername() {
        User2_0 user2_0 = new User2_0("WrongUsername","validPassword","validFingerPrint");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token));
    }

    @Test
    public void server1_0_autenticateUser1_0WithInvalidPassword() {
        User2_0 user2_0 = new User2_0("validUsername","InvalidPassword","validFingerPrint");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token));
    }

    @Test
    public void server1_0_autenticateUser1_0WithInvalidFingerPrint() {
        User2_0 user2_0 = new User2_0("validUsername","validPassword","invalidFingerPrint");
        Server2_0 server2_0 = new Server2_0();
        String token = server2_0.authenticationToken(user2_0);

        Assert.assertFalse(isValid(token));
    }

    private boolean isValid(String token) {
        return !("-1".equals(token));
    }
}
