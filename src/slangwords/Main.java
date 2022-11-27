package slangwords;

import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    /**
     * Using HashMap in order to enhance the searching time
     *
     */
    HashMap<String, String> dictionary;
    JPanel contentPanel;
    public static void main(String[] args) throws IOException {
        new Main();
    }
    public Main() throws IOException {
        // load the data at the beginning in order to have faster loading data require
        loadData();
        addComponents();
        setTitle("Slang Words");
        setVisible(true);
    }

    // Reference: Slide Week03 JavaIO - Nguyen Van Khiet
    public void loadData() throws IOException {
        // load the data from previous running
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dictionary.DAT"));
            // convert read object to HashMap<String, String>
            dictionary = (HashMap<String, String>)ois.readObject();
            ois.close();
        } catch (Exception ex) {
            dictionary = new HashMap<String, String>();
            try {
                BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
                // read and skip the first line data
                br.readLine();
                String line = ""; // line reading
                while((line = br.readLine()) != null){
                    String[] lineSplitData = line.split("`");
                    // receive the right format of dictionary -> HashMap<String, String>
                    if (lineSplitData.length == 2) {
                        // [0]: short hand of slang words, [1]: definition of slang words
                        dictionary.put(lineSplitData[0], lineSplitData[1]);
                    }
                }
                System.out.println("Read successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addComponents() {
        JFrame frame = new JFrame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("SLANG WORDS DICTIONARY", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setForeground(new Color(102, 0, 255));


        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        JButton functionButton01 = new JButton("Find slang word");
        functionButton01.setFocusable(false);
        functionButton01.setBackground(new Color(126, 138, 151));
        functionButton01.setOpaque(true);
        functionButton01.setBorderPainted(false);
        functionButton01.addActionListener(e -> refreshFrameWithNewContent(new findSlangWord(dictionary)));


        JButton functionButton02 = new JButton("Find by definition");
        functionButton02.setFocusable(false);
        functionButton02.setBackground(new Color(126, 138, 151));
        functionButton02.setOpaque(true);
        functionButton02.setBorderPainted(false);
        functionButton02.addActionListener(e -> refreshFrameWithNewContent(new findByDefinition(dictionary)));

        JButton functionButton03 = new JButton("History");
        functionButton03.setFocusable(false);
        functionButton03.setBackground(new Color(126, 138, 151));
        functionButton03.setOpaque(true);
        functionButton03.setBorderPainted(false);
        functionButton03.addActionListener(e -> refreshFrameWithNewContent(new viewSearchingHistory()));

        JButton functionButton04 = new JButton("Add slang word");
        functionButton04.setFocusable(false);
        functionButton04.setBackground(new Color(126, 138, 151));
        functionButton04.setOpaque(true);
        functionButton04.setBorderPainted(false);
        functionButton04.addActionListener(e -> refreshFrameWithNewContent(new addSlangWord(dictionary)));

        JButton functionButton05 = new JButton("Edit slang word");
        functionButton05.setFocusable(false);
        functionButton05.setBackground(new Color(126, 138, 151));
        functionButton05.setOpaque(true);
        functionButton05.setBorderPainted(false);
        functionButton05.addActionListener(e -> refreshFrameWithNewContent(new editSlangWord(dictionary)));

        JButton functionButton06 = new JButton("Delete slang word");
        functionButton06.setFocusable(false);
        functionButton06.setBackground(new Color(126, 138, 151));
        functionButton06.setOpaque(true);
        functionButton06.setBorderPainted(false);
        functionButton06.addActionListener(e -> refreshFrameWithNewContent(new deleteSlangWord(dictionary)));

        JButton functionButton07 = new JButton("Reset");
        functionButton07.setFocusable(false);
        functionButton07.setBackground(new Color(126, 138, 151));
        functionButton07.setOpaque(true);
        functionButton07.setBorderPainted(false);
        functionButton07.addActionListener(e -> refreshFrameWithNewContent(new resetSlangWordDictionary(dictionary)));

        JButton functionButton08 = new JButton("Random slang");
        functionButton08.setFocusable(false);
        functionButton08.setBackground(new Color(126, 138, 151));
        functionButton08.setOpaque(true);
        functionButton08.setBorderPainted(false);
        functionButton08.addActionListener(e -> refreshFrameWithNewContent(new randomSlangWord(dictionary)));

        JButton functionButton09 = new JButton("Game 1");
        functionButton09.setFocusable(false);
        functionButton09.setBackground(new Color(126, 138, 151));
        functionButton09.setOpaque(true);
        functionButton09.setBorderPainted(false);
        functionButton09.addActionListener(e -> refreshFrameWithNewContent(new funnyGame01(dictionary)));

        JButton functionButton10 = new JButton("Game 2");
        functionButton10.setFocusable(false);
        functionButton10.setBackground(new Color(126, 138, 151));
        functionButton10.setOpaque(true);
        functionButton10.setBorderPainted(false);
        functionButton10.addActionListener(e -> refreshFrameWithNewContent(new funnyGame02(dictionary)));

        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new GridLayout(10, 1, 5, 5));
        buttonContainer.add(functionButton01);
        buttonContainer.add(functionButton02);
        buttonContainer.add(functionButton03);
        buttonContainer.add(functionButton04);
        buttonContainer.add(functionButton05);
        buttonContainer.add(functionButton06);
        buttonContainer.add(functionButton07);
        buttonContainer.add(functionButton08);
        buttonContainer.add(functionButton09);
        buttonContainer.add(functionButton10);
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));

        // content panel (for changing the view with functions)
        contentPanel = new JPanel();

        menuPanel.add(buttonContainer, BorderLayout.PAGE_START);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        mainPanel.add(titleLabel, BorderLayout.PAGE_START);
        mainPanel.add(menuPanel, BorderLayout.LINE_START);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(700, 500));
        setContentPane(mainPanel);
        pack();

        setVisible(true);

        // Save dictionary before closing -> history of user
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                windowClosingHandler();
            }
        });
    }

    void refreshFrameWithNewContent(JPanel newPanelView) {
        remove(contentPanel);
        add(contentPanel = newPanelView);
        validate();
    }

    void windowClosingHandler() {
        // Save dictionary before closing
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Dictionary.DAT"));
            oos.writeObject(dictionary);
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        viewSearchingHistory.saveToHistoryFile();
    }
}