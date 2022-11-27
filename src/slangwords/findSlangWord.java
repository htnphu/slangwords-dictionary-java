package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class findSlangWord extends JPanel {

    JLabel slangWordLabel;
    JLabel slangWordDefinitionLabel;
    public findSlangWord(HashMap<String, String> dictionary) {
        JTextField searchWordText = new JTextField("", 20);
        JButton searchButton = new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setBackground(new Color(126, 138, 151));
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        String data = searchWordText.getText();
        searchButton.addActionListener(e -> searchButtonHandler(dictionary, searchWordText.getText()));
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchWordText);
        searchPanel.add(Box.createHorizontalStrut(5));
        searchPanel.add(searchButton);

        slangWordLabel = new JLabel();
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 32));
        slangWordLabel.setForeground(new Color(153, 204, 255));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        slangWordDefinitionLabel = new JLabel();
        mainPanel.add(slangWordLabel);
        mainPanel.add(slangWordDefinitionLabel);

        // Add to the main panel
        setLayout(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        add(searchPanel, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     *
     * @param dictionary HashMap
     * @param slangWordKey Key in hashmap
     *                     get(slangWordKey) -> value <=> definition of the slang word
     */
    void searchButtonHandler(HashMap<String, String> dictionary, String slangWordKey) {
        String value = dictionary.get(slangWordKey);
        if (value != null) {
            slangWordDefinitionLabel.setForeground(new Color(0, 0, 220));
            slangWordDefinitionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            slangWordDefinitionLabel.setText(slangWordKey + "    ==>    " + value);
        }
        else {
            slangWordDefinitionLabel.setForeground(new Color(255, 80, 80));
            slangWordDefinitionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            slangWordDefinitionLabel.setText("Can not find " + "<" + slangWordKey + ">" +" in the dictionary");
        }
        if (value != null) viewSearchingHistory.addWordToHistory(slangWordKey);
    }
}
