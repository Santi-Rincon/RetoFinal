package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpaceAlert  extends JFrame {

    public SpaceAlert() {
        super("Alerta de Espacio Disponible");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
    
        // Título centrado horizontalmente y pegado arriba
        JLabel titleLabel = new JLabel("Alerta", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);
    
        // Mensaje centrado totalmente
        JLabel warningLabel = new JLabel("Quedan menos de 5 espacios disponibles", SwingConstants.CENTER);
        warningLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPanel centerPanel = new JPanel(new GridBagLayout()); // Centrado completo
        centerPanel.add(warningLabel);
        panel.add(centerPanel, BorderLayout.CENTER);
    
        // Botones personalizados
        Object[] options = {
            createButton("Aceptar"),
            createButton("Cancelar")
        };
    
        int result = JOptionPane.showOptionDialog(
                this,
                panel,
                "", // sin título adicional en el JOptionPane
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
