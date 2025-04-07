package co.edu.uptc.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class LoginAdministrador extends JFrame {

    public LoginAdministrador() {
        super("Login Recepcionista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 800, 450, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

       
        JLabel titleLabel = new JLabel("Inicio de Sesión - Administrador", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(150, 60));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(titleLabel, gbc);

        
        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(userLabel, gbc);

        
        JTextArea userField = new JTextArea(2, 15);
        userField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(userField, gbc);

       
        JLabel passLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(passLabel, gbc);

        
        JTextArea passField = new JTextArea(2, 15);
        passField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(passField, gbc);

        add(panel);
        setVisible(true);
    }


}
