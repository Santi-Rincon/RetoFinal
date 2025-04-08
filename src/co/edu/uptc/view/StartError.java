package co.edu.uptc.view;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

public class StartError extends JFrame {

    public StartError() {
       
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setSize(800, 600);

        JLabel titleLabel = new JLabel("Error", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);

        JLabel messageLabel = new JLabel("Valida Nuevamente Tus Datos...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(10));

        // Crear botón de Reintentar
        JButton retryButton = createButton("Reintentar");

        // Mostrar el JOptionPane con el botón
        Object[] options = { retryButton };

        int result = JOptionPane.showOptionDialog(
                null, // sin JFrame
                panel,
                "", 
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (result == 0) {
            System.out.println("Se presionó Reintentar");
        }
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(Color.LIGHT_GRAY);
        return button;
    }
}
