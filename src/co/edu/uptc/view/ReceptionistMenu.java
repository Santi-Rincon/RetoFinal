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
    
        JMenu menuIngreso = new JMenu("Ingreso de Vehículo");
        JMenu menuSalida = new JMenu("Salida de Vehículo");
        JMenu menuEspacios = new JMenu("Espacios Disponibles");
        JMenu menuCerrar = new JMenu("Cerrar Sesión");
    
        // Puedes aumentar también la fuente de los ítems para que se vea más grande
        Font menuFont = new Font("Arial", Font.PLAIN, 16);
        menuIngreso.setFont(menuFont);
        menuSalida.setFont(menuFont);
        menuEspacios.setFont(menuFont);
        menuCerrar.setFont(menuFont);
    
        menuBar.add(menuIngreso);
        menuBar.add(menuSalida);
        menuBar.add(menuEspacios);
        menuBar.add(menuCerrar);
    
        // Panel contenedor del menú
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.NORTH);
    
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
    }
}
 
