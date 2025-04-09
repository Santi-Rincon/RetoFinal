package co.edu.uptc.model;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Recepcionist extends User {
    private String name;
    private String lastname;
    private String phone;
    private String address;   
    private String email;
    private String password;
    private String username;

    public Recepcionist() {}
    
    public Recepcionist(String user, String name, String lastname, String phone, String address,String email, String password) {
        super(user, password);
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address; 
        this.email = email; 

    }

    public String fullName(){
        return name + " " + lastname;
    }

    public void registerVehicleEntry(Parking parking, String plate, LocalDateTime entryTime) {
        Ticket ticket = new Ticket(entryTime, this.fullName(), plate);
        parking.addTicket(ticket);
    }

    public void registerVehicleDeparture(Parking parking, String plate, LocalDateTime departureTime, double payment) {
        Ticket ticket = new Ticket(departureTime, this.fullName(), plate);
        parking.checkOut(plate, departureTime, payment);
    }

    public void showAvailableSpaces(Parking parking) {
        int availableSpaces = parking.getEspaciosDisponibles();
        JOptionPane.showMessageDialog(null, "Espacios disponibles: " + availableSpaces);
        if (availableSpaces <= 5) {
            JOptionPane.showMessageDialog(null, "Quedan pocos espacios disponibles", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}