package co.edu.uptc.view;

import java.awt.*;
import javax.swing.*;

public class VehicularExit extends JFrame {

    public VehicularExit() {
        super("Salida de Vehículo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
    
        // Título
        JLabel titleLabel = new JLabel("Salida Vehicular", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);
    
        // Campo de placa
        JPanel placaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JLabel placaLabel = new JLabel("Placa:");
        JTextField placaField = new JTextField(15);
        placaField.setPreferredSize(new Dimension(150, 25));
        placaPanel.add(placaLabel);
        placaPanel.add(placaField);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(placaPanel, gbc);
    
        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Espacio horizontal entre botones
    
        JButton showButton = new JButton("Mostrar Recibo");
        showButton.setBackground(Color.LIGHT_GRAY);
    
        JButton returButton = new JButton("Cancelar");
        returButton.setBackground(Color.LIGHT_GRAY);
    
        buttonPanel.add(showButton);
        buttonPanel.add(returButton);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(buttonPanel, gbc);
    
        add(panel);
        setVisible(true);
    }
}