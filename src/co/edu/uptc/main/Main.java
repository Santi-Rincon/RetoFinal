package co.edu.uptc.main;

import co.edu.uptc.model.Parking;
import co.edu.uptc.model.Schedule;
import co.edu.uptc.view.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Schedule[] horarios = new Schedule[] {
                new Schedule("Lunes a Viernes", "08:00", "18:00"),
                new Schedule("Sábado", "08:00", "12:00"),
                new Schedule("Domingos y festivos", "08:00", "18:00")
        };
        Parking parking = Parking.getInstance("Mi Parqueadero", "Calle 123", 20, horarios);

        Login login = new Login();
    }
}
