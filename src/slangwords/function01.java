package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class function01 extends JPanel {

    JLabel slangWordLabel;
    JLabel slangWordDefinitionLabel;
    public function01(HashMap<String, String> dictionary) {
        JTextField findTextField = new JTextField("", 20);
        JButton findButton = new JButton("Find");
        findButton.addActionListener(e -> findButtonEventHandler(dictionary, findTextField.getText()));
        JPanel findPanel = new JPanel();
        findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));
        findPanel.add(findTextField);
        findPanel.add(Box.createHorizontalStrut(5));
        findPanel.add(findButton);

        slangWordLabel = new JLabel();
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 28));
        slangWordLabel.setForeground(Color.GREEN);

        JPanel slangPanel = new JPanel();
        slangPanel.setLayout(new BoxLayout(slangPanel, BoxLayout.Y_AXIS));
        slangWordDefinitionLabel = new JLabel();
        slangPanel.add(slangWordLabel);
        slangPanel.add(slangWordDefinitionLabel);

        // Add to the main panel
        setLayout(new BorderLayout());
        add(findPanel, BorderLayout.PAGE_START);
        add(slangPanel, BorderLayout.CENTER);
    }

    /**
     *
     * @param dictionary HashMap
     * @param slangWordKey Key in hashmap
     *                     get(slangWordKey) -> value <=> definition of the slang word
     */
    void findButtonEventHandler(HashMap<String, String> dictionary, String slangWordKey) {
        String value = dictionary.get(slangWordKey);
        if (value != null) {
            slangWordDefinitionLabel.setForeground(Color.GREEN);
            slangWordDefinitionLabel.setText(slangWordKey + "➪" + value);
        }
        else {
            slangWordDefinitionLabel.setForeground(Color.RED);
            slangWordDefinitionLabel.setText("Can not find " + "<" + slangWordKey + ">" +" in the dictionary");
        }
    }
}
