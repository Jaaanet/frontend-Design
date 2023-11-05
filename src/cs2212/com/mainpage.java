package cs2212.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainpage {
    // Class-level references to menu buttons to change their properties later
    private static JButton dashboardButton;
    private static JButton editDictionaryButton;
    private static JButton askHelpButton;
    private static JButton settingsButton;
    private static JPanel purpleIndicator;

    public static void main(String[] args) {
        // Initialize the main window with the title "UI from Image".
        JFrame frame = new JFrame("UI from Image");

        // Create a button with a light purple background and purple text labeled "Corrections Start".
        JButton correctionsButton = new JButton("Corrections Start");
        correctionsButton.setBounds(1024 - 250, 768 - 80 - 50, 200, 40);  // Position at the bottom right corner.
        correctionsButton.setBackground(Color.decode("#E8DFF2"));  // Set the background to light purple.
        correctionsButton.setForeground(Color.decode("#6418C3"));  // Set the text color to purple.
        correctionsButton.setFont(new Font("Cairo", Font.BOLD, 18));
        correctionsButton.setBorderPainted(true);  // Remove the default border.
        frame.add(correctionsButton);

        // Create a white multiline text area positioned at the bottom right corner of a gray area.
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(330, 80, 1024 - 330 - 50, 768 - 80 - 50 - 100);  // Position in the bottom right corner of the gray area.
        frame.add(scrollPane);

        // Set up the main window size and background color.
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#F3F3F3"));  // Set the background to gray.

        // Add the title text "Spell Checker".
        JLabel titleLabel = new JLabel("Spell Checker");
        titleLabel.setBounds(50, 10, 200, 30);
        titleLabel.setFont(new Font("Cairo", Font.BOLD, 24));
        frame.add(titleLabel);

        // Add a smaller text label "Main Menu".
        JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setBounds(50, 100, 150, 20);
        mainMenuLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        mainMenuLabel.setForeground(Color.decode("#C7C7C7"));  // Set to light gray color.
        frame.add(mainMenuLabel);

        // Create a purple indicator panel.
        purpleIndicator = new JPanel();
        purpleIndicator.setBackground(Color.decode("#6418C3"));
        purpleIndicator.setBounds(50, 140, 5, 40);
        frame.add(purpleIndicator);

        // Create a button listener to move the purple indicator bar when a button is clicked.
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton((JButton) e.getSource());
            }
        };

        // Create and add individual buttons for the menu items.
        dashboardButton = createMenuItem("Dashboard", "G:/javaswing-study/src/cs2212/com/dashboard(3030).png", 140, buttonListener);
        frame.add(dashboardButton);

        editDictionaryButton = createMenuItem("Edit Dictionary", "G:/javaswing-study/src/cs2212/com/edit(3030).png", 190, buttonListener);
        frame.add(editDictionaryButton);

        askHelpButton = createMenuItem("Ask Help", "G:/javaswing-study/src/cs2212/com/askhelp(3030).png", 240, buttonListener);
        frame.add(askHelpButton);

        settingsButton = createMenuItem("Settings", "G:/javaswing-study/src/cs2212/com/setting(3030).png", 290, buttonListener);
        frame.add(settingsButton);

        // Create a top panel with a white background.
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1920, 50);
        topPanel.setBackground(Color.WHITE);
        frame.add(topPanel);

        // Create a left side panel with a white background.
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 300, 1080);
        leftPanel.setBackground(Color.WHITE);
        frame.add(leftPanel);

        // Make the frame visible.
        frame.setVisible(true);
/*
        // Make the frame visible.
        frame.setVisible(true);
*/

        // Set the Dashboard button as the default selected button on startup.
        setActiveButton(dashboardButton);
    }

    private static JButton createMenuItem(String text, String iconPath, int yPos, ActionListener buttonListener) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setIconTextGap(10);
        button.setMargin(new Insets(0, 20, 0, 0)); // top, left, bottom, right
        button.setBounds(60, yPos, 250, 40);
        button.setFont(new Font("Cairo", Font.BOLD, 18));
        button.setForeground(Color.decode("#A5A5A5"));  // Set to light gray.
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(buttonListener);
        return button;
    }

    // A method to update the active button's appearance and reset others
    private static void setActiveButton(JButton activeButton) {
        // Reset all buttons to default foreground color
        dashboardButton.setForeground(Color.decode("#A5A5A5"));
        editDictionaryButton.setForeground(Color.decode("#A5A5A5"));
        askHelpButton.setForeground(Color.decode("#A5A5A5"));
        settingsButton.setForeground(Color.decode("#A5A5A5"));

        // Set the active button's foreground to indicate selection
        activeButton.setForeground(Color.decode("#6418C3"));

        // Move the purple indicator to the active button
        purpleIndicator.setBounds(50, activeButton.getY(), 5, 40);
    }
}
