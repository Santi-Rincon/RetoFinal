package co.edu.uptc.model;

import javax.swing.JOptionPane;

public class Administrador extends Usuario {
    
    public Administrador(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
    public void registrarParqueadero(String nombre, String direccion, int totalEspacios, Horario[] horario) {
        Parqueadero parqueadero = new Parqueadero(nombre, direccion, totalEspacios, horario);
        JOptionPane.showMessageDialog(null, "Parqueadero registrado: " + nombre);
    }

    public void crearRecepcionista(String usuario, String contraseña, String nombres, String apellidos) {
        Usuario recepcionista = new Recepcionista(usuario, contraseña, nombres, apellidos);
        JOptionPane.showMessageDialog(null, "Recepcionista registrado: " + recepcionista.getUsuario());
    }

    public void cambiarCredencialesRecepcionista(String usuario, String nuevaContraseña) {
        JOptionPane.showMessageDialog(null, "Credenciales cambiadas");
    }


}
