package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class findSlangWord extends JPanel {

    JLabel slangWordLabel;
    JLabel slangWordDefinitionLabel;
    public findSlangWord(HashMap<String, String> dictionary) {
        JTextField searchWordText = new JTextField("", 20);
        JButton searchButton = new JButton("Search");
        String data = searchWordText.getText();
        searchButton.addActionListener(e -> searchButtonHandler(dictionary, searchWordText.getText()));
        JPanel findPanel = new JPanel();
        findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));
        findPanel.add(searchWordText);
        findPanel.add(Box.createHorizontalStrut(5));
        findPanel.add(searchButton);

        slangWordLabel = new JLabel();
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 32));
        slangWordLabel.setForeground(Color.GREEN);

        JPanel slangWordPanel = new JPanel();
        slangWordPanel.setLayout(new BoxLayout(slangWordPanel, BoxLayout.Y_AXIS));
        slangWordDefinitionLabel = new JLabel();
        slangWordPanel.add(slangWordLabel);
        slangWordPanel.add(slangWordDefinitionLabel);

        // Add to the main panel
        setLayout(new BorderLayout());
        findPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));

        add(findPanel, BorderLayout.PAGE_START);
        add(slangWordPanel, BorderLayout.CENTER);
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
            slangWordDefinitionLabel.setForeground(Color.GREEN);
            slangWordDefinitionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            slangWordDefinitionLabel.setText(slangWordKey + "    ->    " + value);
        }
        else {
            slangWordDefinitionLabel.setForeground(Color.RED);
            slangWordDefinitionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            slangWordDefinitionLabel.setText("Can not find " + "<" + slangWordKey + ">" +" in the dictionary");
        }
    }
}
