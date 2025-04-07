package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {
    protected String usuario;
    protected String contraseña;
    private List<Usuario> usuariosRegistrados = new ArrayList<>();

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        usuariosRegistrados.add(this);
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean iniciarSesion(String usuario, String contraseña) {
        for (Usuario us : usuariosRegistrados) {
            if (us.usuario.equals(usuario) && us.contraseña.equals(contraseña)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        return false;
    }

    public void cerrarSesion() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada para el usuario: " + usuario);
    }
    

}
