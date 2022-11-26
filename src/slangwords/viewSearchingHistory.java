package slangwords;

import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class viewSearchingHistory extends JPanel {
    private static Vector<String> historyDataVector = new Vector<>();
    JLabel slangWordLabel;

    public viewSearchingHistory() {
        // History List
        JList<String> historyList = new JList<>(historyDataVector);
        slangWordLabel = new JLabel();
        slangWordLabel.setForeground(Color.GREEN);
        slangWordLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        JPanel slangWordPanel = new JPanel();
        slangWordPanel.setLayout(new BoxLayout(slangWordPanel, BoxLayout.Y_AXIS));
        slangWordPanel.add(slangWordLabel);

        setLayout(new BorderLayout());
        add(new JLabel("History:"), BorderLayout.PAGE_START);
        add(new JScrollPane(historyList), BorderLayout.CENTER);
        add(slangWordPanel, BorderLayout.PAGE_END);
    }

    public static void addWordToHistory(String word) {
        // only add not exist word
        if (!historyDataVector.contains(word))
        {
            historyDataVector.add(word);
        }
    }

    public static void saveToHistoryFile() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("History.DAT"));
            objectOutputStream.writeObject(historyDataVector);
            objectOutputStream.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
