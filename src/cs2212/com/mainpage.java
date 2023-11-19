package cs2212.com;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class mainpage {
    private static JFrame frame;
    private static JButton dashboardButton;
    private static JButton editDictionaryButton;
    private static JButton askHelpButton;
    private static JButton settingsButton;
    private static JPanel purpleIndicator;
    private static JTextPane textPane;

    public static void main(String[] args) { // 主函数。
        JFrame frame = new JFrame("Main page"); // 创建一个新窗体，并设置标题为"Main page"。

        JButton OpenButton = new JButton("Open File"); // 创建一个按钮，并设置文本为"Open File"。
        // 设置按钮位置和大小。
        OpenButton.setBounds(1024 - 250-250, 768 - 80 - 50, 200, 40);
        // 设置按钮背景和前景颜色。
        OpenButton.setBackground(Color.decode("#E8DFF2"));
        OpenButton.setForeground(Color.decode("#6418C3"));
        // 设置按钮字体。
        OpenButton.setFont(new Font("Cairo", Font.BOLD, 18));
        OpenButton.setBorderPainted(true); // 设置按钮边框为绘制状态。
        // 添加事件监听器，当按钮被点击时执行。
        OpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建一个文件选择器。
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose a Text File"); // 设置文件选择器标题。
                fileChooser.setAcceptAllFileFilterUsed(false); // 不接受所有文件类型。
                // 只接受文本文件。
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

                int result = fileChooser.showOpenDialog(frame); // 显示文件选择器对话框。
                if (result == JFileChooser.APPROVE_OPTION) { // 如果用户选择了文件。
                    File selectedFile = fileChooser.getSelectedFile(); // 获取选择的文件。
                    try {
                        String fileContent = readFile(selectedFile); // 读取文件内容。
                        textPane.setText(fileContent); // 在文本面板上显示文件内容。
                    } catch (IOException ex) {
                        ex.printStackTrace(); // 打印错误堆栈信息。
                        // 显示错误信息对话框。
                        JOptionPane.showMessageDialog(frame, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frame.add(OpenButton); // 将之前创建的"Open File"按钮添加到窗体上。
        JButton CorrectionButton = new JButton("Correction Start"); // 创建一个按钮，并设置文本为"Correction Start"。
        // 设置按钮位置和大小。
        CorrectionButton.setBounds(1024 - 250, 768 - 80 - 50, 200, 40);
        // 设置按钮背景和前景颜色。
        CorrectionButton.setBackground(Color.decode("#E8DFF2"));
        CorrectionButton.setForeground(Color.decode("#6418C3"));
        // 设置按钮字体。
        CorrectionButton.setFont(new Font("Cairo", Font.BOLD, 18));
        CorrectionButton.setBorderPainted(true); // 设置按钮边框为绘制状态。
        frame.add(CorrectionButton); // 将之前创建的"Correction Start"按钮添加到窗体上。

        textPane = new JTextPane(); // 创建一个新的文本面板，用于显示文本内容。
        textPane.setContentType("text/html"); // 设置文本面板的内容类型为HTML，这允许在面板中使用HTML格式化文本。
        textPane.setEditable(false); // 设置文本面板为不可编辑，用户不能修改其内容。

// 创建一个滚动面板，并将文本面板加入到其中。这允许文本内容超出显示范围时进行滚动。
        JScrollPane scrollPane = new JScrollPane(textPane);
// 设置滚动面板的位置和大小。
        scrollPane.setBounds(330, 80, 1024 - 330 - 50, 768 - 80 - 50 - 100);
        frame.add(scrollPane); // 将滚动面板添加到窗体上。

        frame.setSize(1024, 768); // 设置窗体的大小为1024x768像素。
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭操作。当用户关闭窗体时，程序将退出。
        frame.setLayout(null); // 设置窗体的布局管理器为null，即不使用布局管理器，组件位置需要手动指定。
        frame.getContentPane().setBackground(Color.decode("#F3F3F3")); // 设置窗体内容面板的背景颜色。


        // 创建并设置标题标签
        JLabel titleLabel = new JLabel("Spell Checker"); // 创建一个新的标签，文本为"Spell Checker"。
        titleLabel.setBounds(50, 10, 200, 30); // 设置标签的位置和大小。
        titleLabel.setFont(new Font("Cairo", Font.BOLD, 24)); // 设置标签的字体和大小。
        frame.add(titleLabel); // 将标签添加到窗体上。

// 创建并设置主菜单标签
        JLabel mainMenuLabel = new JLabel("Main Menu"); // 创建一个新的标签，文本为"Main Menu"。
        mainMenuLabel.setBounds(50, 100, 150, 20); // 设置标签的位置和大小。
        mainMenuLabel.setFont(new Font("Open Sans", Font.BOLD, 16)); // 设置标签的字体和大小。
        mainMenuLabel.setForeground(Color.decode("#C7C7C7")); // 设置标签的前景颜色。
        frame.add(mainMenuLabel); // 将标签添加到窗体上。

// 创建并设置紫色指示器面板
        purpleIndicator = new JPanel(); // 创建一个新的面板。
        purpleIndicator.setBackground(Color.decode("#6418C3")); // 设置面板的背景颜色为紫色。
        purpleIndicator.setBounds(50, 140, 5, 40); // 设置面板的位置和大小。
        frame.add(purpleIndicator); // 将面板添加到窗体上。

// 创建按钮事件监听器
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton((JButton) e.getSource()); // 当按钮被点击时，调用setActiveButton方法。
            }
        };

// 创建并添加菜单项按钮
        dashboardButton = createMenuItem("Dashboard", "G:/javaswing-study/src/cs2212/com/dashboard(3030).png", 140, buttonListener);
        frame.add(dashboardButton); // 创建“Dashboard”按钮并添加到窗体上。

        editDictionaryButton = createMenuItem("Edit Dictionary", "G:/javaswing-study/src/cs2212/com/edit(3030).png", 190, buttonListener);
        frame.add(editDictionaryButton); // 创建“Edit Dictionary”按钮并添加到窗体上。

        askHelpButton = createMenuItem("Ask Help", "G:/javaswing-study/src/cs2212/com/askhelp(3030).png", 240, buttonListener);
        frame.add(askHelpButton); // 创建“Ask Help”按钮并添加到窗体上。


        //*******************************************************************************************************************************************
        // 创建一个名为"Settings"的菜单项，这个菜单项有一个图标和一个点击事件
        //以及一个监听器对象，用于定义当用户点击这个菜单项时应该执行的操作。

        settingsButton = createMenuItem("Settings", "G:/javaswing-study/src/cs2212/com/setting(3030).png", 290, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(settingsButton);
                //用户点击这个菜单项时，这个方法会被调用，用于设置settingsButton为当前活跃的按钮。
                //说白了就是这个方法定义了点这个选项的时候哪个动画，紫色的
                openSettingsPage();
                //这个方法负责打开应用程序中的设置页面。这通常会导致界面上显示设置选项或者打开一个新的设置窗口。
                //如何定义的在后面
            }
            //********************************************************************************************************************************************
        });


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


    private static void openSettingsPage() {
        setting_page settings = new setting_page(frame);
        settings.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setActiveButton(dashboardButton); // 当设置窗口关闭时, 回到 Dashboard
            }
        });
        settings.setVisible(true);
    }
//别忘记定义一个open setting page
    // 创建一个新的setting_page对象并显示它
    //这里的setting_page是什么？就是你要打开的那个页面的class，所以我分开写了page


    private static String readFile(File file) throws IOException {
        // 定义一个名为readFile的私有静态方法，接受一个File对象作为参数，并可能抛出IOException异常。

        StringBuilder fileContent = new StringBuilder(); // 创建一个StringBuilder对象用于构建文件内容。

        // 使用try-with-resources语句创建一个BufferedReader对象，自动管理资源。
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line; // 定义一个字符串变量用于存储读取的每一行文本。

            // 使用while循环读取文件的每一行，直到文件结束。
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n"); // 将读取的每一行添加到StringBuilder对象中，并添加换行符。
            }
        }
        // try-with-resources语句结束后，会自动关闭BufferedReader。

        return fileContent.toString(); // 将StringBuilder对象转换成字符串并返回。
    }


    // 创建菜单项按钮的方法
    private static JButton createMenuItem(String text, String iconPath, int yPos, ActionListener buttonListener) {
        JButton button = new JButton(text); // 创建一个新的按钮，文本为传入的text参数。
        button.setIcon(new ImageIcon(iconPath)); // 设置按钮的图标，图标路径为传入的iconPath参数。
        button.setHorizontalAlignment(SwingConstants.LEFT); // 设置按钮文本的水平对齐方式为左对齐。
        button.setHorizontalTextPosition(SwingConstants.RIGHT); // 设置按钮文本相对于图标的水平位置为右侧。
        button.setIconTextGap(10); // 设置图标和文本之间的间距。
        button.setMargin(new Insets(0, 20, 0, 0)); // 设置按钮的边距。
        button.setBounds(60, yPos, 250, 40); // 设置按钮的位置和大小，yPos为传入的参数，用于垂直位置。
        button.setFont(new Font("Cairo", Font.BOLD, 18)); // 设置按钮的字体和样式。
        button.setForeground(Color.decode("#A5A5A5")); // 设置按钮的前景颜色。
        button.setContentAreaFilled(false); // 设置按钮的内容区域不填充颜色。
        button.setFocusPainted(false); // 设置按钮在获得焦点时不显示焦点状态。
        button.setBorderPainted(false); // 设置按钮不绘制边框。
        button.addActionListener(buttonListener); // 为按钮添加事件监听器，监听器为传入的buttonListener参数。
        return button; // 返回创建的按钮。
    }

    // 设置活动按钮的方法
    private static void setActiveButton(JButton activeButton) {
        // 将所有按钮的前景颜色设置为默认颜色。
        dashboardButton.setForeground(Color.decode("#A5A5A5"));
        editDictionaryButton.setForeground(Color.decode("#A5A5A5"));
        askHelpButton.setForeground(Color.decode("#A5A5A5"));
        settingsButton.setForeground(Color.decode("#A5A5A5"));

        activeButton.setForeground(Color.decode("#6418C3")); // 将活动按钮的前景颜色设置为高亮颜色。
        purpleIndicator.setBounds(50, activeButton.getY(), 5, 40); // 移动紫色指示器到活动按钮的位置。
    }
}
