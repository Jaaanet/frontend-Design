package cs2212.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class setting_page {
    private JFrame frame;
    private JDialog dialog;

    public setting_page(Frame owner) {  // 使用 Frame 参数来指定父窗口
        dialog = new JDialog(owner, "Setting", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(962, 779);
        dialog.setLayout(null);

        JLabel settingLabel = new JLabel("Setting");
        settingLabel.setBounds(50, 40, 200, 40);
        settingLabel.setFont(new Font("Segoe UI", Font.BOLD, 34));
        dialog.add(settingLabel);

        JLabel userCustomLabel = new JLabel("User customizable themes");
        userCustomLabel.setBounds(50, 102, 300, 20);
        userCustomLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        userCustomLabel.setForeground(new Color(0xA5A5A5));
        dialog.add(userCustomLabel);

        JPanel theme1Panel = new JPanel();
        theme1Panel.setBounds(50, 146, 862, 275);
        theme1Panel.setBackground(new Color(0, 0, 0, 0x0A));
        dialog.add(theme1Panel);

        JLabel theme1Label = new JLabel("Theme 1");
        theme1Label.setBounds(81, 151, 130, 40);
        theme1Label.setFont(new Font("Segoe UI", Font.BOLD, 32));
        dialog.add(theme1Label);

        JLabel fontSize1Label = new JLabel("Font size: Middle");
        fontSize1Label.setBounds(158, 226, 200, 20);
        fontSize1Label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        dialog.add(fontSize1Label);

        JLabel highlightColor1Label = new JLabel("High light color: Red");
        highlightColor1Label.setBounds(158, 264, 300, 20);
        highlightColor1Label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        dialog.add(highlightColor1Label);

        JPanel theme2Panel = new JPanel();
        theme2Panel.setBounds(50, 450, 862, 275);
        theme2Panel.setBackground(new Color(0, 0, 0, 0x0A));
        dialog.add(theme2Panel);

        JLabel theme2Label = new JLabel("Theme 2");
        theme2Label.setBounds(81, 455, 130, 40);
        theme2Label.setFont(new Font("Segoe UI", Font.BOLD, 32));
        dialog.add(theme2Label);

        JLabel fontSize2Label = new JLabel("Font size: Large");
        fontSize2Label.setBounds(158, 530, 200, 20);
        fontSize2Label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        dialog.add(fontSize2Label);

        JLabel highlightColor2Label = new JLabel("High light color: Green");
        highlightColor2Label.setBounds(158, 568, 300, 20);
        highlightColor2Label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        dialog.add(highlightColor2Label);

        JButton setThemeButton1 = new JButton("Set theme");
        setThemeButton1.setBounds(688, 341, 200, 54);
        setThemeButton1.setFont(new Font("Segoe UI", Font.PLAIN, 32));
        setThemeButton1.setBackground(new Color(0x6418C3));
        setThemeButton1.setForeground(Color.WHITE);
        setThemeButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(setThemeButton1);

        JButton setThemeButton2 = new JButton("Set theme");
        setThemeButton2.setBounds(688, 646, 200, 54);
        setThemeButton2.setFont(new Font("Segoe UI", Font.PLAIN, 32));
        setThemeButton2.setBackground(new Color(0x6418C3));
        setThemeButton2.setForeground(Color.WHITE);
        setThemeButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(setThemeButton2);

        JPanel mainBg = new JPanel();
        mainBg.setBounds(0, 0, 962, 779);
        mainBg.setBackground(new Color(0xF6EEFF));
        dialog.add(mainBg);


        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

    public void addWindowListener(WindowListener listener) {
        dialog.addWindowListener(listener);
    }
}
