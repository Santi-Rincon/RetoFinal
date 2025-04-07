package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class MenuRecepcionista extends JFrame {

    public MenuRecepcionista() {
        super("Menú Principal Recepcionista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 800, 600, 400);
       
        JMenuBar menuBar = new JMenuBar();

        JMenu menuIngreso = new JMenu("Ingreso de Vehículo");
        JMenu menuSalida = new JMenu("Salida de Vehículo");
        JMenu menuEspacios = new JMenu("Espacios Disponibles");
        JMenu menuCerrar = new JMenu("Cerrar Sesión");

        menuBar.add(menuIngreso);
        menuBar.add(menuSalida);
        menuBar.add(menuEspacios);
        menuBar.add(menuCerrar);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        JLabel label = new JLabel("Seleccione una opción en el menú", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label, gbc);

        add(panel);
        setVisible(true);
    }

}
