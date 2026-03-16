import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableStudyPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private Font chineseFont = new Font("Noto Sans CJK SC", Font.BOLD, 24);

    public TableStudyPanel(){
        setBorder(new EmptyBorder(20,20,20,20));

        String[] ColumnLabels = {"Character", "Frequency Count"};
        model = new DefaultTableModel(ColumnLabels, 0);

        table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(chineseFont);
        table.getTableHeader().setFont(chineseFont);
        add(table);
    }
}
