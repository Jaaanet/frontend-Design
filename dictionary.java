package spellcheckui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JDialog;

public class dictionary extends JDialog {


    private JDialog dialog;
    // Assuming you have an array of words to display    
    //private String[] words = {};
    private String[] words = {"design", "eign", "gesign", "heian", "xciesign", "zsign", "sdjsidf", "sfsdfs",
        "sdfsdfsdf", "sdsdfsfs", "sdfsdf", "janet", "Luke", "Lisa", "ADa", "Mike", "linda", "Wanda", "Doctor"}; // etc.

    public dictionary(JFrame owner) {
        dialog = new JDialog(owner, "Your Dictionary", Dialog.ModalityType.APPLICATION_MODAL);
        setSize(600, 600);
        // This will center the frame on the screen
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Main panel with words
        // Create the fixed size grid panel
        FixedSizeGridPanel wordsPanel = new FixedSizeGridPanel(100, 50, 5);

        // Add each word to the panel
        for (String word : words) {
            JLabel wordLabel = new JLabel(word, SwingConstants.CENTER);
            wordLabel.setOpaque(true);
            wordLabel.setBackground(new Color(123, 50, 250)); // Set to a purple color
            wordLabel.setForeground(Color.WHITE); // Set text color to white
            wordLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            wordsPanel.add(wordLabel);
        }
        add(wordsPanel, BorderLayout.CENTER);

        // Create a JScrollPane that contains the wordsPanel
        JScrollPane scrollPane = new JScrollPane(wordsPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Add the scrollPane to the CENTER of the BorderLayout
        add(scrollPane, BorderLayout.CENTER);

        // Footer panel with delete and edit buttons
        //JPanel footerPanel = createFooterPanel();
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        // Add "Delete Words" button
        JButton deleteButton = new JButton("Delete Words");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the delete words JFrame
                new deleteDictionary().setVisible(true);
            }
        });
        footerPanel.add(deleteButton);

        // Add "Edit Words" button
        JButton editButton = new JButton("Edit Words");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the edit words JFrame
                new editDictionary().setVisible(true);
            }
        });
        footerPanel.add(editButton);

        // Add "reset Words" button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the edit words JFrame
                //openEditDictionary();
            }
        });
        footerPanel.add(resetButton);
        add(footerPanel, BorderLayout.SOUTH);

        // Setting default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //add/delete/edit word to array from the correction
    public void addWord() {

    }

    public void deleteWord() {

    }

    public void editWord() {

    }
    
    //Below are the settings for formatting the output/display
    static class FixedSizeGridPanel extends JPanel {

        private final int cellWidth;
        private final int cellHeight;
        private final int columns;

        public FixedSizeGridPanel(int cellWidth, int cellHeight, int columns) {
            this.cellWidth = cellWidth;
            this.cellHeight = cellHeight;
            this.columns = columns;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        public void displayWord(String word) {
            int currentComponents = getComponentCount();
            JPanel rowPanel;

            // Check if we need to add a new row
            if (currentComponents == 0 || currentComponents % columns == 0) {
                rowPanel = new JPanel();
                rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
                add(rowPanel);
            } else {
                rowPanel = (JPanel) getComponent(currentComponents - 1);
            }

            // Create a label with fixed size for the word
            JLabel label = new JLabel(word, SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(cellWidth, cellHeight));
            label.setMaximumSize(new Dimension(cellWidth, cellHeight));
            label.setMinimumSize(new Dimension(cellWidth, cellHeight));
            label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE), // Outer line border for visibility
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Inner empty border for spacing
            ));

            // Add the label to the row panel with spacing
            rowPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Horizontal spacing
            rowPanel.add(label);
            rowPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Horizontal spacing

            // Add vertical spacing if this is a new row
            if (rowPanel.getComponentCount() == 1) {
                add(Box.createRigidArea(new Dimension(0, 10))); // Vertical spacing above the row
            }
        }

    }

}
