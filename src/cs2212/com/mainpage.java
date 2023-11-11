package cs2212.com;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class mainpage {
    private static JButton dashboardButton;
    private static JButton editDictionaryButton;
    private static JButton askHelpButton;
    private static JButton settingsButton;
    private static JPanel purpleIndicator;
    private static JTextPane textPane;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main page");

        JButton correctionsButton = new JButton("Open File");
        correctionsButton.setBounds(1024 - 250, 768 - 80 - 50, 200, 40);
        correctionsButton.setBackground(Color.decode("#E8DFF2"));
        correctionsButton.setForeground(Color.decode("#6418C3"));
        correctionsButton.setFont(new Font("Cairo", Font.BOLD, 18));
        correctionsButton.setBorderPainted(true);
        correctionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose a Text File");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        String fileContent = readFile(selectedFile);
                        textPane.setText(fileContent);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frame.add(correctionsButton);

        textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(330, 80, 1024 - 330 - 50, 768 - 80 - 50 - 100);
        frame.add(scrollPane);

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#F3F3F3"));

        JLabel titleLabel = new JLabel("Spell Checker");
        titleLabel.setBounds(50, 10, 200, 30);
        titleLabel.setFont(new Font("Cairo", Font.BOLD, 24));
        frame.add(titleLabel);

        JLabel mainMenuLabel = new JLabel("Main Menu");
        mainMenuLabel.setBounds(50, 100, 150, 20);
        mainMenuLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        mainMenuLabel.setForeground(Color.decode("#C7C7C7"));
        frame.add(mainMenuLabel);

        purpleIndicator = new JPanel();
        purpleIndicator.setBackground(Color.decode("#6418C3"));
        purpleIndicator.setBounds(50, 140, 5, 40);
        frame.add(purpleIndicator);

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton((JButton) e.getSource());
            }
        };

        dashboardButton = createMenuItem("Dashboard", "G:/javaswing-study/src/cs2212/com/dashboard(3030).png", 140, buttonListener);
        frame.add(dashboardButton);

        editDictionaryButton = createMenuItem("Edit Dictionary", "G:/javaswing-study/src/cs2212/com/edit(3030).png", 190, buttonListener);
        frame.add(editDictionaryButton);

        askHelpButton = createMenuItem("Ask Help", "G:/javaswing-study/src/cs2212/com/askhelp(3030).png", 240, buttonListener);
        frame.add(askHelpButton);

        settingsButton = createMenuItem("Settings", "G:/javaswing-study/src/cs2212/com/setting(3030).png", 290, buttonListener);
        frame.add(settingsButton);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1920, 50);
        topPanel.setBackground(Color.WHITE);
        frame.add(topPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 300, 1080);
        leftPanel.setBackground(Color.WHITE);
        frame.add(leftPanel);

        frame.setVisible(true);

        setActiveButton(dashboardButton);
    }

    private static String readFile(File file) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }
        return fileContent.toString();
    }

    private static JButton createMenuItem(String text, String iconPath, int yPos, ActionListener buttonListener) {
        JButton button = new JButton(text);
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setIconTextGap(10);
        button.setMargin(new Insets(0, 20, 0, 0));
        button.setBounds(60, yPos, 250, 40);
        button.setFont(new Font("Cairo", Font.BOLD, 18));
        button.setForeground(Color.decode("#A5A5A5"));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(buttonListener);
        return button;
    }

    private static void setActiveButton(JButton activeButton) {
        dashboardButton.setForeground(Color.decode("#A5A5A5"));
        editDictionaryButton.setForeground(Color.decode("#A5A5A5"));
        askHelpButton.setForeground(Color.decode("#A5A5A5"));
        settingsButton.setForeground(Color.decode("#A5A5A5"));
        activeButton.setForeground(Color.decode("#6418C3"));
        purpleIndicator.setBounds(50, activeButton.getY(), 5, 40);
    }
}
