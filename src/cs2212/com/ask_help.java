package cs2212.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ask_help {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ask Help Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(962, 779);
        frame.setLayout(null);
     
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 962, 779);
        backgroundPanel.setBackground(new Color(0xF6EEFF));
        backgroundPanel.setLayout(null);
        frame.add(backgroundPanel);


        JLabel titleLabel = new JLabel("How to use it?");
        titleLabel.setFont(new Font("Cairo", Font.BOLD, 34));
        titleLabel.setBounds(50, 40, 852, 64);
        backgroundPanel.add(titleLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Open Sans", Font.PLAIN, 32));
        closeButton.setBounds(689, 646, 200, 54);
        closeButton.setBackground(new Color(0x6418C3));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        backgroundPanel.add(closeButton);


        String imagePath = "G:/javaswing-study/src/cs2212/com/demo-pic.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds((962 - imageIcon.getIconWidth()) / 2+30+70, (779 - imageIcon.getIconHeight()) / 2+30+70, (imageIcon.getIconWidth())/3*2, imageIcon.getIconHeight()/3*2);
        backgroundPanel.add(imageLabel);

       frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
