package slangwords;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class Main extends JFrame {

    /**
     * HashMap give faster searching
     */
    HashMap<String, String> dictionary;

    JPanel contentPanel;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        addComponents();
        setTitle("Slang Words");
    }

    public void addComponents() {
        JPanel title = new JPanel();
        title.setBounds(0,0,700,75);
        title.setBackground(Color.WHITE);
        JLabel titleText = new JLabel("SLANG WORDS DICTIONARY");
        titleText.setFont(new Font("Serif", Font.PLAIN, 24));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setVerticalAlignment(JLabel.CENTER);
        title.add(titleText);

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(10, 0, 0 ,5));
        menu.setBounds(0,0,150,350);
        menu.setBackground(Color.WHITE);
        JButton functionButton01 = new JButton("Find slang words"); functionButton01.setFocusable(false);
        JButton functionButton02 = new JButton("Find by definition"); functionButton02.setFocusable(false);
        JButton functionButton03 = new JButton("History"); functionButton03.setFocusable(false);
        JButton functionButton04 = new JButton("Add slang word"); functionButton04.setFocusable(false);
        JButton functionButton05 = new JButton("Edit slang word"); functionButton05.setFocusable(false);
        JButton functionButton06 = new JButton("Delete slang word"); functionButton06.setFocusable(false);
        JButton functionButton07 = new JButton("Reset"); functionButton07.setFocusable(false);
        JButton functionButton08 = new JButton("Random a slang"); functionButton08.setFocusable(false);
        JButton functionButton09 = new JButton("Funny game 1"); functionButton09.setFocusable(false);
        JButton functionButton10 = new JButton("Funny game 2"); functionButton10.setFocusable(false);
        menu.add(functionButton01);
        menu.add(functionButton02);
        menu.add(functionButton03);
        menu.add(functionButton04);
        menu.add(functionButton05);
        menu.add(functionButton06);
        menu.add(functionButton07);
        menu.add(functionButton08);
        menu.add(functionButton09);
        menu.add(functionButton10);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.BLUE);


        JPanel footer = new JPanel();
        JLabel footerText = new JLabel("Hàn Thọ Nhật Phú - 20127591 - Introduction to Java - 20KTPM02");
        footerText.setFont(new Font("Serif", Font.BOLD, 14));
        footer.add(footerText);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Slang words");
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(title, BorderLayout.NORTH);
        frame.add(menu, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);

    }
}