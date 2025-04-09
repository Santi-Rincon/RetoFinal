package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReceptionistMenu extends JFrame {

    public ReceptionistMenu() {
        super("Menú Principal Recepcionista");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    
        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(0, 25)); // Aumenta la altura del menú (por defecto es como 25)
    
        JMenu menuIngreso = new JMenu("Vehículo");
        JMenuItem ingresarVehiculo = new JMenuItem("Ingresar Vehículo");
        JMenuItem salirVehiculo = new JMenuItem("Salida Vehículo");
        menuIngreso.add(ingresarVehiculo);
        menuIngreso.add(salirVehiculo);


        JMenu menuEspacios = new JMenu("Espacios Disponibles");
        JMenuItem verEspacios = new JMenuItem("Ver Espacios Disponibles");
        menuEspacios.add(verEspacios);

        JMenu menuCerrar = new JMenu("Cuenta");
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesión");
        menuCerrar.add(cerrarSesion);
    

        Font menuFont = new Font("Arial", Font.BOLD, 14);
        menuIngreso.setFont(menuFont);
        menuEspacios.setFont(menuFont);
        menuCerrar.setFont(menuFont);
        ingresarVehiculo.setFont(menuFont);
        salirVehiculo.setFont(menuFont);
        verEspacios.setFont(menuFont);
        cerrarSesion.setFont(menuFont);
    
        menuBar.add(menuIngreso);
        menuBar.add(menuEspacios);
        menuBar.add(menuCerrar);
    
        setJMenuBar(menuBar);
    
        // Panel central con mensaje
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
    
        JLabel label = new JLabel("Seleccione una opción en el menú", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label, gbc);
    
        add(panel, BorderLayout.CENTER);
        setVisible(true);


        ingresarVehiculo.addActionListener(e -> {
            dispose();
            new VehicularEntry();
        });

        salirVehiculo.addActionListener(e -> {
            dispose();
            new VehicularExit();
        });

        verEspacios.addActionListener(e -> {
            dispose();
            new AvailableSpaces(); 
        });


        cerrarSesion.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Cerrando sesión...");
            dispose();
            new LogOut(); // Cierra el menú del admin
            
        });
    }
}
 
