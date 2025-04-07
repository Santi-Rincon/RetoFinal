package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class IngresoVehicular extends JFrame{

   public IngresoVehicular() {
        super("Ingreso de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 800, 600, 400);
       

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        
       
        JLabel titleLabel = new JLabel("Ingreso Vehicular", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        panel.add(titleLabel, gbc);
        
        
        JLabel placaLabel = new JLabel("Placa:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(placaLabel, gbc);
        
        
        JTextArea placaField = new JTextArea(1, 15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(placaField, gbc);
        
       
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(5, 5, 5, 5);
        
        JButton btnAceptar = new JButton("Aceptar");
        gbcBtn.gridx = 0;
        gbcBtn.gridy = 0;
        gbcBtn.weightx = 1.0;
        buttonPanel.add(btnAceptar, gbcBtn);
        
        JButton btnCancelar = new JButton("Cancelar");
        gbcBtn.gridx = 1;
        gbcBtn.gridy = 0;
        gbcBtn.weightx = 1.0;
        buttonPanel.add(btnCancelar, gbcBtn);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(buttonPanel, gbc);
        
        add(panel);
        setVisible(true);
    }

}
