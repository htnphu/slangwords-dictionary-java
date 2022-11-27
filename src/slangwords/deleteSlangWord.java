package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class deleteSlangWord extends JPanel {
    JTextField deleteWordTextField;
    public deleteSlangWord(HashMap<String, String> dictionary) {
        deleteWordTextField = new JTextField();

        JButton deleteButton = new JButton("Delete word");
        deleteButton.addActionListener(e -> deleteButtonHandler(dictionary, deleteWordTextField.getText()));

        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.X_AXIS));

        deletePanel.add(deleteWordTextField);
        deletePanel.add(Box.createHorizontalStrut(5));
        deletePanel.add(deleteButton);

        add(Box.createVerticalStrut(10));
        add(Box.createHorizontalStrut(10));
        setLayout(new BorderLayout());
        add(deletePanel, BorderLayout.PAGE_START);
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
