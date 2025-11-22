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
        mFrame.makeMenuItem("Item 1","Item 1");
        mFrame.makeMenuItem("Item 2","Item 2");

        File txtFile = new File("src/characters.txt");





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

    /**
     * Creates the basic program including the frequency Count
     * @param freqCount
     */
    public static void createProgram(TreeMap<Character,Integer> freqCount) {
        // Text Area
        /*
        JTextArea outputText = new JTextArea();
        outputText.setEditable(false); // read only
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        //JScrollPane scrollPane = new JScrollPane(outputText);
        */
        // Table Idea
        String[] ColumnLabels = {"Character","Frequency Count"};
        DefaultTableModel model = new DefaultTableModel(ColumnLabels,0);
        JTable table = new JTable(model);
        Font chineseFont = new Font("Noto Sans CJK SC", Font.BOLD, 24);
        table.setRowHeight(35);
        table.setFont(chineseFont);
        table.getTableHeader().setFont(chineseFont);
        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVisible(false); // start out off so once generate is hit it will turn on.

        // this just makes it so a button does it but tbh the contents will do it automatically outside of action
        // also it's sorted by character cuz it's a treemap now not a regular hashmap

        // Menu Item Button
        JMenuItem mItem = new JMenuItem("Generate");
        mItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true); // turn it on
                //these are important to make sure it happens smoothly
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();

                int rowCount = table.getRowCount();
                for(Map.Entry entry : freqCount.entrySet()){
                    //System.out.println(entry.getKey() + " " + entry.getValue());
                    rowCount++;
                    String[] newRow = {String.valueOf(entry.getKey()), String.valueOf(entry.getValue())};
                    model.addRow(newRow);
                    //outputText.append(entry.getKey() + " " + entry.getValue()+ "\n");
                }
            }
        });
        JMenuItem mItem2 = new JMenuItem("Dominication");
        mItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon domRepFlag = new ImageIcon("images/Dominican-Republic-icon.png");
                JOptionPane.showMessageDialog(null, "KLK WAWAWA","Hola",JOptionPane.INFORMATION_MESSAGE,domRepFlag);
            }
        });

        // Window
        JMenu menu = new JMenu("Menu");
        menu.add(mItem);
        menu.add(mItem2);
        JMenuBar mb = new JMenuBar();
        mb.add(menu);

        // Frame
        JFrame frame = new JFrame("Chinese Learning");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure "close" closes
        frame.setSize(1280, 800); //size of frame's window
        frame.setLocationRelativeTo(null); // center's frame

        // Icon
        try {
            File imageFile = new File("images/ProgramIcon.png");
            BufferedImage image = ImageIO.read(imageFile);
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no icon image");
        }
        frame.setJMenuBar(mb);
        frame.setVisible(true);
        frame.add(scrollPane);
    }




}