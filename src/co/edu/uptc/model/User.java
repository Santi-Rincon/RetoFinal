package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class User {
    protected String username;
    protected String password;
    private static List<User> registeredUsers = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        // Verificar si el usuario ya existe antes de registrarlo
        if (!userExists(username)) {
            registeredUsers.add(this);
        } else {
            JOptionPane.showMessageDialog(null, "The username '" + username + "' already exists.");
        }
    }

    
    public static boolean userExists(String username) {
        for (User u : registeredUsers) {
            if (u.username.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    
    public static String getUserType(String username) {
        for (User u : registeredUsers) {
            if (u.username.equalsIgnoreCase(username)) {
                return u.getClass().getSimpleName(); 
            }
        }
        return "Not found";
    }

    
    public static boolean login(String username, String password) {
        for (User u : registeredUsers) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    
    public void logout() {
        JOptionPane.showMessageDialog(null, "Session closed for user: " + username);
    }

    // Getters y setters

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getRegisteredUsers() {
        return this.registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
}
