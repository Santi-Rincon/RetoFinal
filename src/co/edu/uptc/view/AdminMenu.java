package co.edu.uptc.view;

import java.awt.BorderLayout;
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

public class AdminMenu extends JFrame {

    public AdminMenu() {
        super("Menú Principal Administrador");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    
        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        // Elimina o ajusta esta línea ↓
        // menuBar.setPreferredSize(new Dimension(5, 20)); ❌
    
        // Menús
        JMenu menuIngreso = new JMenu("Registrar Parqueadero");
        JMenu menuSalida = new JMenu("Crear Recepcionista");
        JMenu menuEspacios = new JMenu("Editar Recepcionista");
        JMenu generateReport = new JMenu("Generar Reporte");
        JMenu menuCerrar = new JMenu("Cerrar Sesión");
    
        // Fuente más grande
        Font menuFont = new Font("Arial", Font.PLAIN, 16);
        menuIngreso.setFont(menuFont);
        menuSalida.setFont(menuFont);
        menuEspacios.setFont(menuFont);
        generateReport.setFont(menuFont);
        menuCerrar.setFont(menuFont);
    
        // Agregar menús a la barra
        menuBar.add(menuIngreso);
        menuBar.add(menuSalida);
        menuBar.add(menuEspacios);
        menuBar.add(generateReport);
        menuBar.add(menuCerrar);
    
        setJMenuBar(menuBar); // Usa directamente setJMenuBar
        // Ya no necesitas el JPanel extra para el menú
    
        // Panel central con mensaje
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(50, 10, 50, 10);
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
