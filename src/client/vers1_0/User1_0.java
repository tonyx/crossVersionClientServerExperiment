package client.vers1_0;

public class User1_0 {
    protected String login;
    protected String password;

    protected User1_0() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User1_0(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
