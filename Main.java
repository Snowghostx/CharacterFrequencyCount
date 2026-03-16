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
        // Create Elements of the UI
        MainFrame mFrame = new MainFrame();
        FrequencyPanel frequencyPanel = new FrequencyPanel();
        HomePanel homePanel = new HomePanel();

        // Create Objects
        // Set Menu Action
        mFrame.makeMenuItemWithAction("Select Vocab List", new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                // Reset visual table
                frequencyPanel.clearTable();

                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(mFrame);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();

                    // Perform Frequency Panel Functions on selected file
                    System.out.println("File Selected: " + selectedFile.getAbsolutePath());
                    frequencyPanel.createFrequencyCount(readFile(selectedFile));
                    frequencyPanel.frequencyCountSortedByFreq(readFile(selectedFile));
                } else {
                    System.out.println("No file selected.");
                }

                // Notify user
                JOptionPane.showMessageDialog(null,"File loaded.");

            }
        });

        // Testing Text file
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