import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class Subsection {
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    private String[] ColumnLabels;
    private Font chineseFont = new Font("Noto Sans CJK SC", Font.BOLD, 24);

    public Subsection(){
        // Text Area
        /*
        JTextArea outputText = new JTextArea();
        outputText.setEditable(false); // read only
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        //JScrollPane scrollPane = new JScrollPane(outputText);
        */
        // Table Idea
        ColumnLabels = new String[]{"Character", "Frequency Count"};
        model = new DefaultTableModel(ColumnLabels,0);
        table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(chineseFont);
        table.getTableHeader().setFont(chineseFont);

        // Scroll Pane
        scrollPane = new JScrollPane(table);
        scrollPane.setVisible(false); // start out off so once generate is hit it will turn on.

    }

    public void createFrequencyCount(TreeMap<Character,Integer> freqCount){
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
    }
}
