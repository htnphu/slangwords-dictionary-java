package slangwords;

import java.io.*;
import java.util.*;
import javax.swing.*;
public class resetSlangWordDictionary extends JPanel {

    // Reference: Slide Week03 JavaIO - Nguyen Van Khiet
    public resetSlangWordDictionary(HashMap<String, String> dictionary) {
        JPanel notificationPanel = new JPanel();
        JOptionPane notification = new JOptionPane();
        dictionary.clear();
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
            System.out.println("Reset successfully");
            JOptionPane.showMessageDialog(notificationPanel,"Reset successfully: ");
            }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
