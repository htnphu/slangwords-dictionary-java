package slangwords;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.border.EmptyBorder;
public class funnyGame02 extends JPanel{
    /**
     * Attribute: Dictionary
     */
    HashMap<String, String> newDictionary;
    int point = 0;
    JLabel pointLabel;
    JLabel questionLabel;
    JButton[] answerButton;
    int answer;

    public funnyGame02(HashMap<String, String> dictionary) {
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

        JPanel answersPanel = new JPanel(new GridLayout(4, 1, 10, 10 ));

        answerButton = new JButton[4];
        answerButton[0] = new JButton(); answerButton[0].setFocusable(false);
        answerButton[0].addActionListener(e -> answerButtonHandler(0, pointLabel));
        answerButton[1] = new JButton(); answerButton[1].setFocusable(false);
        answerButton[1].addActionListener(e -> answerButtonHandler(1, pointLabel));
        answerButton[2] = new JButton(); answerButton[2].setFocusable(false);
        answerButton[2].addActionListener(e -> answerButtonHandler(2, pointLabel));
        answerButton[3] = new JButton(); answerButton[3].setFocusable(false);
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
        // answer: [0;3]
        answer = random.nextInt(3);
        for (int idx = 0; idx < 4; idx++) {
            String randomWordKey = newDictionary.keySet().toArray()[random.nextInt(newDictionary.keySet().toArray().length)].toString();
            if (idx == answer) {
                questionLabel.setText(newDictionary.get(randomWordKey));
            }
            answerButton[idx].setText(randomWordKey);
        }
    }

    void answerButtonHandler(int userAnswer, JLabel pointLabel) {
        if (userAnswer == answer) {
            JOptionPane.showMessageDialog(this, "Correct!", "Correct ", JOptionPane.INFORMATION_MESSAGE);
            point += 1;
            String pointString = Integer.toString(point);
            pointLabel.setText("Your point: " + pointString);
        }
        else {
            JOptionPane.showMessageDialog(this, "Wrong! The answer is " + answerButton[answer].getText(),
                    "Wrong answer",
                    JOptionPane.ERROR_MESSAGE);
            point -= 1;
            String pointString = Integer.toString(point);
            pointLabel.setText("Your point: " + pointString);
        }
        // create new question after user finished a question
        createQuestion();
    }
}
