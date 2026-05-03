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
 * Given a .txt or .srt file even, a visual table will be generated of the character and how many times it appears in the file.
 * This can give a user looking to study characters based on their frequency, this is a visual aid that provides a direction in what
 * they should prioritize in their studies.
 */
public class Main {
    public static void main(String[] args) {
        // Create Elements of the UI
        MainFrame mFrame = new MainFrame();
        FrequencyPanel frequencyPanel = new FrequencyPanel();
        HomePanel homePanel = new HomePanel();

        // Create Objects
        // Set Menu Action
        mFrame.makeMenuItemWithAction("Select Vocab List", new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                File selectedFile; // Create File Object
                frequencyPanel.clearTable(); // Reset visual table

                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(mFrame);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    selectedFile = fileChooser.getSelectedFile();

                    // Perform Frequency Panel Functions on selected file
                    System.out.println("File Selected: " + selectedFile.getAbsolutePath());
                    frequencyPanel.createFrequencyCount(readFile(selectedFile));
                    //frequencyPanel.frequencyCountSortedByFreq(readFile(selectedFile));

                    // Notify user of file status
                    JOptionPane.showMessageDialog(null,"File loaded: " + selectedFile.getName());
                } else {
                    // Notify user of file status
                    System.out.println("No file selected.");
                    JOptionPane.showMessageDialog(null,"No File Loaded.");
                }

            }
        });

        // Testing Text File
        //File txtFile = new File("src/characters.txt");
        //frequencyPanel.createFrequencyCount(readFile(selectedFile));
        //frequencyPanel.frequencyCountSortedByFreq(readFile(selectedFile));

        // Final Visual Placements
        TabPanelHolder tabHolder = new TabPanelHolder();
        tabHolder.add("Home",homePanel);
        tabHolder.add("Freq",frequencyPanel);
        mFrame.add(tabHolder);
        mFrame.revalidate();
        mFrame.repaint();







    }

    /**
     * This function is meant to be used after a file is successfully selected.
     * Taking in a file, the function will create a TreeMap with the key type Character and value type integer. It will then read the file, processing each line
     * by removing everything that is not a chinese character with empty string. It will then process this line of characters to an array, followed up by looping
     * through the array. Each iteration will check if the character is already in the TreeMap, if it is, it will increase the value, if it isn't it will start
     * the count at 1.
     *
     * Where n is the amount of characters in the entire text file. This cannot be more optimized because every character must be read.
     * @param file a .txt, or .srt file
     * @return TreeMap of characters (key) and their total appearances (value).
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