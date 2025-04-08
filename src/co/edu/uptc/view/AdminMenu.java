package co.edu.uptc.view;

import java.awt.BorderLayout;
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

public class AdminMenu extends JFrame {

    public AdminMenu() {
        super("Menú Principal Administrador");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear menús y submenús (JMenuItem)
        JMenu menuIngreso = new JMenu("Parqueadero");
        JMenuItem registrarParqueadero = new JMenuItem("Registrar Parqueadero");
        menuIngreso.add(registrarParqueadero);

        JMenu menuRecepcionista = new JMenu("Recepcionistas");
        JMenuItem crearRecepcionista = new JMenuItem("Crear Recepcionista");
        JMenuItem editarRecepcionista = new JMenuItem("Editar Recepcionista");
        menuRecepcionista.add(crearRecepcionista);
        menuRecepcionista.add(editarRecepcionista);

        JMenu generateReport = new JMenu("Reportes");
        JMenuItem generarReporte = new JMenuItem("Generar Reporte");
        generateReport.add(generarReporte);

        JMenu menuCerrar = new JMenu("Cuenta");
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesión");
        menuCerrar.add(cerrarSesion);

        // Agregar menús a la barra
        menuBar.add(menuIngreso);
        menuBar.add(menuRecepcionista);
        menuBar.add(generateReport);
        menuBar.add(menuCerrar);

        setJMenuBar(menuBar);

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

        
        registrarParqueadero.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Abrir ventana para registrar parqueadero"));

                crearRecepcionista.addActionListener(e -> {
                    new CreateReceptionist(); // Abre la ventana de creación
                    dispose(); // Cierra el menú del admin
                });
                
                

        editarRecepcionista.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Editar datos de recepcionista"));

        generarReporte.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Generando reporte..."));

        cerrarSesion.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Cerrando sesión...");
            dispose(); // Cierra el menú del admin
            new Login(); // Vuelve a mostrar el login
        });
    }
}
