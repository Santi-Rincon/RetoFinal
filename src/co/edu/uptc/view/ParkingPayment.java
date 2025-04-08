package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ParkingPayment extends JFrame {

    public ParkingPayment() {
        super("Pago de Parking");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Reducido el espacio vertical
        gbc.fill = GridBagConstraints.BOTH;

        JLabel titleLabel = new JLabel("Valor Del Servicio", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        panel.add(titleLabel, gbc);

        JLabel subtitLabel = new JLabel("$$$", SwingConstants.CENTER);
        subtitLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0.05;
        panel.add(subtitLabel, gbc);

        JPanel valorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JLabel valorLabel = new JLabel("Valor Recibido:");
        JTextField valorField = new JTextField(15);
        valorField.setPreferredSize(new Dimension(150, 25));
        valorPanel.add(valorLabel);
        valorPanel.add(valorField);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(valorPanel, gbc);

        // ⚠️ JLabel oculto inicialmente para mostrar "Valor a devolver"
        JLabel devolutionLabel = new JLabel("Valor a devolver: $0.00", SwingConstants.CENTER);
        devolutionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        devolutionLabel.setVisible(false); // Oculto inicialmente

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(devolutionLabel, gbc);

        JPanel devolutionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton buttonDevolution = new JButton("Valor A Devolver");
        buttonDevolution.setBackground(Color.LIGHT_GRAY);

        devolutionPanel.add(buttonDevolution);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(devolutionPanel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton buttonPrint = new JButton("Imprimir");
        buttonPrint.setBackground(Color.LIGHT_GRAY);

        JButton buttonCancel = new JButton("Cancelar");
        buttonCancel.setBackground(Color.LIGHT_GRAY);  

        buttonPrint.addActionListener(e -> {
            Pane(); // <-- Aquí llamas al método que no estaba siendo ejecutado
        });


        buttonPanel.add(buttonPrint);
        buttonPanel.add(buttonCancel);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(buttonPanel, gbc);

        // 🎯 Acción del botón: mostrar el JLabel de devolución
        buttonDevolution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolutionLabel.setVisible(true);
            }
        });

        add(panel);
        setVisible(true);
    }

     public void Pane() {
        // Panel principal con diseño vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Alert", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);

        JLabel messageLabel = new JLabel("Imprimiendo...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(10));

        Object[] options = {
            createButton("Aceptar"),
            createButton("Cancelar")
        };

        int result = JOptionPane.showOptionDialog(
                this,  // usar `this` para centrarlo en el frame actual
                panel,
                "", // Título del cuadro
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (result == 0) {
            System.out.println("Aceptar presionado");
        } else if (result == 1) {
            System.out.println("Cancelar presionado");
        }
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(Color.LIGHT_GRAY);
        return button;
    }

}
