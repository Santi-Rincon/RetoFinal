package co.edu.uptc.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Login extends JFrame {

    public Login() {
        super();
        JFrame frame = new JFrame("Login");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        // Panel superior (título)
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Bienvenido Al Sistema De Parking Uptc", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(0, 80));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Panel central que usará GridBagLayout para centrar verticalmente
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 1;
        centerGbc.gridy = 1;
        centerGbc.anchor = GridBagConstraints.CENTER;
        centerGbc.weighty = 1.5;

        // Panel del formulario (usuario y contraseña)
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(new JTextArea(2, 15), gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(new JTextArea(2, 15), gbc);

        // Añadir el formPanel centrado dentro del centerPanel
        centerPanel.add(formPanel, centerGbc);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con botón
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0)); // Margen superior e inferior
        
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFocusPainted(false);
        bottomPanel.add(loginButton);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Mostrar
        frame.setVisible(true);
    }


}
