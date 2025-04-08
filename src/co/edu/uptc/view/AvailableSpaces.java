package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AvailableSpaces extends JFrame {

    public AvailableSpaces() {
        super("Espacios Disponibles");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel general con BorderLayout
        JPanel generalPanel = new JPanel(new BorderLayout());

        // Panel para el mensaje
        JPanel labelPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Los Espacios Disponibles son:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        labelPanel.add(titleLabel, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.LIGHT_GRAY);
        btnAceptar.setFont(new Font("Arial", Font.PLAIN, 13));

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.setBackground(Color.LIGHT_GRAY);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 13));

        buttonPanel.add(btnAceptar);
        buttonPanel.add(btnVolver);

        // Agregar subpaneles al panel general
        generalPanel.add(labelPanel, BorderLayout.CENTER);
        generalPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar el panel general al JFrame
        add(generalPanel);
        setVisible(true);
    }
}