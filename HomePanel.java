import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class HomePanel extends JPanel {
    // treat as "mini" frame, add everything to panel, that way when i add the panel to frame it should be fine





    public HomePanel() {
        // Text Area
        /*
        JTextArea outputText = new JTextArea();
        outputText.setEditable(false); // read only
        outputText.setLineWrap(true);
        outputText.setWrapStyleWord(true);
        //JScrollPane scrollPane = new JScrollPane(outputText);
        */
        // functions ARE the panel already
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Welcome.");
        label.setPreferredSize(new Dimension(200, 50));
        label.setFont(new Font("Arial", Font.BOLD, 50));

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        add(label);
    }

}
