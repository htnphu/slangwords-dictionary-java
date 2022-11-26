package slangwords;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class findByDefinition extends JPanel {

    JLabel slangWordLabel;
    JLabel slangWordDefinitionLabel;
    /**
     * resultList: a JList which stores a list of slang words
     */
    JList<String> resultList;

    public findByDefinition(HashMap<String, String> dictionary) {
        JTextField searchWordText = new JTextField();

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchButtonHandler(dictionary, searchWordText.getText()));

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));

        searchPanel.add(searchWordText);
        searchPanel.add(Box.createHorizontalStrut(5));
        searchPanel.add(searchButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(new JLabel("Search results:"), BorderLayout.PAGE_START);
        resultList = new JList<>();
        JScrollPane resultListScrollPane = new JScrollPane(resultList);
        resultListScrollPane.setMaximumSize(new Dimension(600,300));
        resultListScrollPane.setPreferredSize(new Dimension(0, 200));
        resultPanel.add(resultListScrollPane, BorderLayout.CENTER);
        resultList.addListSelectionListener(e -> viewMeaning(dictionary, resultList.getSelectedValue()));

        slangWordLabel = new JLabel();
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        slangWordDefinitionLabel = new JLabel();

        JPanel slangWordPanel = new JPanel();
        slangWordPanel.setLayout(new BoxLayout(slangWordPanel, BoxLayout.Y_AXIS));

        slangWordPanel.add(slangWordLabel);
        slangWordPanel.add(slangWordDefinitionLabel);

        setLayout(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createEmptyBorder(26,0,0,0));
        slangWordPanel.setBorder(BorderFactory.createEmptyBorder(0,0,25,0));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));
        add(searchPanel, BorderLayout.PAGE_START);
        add(slangWordPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.PAGE_END);
    }

    void searchButtonHandler(HashMap<String, String> dictionary, String slangWordKey) {
        Vector<String> result = new Vector<>();

        // Loop in the dictionary to get the slang word and add to the result vector
        dictionary.forEach((slangWord, definition) -> {
            if (definition.contains(slangWordKey))
                result.add(slangWord);
        });

        if (result.isEmpty()) {
            slangWordLabel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
            slangWordLabel.setForeground(Color.RED);
            slangWordLabel.setText("Can not find " + "<" + slangWordKey + ">" +" in the dictionary");
            slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 18));
            slangWordDefinitionLabel.setText(":( Try another one");
            slangWordDefinitionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        } else {
            resultList.setListData(result);
        }
    }

    /**
     * Display Slang when choose a slang
     * @param dictionary HashMap
     * @param str String
     */
    void viewMeaning(HashMap<String, String> dictionary, String str) {
        slangWordLabel.setText(str);
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        slangWordLabel.setText("-> " + dictionary.get(str));
    }
}
