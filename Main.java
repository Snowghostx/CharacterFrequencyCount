import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Chinese Character Frequency Count
 *
 * Given a text with a list of characters, (usually i'm taking a .srt file and putting it in a txt file)
 * it will count the frequency of each character in the list.
 */

public class Main {
    public static void main(String[] args) {
        MainFrame mFrame = new MainFrame();
        FrequencyPanel frequencyPanel = new FrequencyPanel();
        HomePanel homePanel = new HomePanel();

        mFrame.makeMenuItem("Item 1","Item 1");
        mFrame.makeMenuItem("Item 2","Item 2");
        /*
        mFrame.makeMenuItemAndPanelAction("FreqPanel",frequencyPanel);
        mFrame.createHomePanel("Home",homePanel);
         */
        File txtFile = new File("src/characters.txt");
        frequencyPanel.createFrequencyCount(readFile((txtFile)));

        TabPanelHolder tabHolder = new TabPanelHolder();
        tabHolder.add("Home",homePanel);
        tabHolder.add("Freq",frequencyPanel);
        mFrame.add(tabHolder);
        mFrame.revalidate();
        mFrame.repaint();







    }

    /** This is where we actually process the text file into a map.
     *
     */
    public static TreeMap<Character,Integer> readFile(File file){
        TreeMap<Character, Integer> freqCount = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                // remove ALL THAT'S NOT CHINESE CHARACTERx (time stamps)
                String processedLine = line.replaceAll("[^\\p{IsHan}]","");

                char[] characters = processedLine.toCharArray();
                for(int i = 0; i < characters.length; i++){
                    if(freqCount.containsKey(characters[i])) {
                        freqCount.put(characters[i], freqCount.get(characters[i]) + 1);
                    } else {
                        freqCount.put(characters[i],1);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"There is no text file.");
        }
        return freqCount;
    }





}