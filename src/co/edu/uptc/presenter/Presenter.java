package co.edu.uptc.presenter;

import co.edu.uptc.model.Admin;
import co.edu.uptc.model.Parking;
import co.edu.uptc.model.User;

public class Presenter {
    private static Presenter presenter;
    private Parking modelParking;

    private Presenter() {
        // Crea un usuario administrador por defecto
        new Admin("admin", "admin");
        System.out.println("Usuario administrador creado en Presenter!");
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instancia de Presenter!");
        }
        return presenter;
    }

    public boolean login(String username, String password) {
        return User.login(username, password); // Uso de método estático
    }

    public String getUserType(String username) {
        return User.getUserType(username); // Uso de método estático
    }
}
