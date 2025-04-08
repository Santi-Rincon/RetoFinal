package co.edu.uptc.model;

import javax.swing.JOptionPane;

public class Admin extends User {
    
    public Admin(String user, String password) {
        super(user, password);
    }
    
    public void registrarParqueadero(String nombre, String direccion, int totalEspacios, Schedule[] horario) {
        Parking parking = new Parking(nombre, direccion, totalEspacios, horario);
        JOptionPane.showMessageDialog(null, "Parqueadero registrado: " + nombre);
    }

    public void crearRecepcionista(String usuario, String contraseña, String nombres, String apellidos) {
        User recepcionist = new Recepcionist(usuario, contraseña, nombres, apellidos);
        JOptionPane.showMessageDialog(null, "Recepcionista registrado: " + recepcionist.getUser());
    }

    public void cambiarCredencialesRecepcionista(String usuario, String nuevaContraseña) {
        JOptionPane.showMessageDialog(null, "Credenciales cambiadas");
    }


}
