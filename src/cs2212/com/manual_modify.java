package cs2212.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class manual_modify extends JFrame {

    public manual_modify() {
        setTitle("Manual modify");
        setSize(280, 345);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#FDFDFD"));

        // Main panel to mimic the outer div
        JPanel mainPanel = createPanel(0, 0, 280, 345, new Color(253, 253, 253));
        add(mainPanel);

        // Top text panel
        JPanel topTextPanel = createPanel(30, 20, 197, 69, Color.WHITE);
        mainPanel.add(topTextPanel);

        // Text for the top panel
        JLabel topTextLabel = createLabel("Manual Modify", new Font("Cairo", Font.BOLD, 24), Color.decode("#6418C3"));
        topTextLabel.setBounds(30, 12, 165, 43);
        topTextPanel.add(topTextLabel);

        // Input text panel
        JPanel inputTextPanel = createPanel(30, 115, 197, 69, Color.decode("#FFFFFF"));
        mainPanel.add(inputTextPanel);

        // Text field for the input panel with a placeholder
        JTextField inputTextField = new JTextField("Change to");
        inputTextField.setForeground(Color.GRAY);
        inputTextField.setBounds(30, 12, 165, 43);
        inputTextPanel.add(inputTextField);

        // Focus listener to clear the placeholder text when the text field gains focus
        inputTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputTextField.getText().equals("Change to")) {
                    inputTextField.setText("");
                    inputTextField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputTextField.getText().isEmpty()) {
                    inputTextField.setForeground(Color.GRAY);
                    inputTextField.setText("Change to");
                }
            }
        });

        // Confirm button
        JButton confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(60, 250, 165, 50);
        confirmbutton.setFont(new Font("Cairo", Font.BOLD, 18));
        confirmbutton.setForeground(Color.WHITE);
        confirmbutton.setBackground(new Color(0x6418C3));
        confirmbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window when the confirm button is clicked
            }
        });
        mainPanel.add(confirmbutton);

        // Set all components bounds
        topTextPanel.setBounds(30, 20, 197, 69);
        inputTextPanel.setBounds(30, 115, 197, 69);

        setVisible(true);
    }

    private JPanel createPanel(int x, int y, int width, int height, Color background) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);
        panel.setBackground(background);
        return panel;
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBounds(0, 0, 280, 80); // Make sure to set the bounds to match the parent panel size
        return label;
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new manual_modify();
            }
        });
    }
}
