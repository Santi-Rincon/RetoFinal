package co.edu.uptc.model;

import javax.swing.JOptionPane;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String user, String password) {
        super(user, password);
    }

    public void registerParking(String name, String address, int totalSpaces, Schedule[] schedule) {
        Parking parking = new Parking(name, address, totalSpaces, schedule);
        JOptionPane.showMessageDialog(null, "Parqueadero registrado: " + name);
    }

    public void createRecepcionist(String user, String name, String lastname, String phone, String address,
            String email, String password) {
        User recepcionist = new Recepcionist(user, name, lastname, phone, address, email, password);
        JOptionPane.showMessageDialog(null, "Recepcionista registrado: " + recepcionist.getUsername());
    }

    // En clase Admin.java
    public boolean changeRecepcionistCredentials(String username, String newPassword) {
        for (User user : User.getRegisteredUsers()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setPassword(newPassword);
                return true; // Modificación exitosa
            }
        }
        return false; // Usuario no encontrado
    }

}
