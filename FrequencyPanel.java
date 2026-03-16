import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FrequencyPanel extends JPanel {
    // treat as "mini" frame, add everything to panel, that way when i add the panel to frame it should be fine
    private JTable table;
    private DefaultTableModel model;
    private Font chineseFont = new Font("Noto Sans CJK SC", Font.BOLD, 24);
    private JScrollPane scrollPane;

    // Buttons
    public JButton generate;
    public JButton sortButton;


    public FrequencyPanel(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20,20,0,20)); // bottom is set to 0 to let the buttonpanel determine
        // Main Frequency Program Setup
        String[] ColumnLabels = {"Character", "Frequency Count"};
        model = new DefaultTableModel(ColumnLabels, 0);

        table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(chineseFont);
        table.getTableHeader().setFont(chineseFont);

        scrollPane = new JScrollPane(table);
        //--------------------------------------------------------------------
        // Button Panel (place options down here)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(5,5,0,5));

        // Buttons (will make function createButton() later so only the actions have to be here)
        // Generate Frequency Table Button
        generate = new JButton("Generate");
        generate.setFont(new Font("Arial", Font.BOLD, 15));
        generate.setPreferredSize(new Dimension(120, 30));
        buttonPanel.add(generate);

        // Sort by Frequency Button
        sortButton = new JButton("Sort by Freq.");
        sortButton.setFont(new Font("Arial", Font.BOLD, 10));
        sortButton.setPreferredSize(new Dimension(120, 30));
        buttonPanel.add(sortButton);
        //--------------------------------------------------------------------
        // Actualizations
        add(buttonPanel, BorderLayout.PAGE_END);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void clearTable() {
        this.model.setRowCount(0);
    }
    public void createFrequencyCount(TreeMap<Character,Integer> freqCount){
        // this just makes it so a button does it but tbh the contents will do it automatically outside of action
        // also it's sorted by character cuz it's a treemap now not a regular hashmap
        generate.addActionListener(new ActionListener() {
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
    }
    public void frequencyCountSortedByFreq(TreeMap<Character,Integer> freqCount){
        sortButton.addActionListener(new ActionListener() {
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
    }

}
