package slangwords;

import java.util.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

public class funnyGame01 extends JPanel {
    HashMap<String, String> newDictionary;
    int answer;
    int point = 0;
    JLabel pointLabel;
    JLabel questionLabel;
    JButton[] answerButton;
    public funnyGame01(HashMap<String, String> dictionary) {
        JPanel pointPanel = new JPanel();
        String pointString = Integer.toString(point);
        pointLabel = new JLabel("Your point: " + pointString);
        pointLabel.setFont(new Font("Serif", Font.BOLD, 20));
        pointPanel.add(pointLabel);
        this.newDictionary = dictionary;

        JPanel questionPanel = new JPanel();
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 28));
        questionLabel.setForeground(new Color(0, 0, 220));
        questionPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        questionPanel.add(questionLabel);

        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 10, 10 ));
        answerButton = new JButton[4];
        answerButton[0] = new JButton();
        answerButton[0].addActionListener(e -> answerButtonHandler(0, pointLabel));
        answerButton[1] = new JButton();
        answerButton[1].addActionListener(e -> answerButtonHandler(1, pointLabel));
        answerButton[2] = new JButton();
        answerButton[2].addActionListener(e -> answerButtonHandler(2, pointLabel));
        answerButton[3] = new JButton();
        answerButton[3].addActionListener(e -> answerButtonHandler(3, pointLabel));
        answersPanel.add(answerButton[0]);
        answersPanel.add(answerButton[1]);
        answersPanel.add(answerButton[2]);
        answersPanel.add(answerButton[3]);

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        add(pointPanel, BorderLayout.PAGE_END);
        add(questionPanel, BorderLayout.PAGE_START);
        add(answersPanel, BorderLayout.CENTER);
        createQuestion();
    }

    void createQuestion() {
        Random random = new Random();
        answer = random.nextInt(3);
        for (int i = 0; i < 4; i++) {
            String randomKey = newDictionary.keySet().toArray()[random.nextInt(newDictionary.keySet().toArray().length)].toString();
            if (i == answer) {
                questionLabel.setText(randomKey);
            }
            answerButton[i].setText(newDictionary.get(randomKey));
        }
    }

    void answerButtonHandler(int choice, JLabel pointLable) {
        if (choice == answer) {
            JOptionPane.showMessageDialog(this,
                    "Correct!",
                    "Correct",
                    JOptionPane.INFORMATION_MESSAGE);
            point += 1;
            String pointString = Integer.toString(point);
            pointLable.setText("Your point: " + pointString);
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Wrong! The answer is " + answerButton[answer].getText(),
                    "Wrong answer",
                    JOptionPane.ERROR_MESSAGE);
        }
        // create new question after user finished a question
        createQuestion();
    }
}
