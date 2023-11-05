package cs2212.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning_Panel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Warning");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800); // Setting the size a bit bigger than the div to account for window decorations

        // Main panel with absolute layout to mimic the div layout in HTML
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(552, 720));
        panel.setBackground(new Color(0x1C1A33)); // Assuming gray-800 is close to #1C1A33

        // Cancel button
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(50, 541, 452, 67);
        btnCancel.setBackground(new Color(0xE328AF)); // Assuming pink-500 is close to #E328AF
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Cairo", Font.BOLD, 36));
        btnCancel.setFocusPainted(false);
        btnCancel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the window
            }
        });

        panel.add(btnCancel);

        // Confirm button
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(55, 631, 452, 67);
        btnConfirm.setBackground(new Color(0x6316C1)); // Assuming violet-800 is close to #6316C1
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Cairo", Font.BOLD, 36));
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the window
            }
        });

        panel.add(btnConfirm);

        // Warning label
        JLabel lblWarning = new JLabel("Warning!", SwingConstants.CENTER);
        lblWarning.setBounds((600 - 192) / 2 - 24, 50, 192, 50); // Centered horizontally
        lblWarning.setForeground(Color.WHITE);
        lblWarning.setFont(new Font("Cairo", Font.BOLD, 38));
        panel.add(lblWarning);

        // Message panel 1
        JPanel messagePanel1 = new JPanel(null);
        messagePanel1.setBounds(50, 192, 452, 60);
        messagePanel1.setOpaque(false);

        // Text label for message 1
        JLabel lblMessage1 = new JLabel("You'll give up all your corrections !");
        lblMessage1.setBounds(40, 6, 392, 48);
        lblMessage1.setForeground(Color.WHITE);
        lblMessage1.setFont(new Font("Cairo", Font.BOLD, 22));
        messagePanel1.add(lblMessage1);

        panel.add(messagePanel1);

        // Background panel with border for message 1
        JPanel backgroundPanel1 = new JPanel();
        backgroundPanel1.setBounds(0, 0, 452, 60);
        backgroundPanel1.setBackground(new Color(0x1C1A33));
        backgroundPanel1.setBorder(BorderFactory.createLineBorder(new Color(0x6418C3), 2));
        messagePanel1.add(backgroundPanel1);



        // Message panel 2
        JPanel messagePanel2 = new JPanel(null);
        messagePanel2.setBounds(50, 292, 452, 60);
        messagePanel2.setOpaque(false);
        // Text label for message 2, using HTML to allow line breaks
        JLabel lblMessage2 = new JLabel("<html><div style='text-align: center;'>Are you sure you want to quit modifying and<br/>go back to the main page?</div></html>", SwingConstants.CENTER);
        lblMessage2.setBounds(40, 6, 392, 48);
        lblMessage2.setForeground(Color.WHITE);
        lblMessage2.setFont(new Font("Cairo", Font.BOLD, 18));
        messagePanel2.add(lblMessage2);

        panel.add(messagePanel2);

        // Background panel with border for message 2
        JPanel backgroundPanel2 = new JPanel();
        backgroundPanel2.setBounds(0, 0, 452, 60);
        backgroundPanel2.setBackground(new Color(0x1C1A33));
        backgroundPanel2.setBorder(BorderFactory.createLineBorder(new Color(0x6418C3), 2));
        messagePanel2.add(backgroundPanel2);

        // Text label for message 2, using HTML to allow line breaks
/*        JLabel lblMessage2 = new JLabel("<html>Are you sure you want to quit modifying and<br/>go back to the main page?</html>");
        lblMessage2.setBounds(40, 6, 392, 48);
        lblMessage2.setForeground(Color.WHITE);
        lblMessage2.setFont(new Font("Cairo", Font.BOLD, 18));
        messagePanel2.add(lblMessage2);*/

        panel.add(messagePanel2);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
