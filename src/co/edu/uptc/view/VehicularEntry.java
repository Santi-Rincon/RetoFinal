package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VehicularEntry extends JFrame {
    private static int numeroRecibo = 1; 
    public VehicularEntry() {
        super("Ingreso de Vehículo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Título
        JLabel titleLabel = new JLabel("Ingreso Vehicular", SwingConstants.CENTER);
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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(Color.LIGHT_GRAY);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.LIGHT_GRAY);

        

        btnAceptar.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            dispose();
            new GenerateTicket(placaField.getText().toUpperCase(), numeroRecibo);
            numeroRecibo++;

        });

        btnCancelar.addActionListener(e -> {
            JOptionPane.getRootFrame().dispose();
            dispose();
            new ReceptionistMenu();
        });


        buttonPanel.add(btnAceptar);
        buttonPanel.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(buttonPanel, gbc);

        add(panel);
        setVisible(true);
    }
}
