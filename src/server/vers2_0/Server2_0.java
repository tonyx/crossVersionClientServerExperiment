package server.vers2_0;

import client.vers2_0.User2_0;
import server.vers1_0.Server1_0;

/**
 * Created by Tonyx on 09/05/2014.
 */
public class Server2_0 extends Server1_0 {
    public String authenticationToken(User2_0 user2_0) {
        if (super.validUser(user2_0) &&  validFingerPrint(user2_0.getFingerPrint()))
            return token();
        else return INVALID_TOKEN;
    }

    private boolean validFingerPrint(String fingerPrint) {
        return "validFingerPrint".equals(fingerPrint);
    }

    @Override
    public String only1_0Functionality() {
        throw new RuntimeException("this functionality is not available anymore");
    }

    public String only2_0Functionality() {
        return "this function substitutes the previous only1_0Functionality";
    }
}
