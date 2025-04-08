package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class User {
    protected String user;
    protected String password;
    private List<User> usuariosRegistrados = new ArrayList<>();

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        usuariosRegistrados.add(this);
        showUsers();
    }

    public void showUsers() {
        StringBuilder sb = new StringBuilder("Usuarios registrados:\n");
        for (User us : usuariosRegistrados) {
            sb.append(us.user).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public String getUser() {
        return user;
    }

    public boolean iniciarSesion(String usuario, String contraseña) {
        for (User us : usuariosRegistrados) {
            if (us.user.equals(usuario) && us.password.equals(contraseña)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        return false;
    }

    public void cerrarSesion() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada para el usuario: " + user);
    }
    

}
