package client.vers2_0;
import client.vers1_0.*;

public class User2_0 extends User1_0 {
    private String fingerPrint;

    public User2_0(String login, String password, String fingerPrint) {
        super(login, password);
        this.fingerPrint = fingerPrint;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }
}

