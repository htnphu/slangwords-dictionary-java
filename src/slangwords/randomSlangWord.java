package slangwords;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class randomSlangWord extends JPanel {
    public randomSlangWord(HashMap<String, String> dictionary) {
        Random random = new Random();
        String randomSlangWordKey = dictionary.keySet().toArray()[random.nextInt(dictionary.keySet().toArray().length)].toString();
        JLabel randomSlangWordLabel = new JLabel(randomSlangWordKey);
        randomSlangWordLabel.setForeground(new Color(0, 0, 220));
        randomSlangWordLabel.setFont(new Font("Serif", Font.PLAIN, 28));

        JLabel definitionLabel = new JLabel(" ==> " + dictionary.get(randomSlangWordKey));
        definitionLabel.setFont(new Font("Serif", Font.PLAIN, 22));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(randomSlangWordLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(definitionLabel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(24,30,0,0));
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
