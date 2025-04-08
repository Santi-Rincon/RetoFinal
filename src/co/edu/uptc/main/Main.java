package co.edu.uptc.main;

import co.edu.uptc.view.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Login login = new Login();
        LoginView loginView = new LoginView(login);
    }
}
