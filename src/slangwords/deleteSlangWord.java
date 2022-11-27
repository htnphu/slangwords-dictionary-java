package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class deleteSlangWord extends JPanel {
    JTextField deleteWordTextField;
    public deleteSlangWord(HashMap<String, String> dictionary) {
        deleteWordTextField = new JTextField();

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setBackground(new Color(126, 138, 151));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(e -> deleteButtonHandler(dictionary, deleteWordTextField.getText()));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        mainPanel.add(deleteWordTextField);
        mainPanel.add(Box.createHorizontalStrut(5));
        mainPanel.add(deleteButton);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        add(Box.createVerticalStrut(10));
        add(Box.createHorizontalStrut(10));
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.PAGE_START);
    }

    void deleteButtonHandler(HashMap<String, String> dictionary, String slangWordKey) {
        String definition = dictionary.get(slangWordKey);
        if (definition != null) {
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Word: " + slangWordKey +
                            "\nDefinition: " + definition +
                            "\nDelete?",
                    "Delete word",
                    JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                dictionary.remove(slangWordKey);
                JOptionPane.showMessageDialog(this, "Deleted successfully: " + slangWordKey + " --> " + definition);
            }
        } else JOptionPane.showMessageDialog(this, "Can not " + null + " delete empty word!");
    }
}
