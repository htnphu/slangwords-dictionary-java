package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;
public class editSlangWord extends JPanel {
    JTextField slangWordTextField;
    JTextField slangWordDefinitionTextField;

    public editSlangWord(HashMap<String, String> dictionary) {
        slangWordTextField = new JTextField("");
        JTextField searchWordText = new JTextField();

        JButton searchButton = new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setBackground(new Color(126, 138, 151));
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        searchButton.addActionListener(e -> searchButtonHandler(dictionary, searchWordText.getText()));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchWordText);
        searchPanel.add(Box.createHorizontalStrut(10));
        searchPanel.add(searchButton);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        slangWordDefinitionTextField = new JTextField();
        JPanel meaningPanel = new JPanel();
        meaningPanel.setLayout(new BoxLayout(meaningPanel, BoxLayout.X_AXIS));
        meaningPanel.add(new JLabel("Definition:"));
        meaningPanel.add(Box.createHorizontalStrut(20));
        meaningPanel.add(slangWordDefinitionTextField);

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        informationPanel.add(Box.createVerticalStrut(10));
        informationPanel.add(meaningPanel);

        JButton editButton = new JButton("Edit");
        editButton.setFocusable(false);
        editButton.setBackground(new Color(126, 138, 151));
        editButton.setOpaque(true);
        editButton.setBorderPainted(false);
        editButton.addActionListener(e -> editButtonHandler(dictionary, slangWordDefinitionTextField.getText()));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(informationPanel, BorderLayout.CENTER);
        mainPanel.add(editButton, BorderLayout.LINE_END);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BorderLayout());
        editPanel.add(mainPanel, BorderLayout.PAGE_START);
        editPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.PAGE_START);
        add(editPanel, BorderLayout.CENTER);
    }

    void editButtonHandler(HashMap<String, String> dictionary, String definition) {
        if (slangWordTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please do not leave the box empty :(");
        } else {
            dictionary.put(slangWordTextField.getText(), definition);
            JOptionPane.showMessageDialog(this, "Edited successfully!");
        }
    }
    void searchButtonHandler(HashMap<String, String> dictionary, String slangWordKey) {
        String result = dictionary.get(slangWordKey);
        slangWordTextField.setText(result != null ? slangWordKey : "");
        slangWordDefinitionTextField.setText(result != null ? result : "Can not find " + "<" + slangWordKey + ">" +" in the dictionary");
    }
}
