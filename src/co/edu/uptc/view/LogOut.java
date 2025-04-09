package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class LogOut extends JFrame {

    public LogOut() {
        super("Cerrar Sesión");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        mainPanel.setBackground(Color.WHITE);

        // Label 1
        JLabel label1 = new JLabel("Cantidad de vehículos ingresados");
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label1.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Label 2
        JLabel label2 = new JLabel("Cantidad de efectivo recibido");
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setBorder(new EmptyBorder(10, 0, 20, 0));

        // Botón
        JButton exitButton = new JButton("Salir");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(120, 40));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Acción del botón para regresar al Login
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra esta ventana
                new Login(); // Abre la ventana de Login
            }
        });

        // Agregar componentes
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(exitButton);

        add(mainPanel);
        setVisible(true);
    }
}
