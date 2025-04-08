package co.edu.uptc.presenter;

import co.edu.uptc.model.Admin;
import co.edu.uptc.model.Parking;
import co.edu.uptc.model.User;

public class Presenter {
    private static Presenter presenter;
    private Parking modelParking;
    private Admin admin = new Admin();

    private Presenter() {
        // Crea un usuario administrador por defecto
        new Admin("1", "1");
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
        return User.login(username, password);
    }

    public String getUserType(String username) {
        return User.getUserType(username);
    }

    // Nuevo método que retorna true si el recepcionista fue creado con éxito
    public boolean crearRecepcionista(String usuario, String nombres, String apellidos, String telefono,
                                      String direccion, String email, String contraseña) {
        // Validar si ya existe el usuario antes de crearlo
      
                                        
        admin.crearRecepcionista(usuario, nombres, apellidos, telefono, direccion, email, contraseña);
        return true; // Creación exitosa
    }
}

