package spellcheckui;

/**
 *
 * @author janetlu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class askHelp extends JDialog {

    //private JFrame frame;
    private JDialog dialog;

    public askHelp(JFrame owner) {
        dialog = new JDialog(owner, "Ask Help", Dialog.ModalityType.APPLICATION_MODAL);

        //this.dialog = new JFrame("Ask Help Page");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(962, 779);
        dialog.setLayout(null);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 962, 779);
        backgroundPanel.setBackground(new Color(0xF6EEFF));
        backgroundPanel.setLayout(null);
        dialog.add(backgroundPanel);

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
                dialog.dispose();
            }
        });
        backgroundPanel.add(closeButton);

        String imagePath = "G:/javaswing-study/src/cs2212/com/demo-pic.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds((962 - imageIcon.getIconWidth()) / 2 + 30 + 70, (779 - imageIcon.getIconHeight()) / 2 + 30 + 70, (imageIcon.getIconWidth()) / 3 * 2, imageIcon.getIconHeight() / 3 * 2);
        backgroundPanel.add(imageLabel);

        dialog.setLocationRelativeTo(null);

    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

}
