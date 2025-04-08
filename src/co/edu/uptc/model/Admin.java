package co.edu.uptc.model;

import javax.swing.JOptionPane;

public class Admin extends User {
    
    public Admin(){
    }
    
    public Admin(String user, String password) {
        super(user, password);
    }
    
    public void registrarParqueadero(String nombre, String direccion, int totalEspacios, Schedule[] horario) {
        Parking parking = new Parking(nombre, direccion, totalEspacios, horario);
        JOptionPane.showMessageDialog(null, "Parqueadero registrado: " + nombre);
    }

    public void crearRecepcionista(String usuario, String nombres, String apellidos, String telofono, String direccion,String email, String contraseña) {
        User recepcionist = new Recepcionist(usuario,nombres, apellidos, telofono, direccion, email, contraseña);
        JOptionPane.showMessageDialog(null, "Recepcionista registrado: " + recepcionist.getUsername());
    }

    public void cambiarCredencialesRecepcionista(String usuario, String nuevaContraseña) {
        JOptionPane.showMessageDialog(null, "Credenciales cambiadas");
    }


}
