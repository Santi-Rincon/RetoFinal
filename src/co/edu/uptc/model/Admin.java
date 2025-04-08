package co.edu.uptc.model;

import javax.swing.JOptionPane;

public class Admin extends User {
    
    public Admin(){
    }
    
    public Admin(String user, String password) {
        super(user, password);
    }
    
    public void registerParking(String name, String address, int totalSpaces, Schedule[] schedule) {
        Parking parking = new Parking(name, address, totalSpaces, schedule);
        JOptionPane.showMessageDialog(null, "Parqueadero registrado: " + name);
    }

    public void createRecepcionist(String user, String name, String lastname, String phone, String address,String email, String password) {
        User recepcionist = new Recepcionist(user,name, lastname, phone, address, email, password);
        JOptionPane.showMessageDialog(null, "Recepcionista registrado: " + recepcionist.getUsername());
    }

    public void changeRecepcionistCredentials(String user, String newPassword) {
        JOptionPane.showMessageDialog(null, "Credenciales cambiadas");
    }


}
