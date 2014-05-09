package server.vers1_0;

import client.vers1_0.User1_0;

public class Server1_0 {
    public String INVALID_TOKEN="-1";
    public String authenticationToken(User1_0 user1_0) {
        if (validUser(user1_0))
            return token();
            else return INVALID_TOKEN;
    }

    protected boolean validUser(User1_0 user1_0) {
        return isLoginValid(user1_0.getLogin())&&isPasswordValid(user1_0.getPassword());
    }

    public String only1_0Functionality() {
        return "this function is available only in the version 1_0, an will not be available anymore in the next version of the server, but will be substituted with functionality2_0";
    }

    private boolean isLoginValid(String login) {
        return "validUsername".equals(login);
    }

    private boolean isPasswordValid(String password) {
        return "validPassword".equals(password);
    }

    protected String token() {
        return "1234567890ABCDE";
    }
}
