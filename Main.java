import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        TableStudyPanel tableStudyPanel = new TableStudyPanel();
        FrequencyPanel frequencyPanel = new FrequencyPanel();
        HomePanel homePanel = new HomePanel();
        InputStudyPanel studyPanel1 = new InputStudyPanel();

        mFrame.makeMenuItem("Dialog 1","idk bruh");
        mFrame.makeMenuItem("Dialog 2","um...");


        // Any Set Up
        CCharacter[] currentCharacterList;
        File vocabListTextFile;
        mFrame.makeMenuItemWithAction("Select Vocab List", new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(mFrame);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    // implement check if txt file
                    System.out.println("File Selected: " + selectedFile.getAbsolutePath());
                } else {
                    System.out.println("No file selected.");
                }

                JOptionPane.showMessageDialog(null,"TESTING");

            }
        });


        File txtFile = new File("src/characters.txt");
        frequencyPanel.createFrequencyCount(readFile(txtFile));
        frequencyPanel.frequencyCountSortedByFreq(readFile(txtFile));

        // Final Visual Placements
        TabPanelHolder tabHolder = new TabPanelHolder();
        tabHolder.add("Home",homePanel);
        tabHolder.add("Freq",frequencyPanel);
        tabHolder.add("Input Study",studyPanel1);
        tabHolder.add("Table Study", tableStudyPanel);
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

    /*public static TreeMap<CCharacter, String> processToCharacterMap(File file){
        TreeMap<CCharacter, String> characterMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                String[] processedLine = line.split(";");
                System.out.println(processedLine[0]);
                System.out.println(processedLine[1]);
                CCharacter newCharacter = new CCharacter(processedLine[0],processedLine[1],processedLine[2]);

                characterMap.put(newCharacter,);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"There is no text file.");
        }
        return characterMap;
    }*/





}