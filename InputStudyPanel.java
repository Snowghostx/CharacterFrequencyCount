import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.TreeMap;

public class InputStudyPanel extends JPanel {
    // Need input field
    // Need button to "submit" response
    // text area? to display character

    public InputStudyPanel(){
        // Panel settings
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(20,20,20,20));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        // Character Label
        JLabel currentCharacter = new JLabel("...");
        currentCharacter.setAlignmentX(CENTER_ALIGNMENT);
        currentCharacter.setHorizontalAlignment(SwingConstants.CENTER);
        currentCharacter.setPreferredSize(new Dimension(200,150));
        currentCharacter.setMaximumSize(currentCharacter.getPreferredSize());
        currentCharacter.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 50));
        currentCharacter.setBorder(new BevelBorder(1));

        // Input text
        JTextField textField = new JTextField("type pinyin here");
        textField.setForeground(Color.GRAY);
        textField.setAlignmentX(CENTER_ALIGNMENT); // Centers the COMPONENT
        textField.setHorizontalAlignment(SwingConstants.CENTER); // Centers the TEXT;
        textField.setPreferredSize(new Dimension(200,30));
        textField.setMaximumSize(textField.getPreferredSize()); // needed for boxlayout

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Remove placeholder text when the user clicks into the text field
                if (textField.getText().equals("type pinyin here")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);  // Change text color back to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // If the text field is empty, set the placeholder text back
                if (textField.getText().isEmpty()) {
                    textField.setText("type pinyin here");
                    textField.setForeground(Color.GRAY);  // Placeholder color
                }
            }
        });

        // Button
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(CENTER_ALIGNMENT);
        submitButton.setPreferredSize(new Dimension(400, 50));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));

        //----------------------------------------------------------------------------------
        add(currentCharacter);
        add(Box.createVerticalStrut(20));
        add(textField);
        add(Box.createVerticalStrut(20));
        add(submitButton);
    }

    private static JTextField createTextField(){
        // Input text
        JTextField textField = new JTextField("type pinyin here");
        textField.setForeground(Color.GRAY);
        textField.setAlignmentX(CENTER_ALIGNMENT); // Centers the COMPONENT
        textField.setHorizontalAlignment(SwingConstants.CENTER); // Centers the TEXT;
        textField.setPreferredSize(new Dimension(200,30));
        textField.setMaximumSize(textField.getPreferredSize()); // needed for boxlayout

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Remove placeholder text when the user clicks into the text field
                if (textField.getText().equals("type pinyin here")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);  // Change text color back to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // If the text field is empty, set the placeholder text back
                if (textField.getText().isEmpty()) {
                    textField.setText("type pinyin here");
                    textField.setForeground(Color.GRAY);  // Placeholder color
                }
            }
        });

        return textField;
    }



}
