package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class addSlangWord extends JPanel {
    JTextField addWordTextField;
    JTextField addDefinitionTextField;
    public addSlangWord(HashMap<String, String> dictionary) {
        JPanel slangWordPanel = new JPanel();
        addWordTextField = new JTextField();
        slangWordPanel.setLayout(new BoxLayout(slangWordPanel, BoxLayout.X_AXIS));
        slangWordPanel.add(new JLabel("Word:"));
        slangWordPanel.add(Box.createHorizontalStrut(30));
        slangWordPanel.add(addWordTextField);

        JPanel definitionPanel = new JPanel();
        addDefinitionTextField = new JTextField();
        definitionPanel.setLayout(new BoxLayout(definitionPanel, BoxLayout.X_AXIS));
        definitionPanel.add(new JLabel("Definition:"));
        definitionPanel.add(Box.createHorizontalStrut(20));
        definitionPanel.add(addDefinitionTextField);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(slangWordPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(definitionPanel);

        JButton addButton = new JButton("Add new word");
        addButton.addActionListener(e -> addButtonHandler(dictionary, addWordTextField.getText(), addDefinitionTextField.getText()));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Add word");
        title.setFont(new Font("Serif", Font.BOLD, 26));
        title.setBorder(BorderFactory.createEmptyBorder(20,200,10,0));

        panel.add(title);
        panel.add(mainPanel);
        panel.add(addButton);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
    }

    public void addButtonHandler(HashMap<String, String> dictionary, String word, String definition) {
        if (dictionary.containsKey(word)) {
            String[] options = new String[]{"Overwrite", "Duplicate", "Cancel"};
            int selectedOption = JOptionPane.showOptionDialog(this, "Word is already existed",
                    "Warning...", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            switch (selectedOption) {
                case 0: {
                    dictionary.put(word, definition);
                    JOptionPane.showMessageDialog(this, "Overwrote!");
                }
                case 1: {
                    dictionary.put(word, dictionary.get(word) + "| " + definition);
                    JOptionPane.showMessageDialog(this, "Added successfully!");
                }
            }
        } else {
            dictionary.put(word, definition);
            JOptionPane.showMessageDialog(this, "Added successfully!");
        }
    }
}
