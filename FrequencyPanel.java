import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyPanel extends JPanel {
    // treat as "mini" frame, add everything to panel, that way when i add the panel to frame it should be fine
    private JTable table;
    private DefaultTableModel model;
    private Font chineseFont = new Font("Noto Sans CJK SC", Font.BOLD, 24);
    private JScrollPane scrollPane;

    public JButton generate;



    public FrequencyPanel(){
        // Text Area
        /*
        JTextArea outputText = new JTextArea();
        outputText.setEditable(false); // read only
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        //JScrollPane scrollPane = new JScrollPane(outputText);
        */
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20,20,20,20));

        String[] ColumnLabels = {"Character", "Frequency Count"};
        model = new DefaultTableModel(ColumnLabels, 0);

        table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(chineseFont);
        table.getTableHeader().setFont(chineseFont);

        scrollPane = new JScrollPane(table);

        // Button Panel (place options down here)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Buttons (will make function createButton() later so only the actions have to be here)
        generate = new JButton("Generate");
        generate.setPreferredSize(new Dimension(100, 30));
        buttonPanel.add(generate);


        add(buttonPanel, BorderLayout.PAGE_END);
        add(scrollPane, BorderLayout.CENTER);
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

}
