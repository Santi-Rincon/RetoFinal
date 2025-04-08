package co.edu.uptc.presenter;

import co.edu.uptc.model.Admin;
import co.edu.uptc.model.Parking;
import co.edu.uptc.model.User;
import javax.swing.JOptionPane;

public class Presenter {
    private static Presenter presenter;
    private User model;
    private Parking modelParking;

    private Presenter() {
        User admin = new Admin("admin", "admin");
        System.out.println("Usuario administrador creado en Presenter!");
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instacia presenter!");
        }
        return presenter;
    }

    public void addUser() {
        User admin = new Admin(JOptionPane.showInputDialog("Digite El Administrador"),
         JOptionPane.showInputDialog("Digite La Contraseña"));
        System.out.println("Usuario administrador creado en Presenter!");
    }

}
