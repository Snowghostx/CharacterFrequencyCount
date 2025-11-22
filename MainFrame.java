import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{
    // Use this class really only once, should set up the frame, the look and feel, and menubar
    // menu items should be addable so have a add() button i think.

    public JMenuBar mb;
    public JMenu menu;

    public MainFrame() {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // Frame
        setTitle("Chinese Learning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure "close" closes
        setSize(1280, 800); //size of frame's window
        setLocationRelativeTo(null); // center's frame

        // Menu bar
        mb = new JMenuBar();
        setJMenuBar(mb);
        this.menu = new JMenu("Options");
        mb.add(menu);

        // Icon
        try {
            File imageFile = new File("images/ProgramIcon.png");
            BufferedImage image = ImageIO.read(imageFile);
            setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no icon image");
        }

        setVisible(true);
    };

    public void setUpPanel(JPanel givenPanel,String title){
        // Adding Panel
        add(givenPanel);

        // Adding corresponding menu Item
        JMenuItem menuItem = new JMenuItem(title);
        this.menu.add(menuItem);

    }

    // Test
    public void makeMenuItem(String title,String actionContent){
        JMenuItem menuItem = new JMenuItem(title);
        this.menu.add(menuItem);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,actionContent);
            }
        });
    }

    public void makeMenuItemAndPanelAction(String title,JPanel givenPanel){
        JMenuItem menuItem = new JMenuItem(title);
        this.menu.add(menuItem);

        // Add your panel to the frame
        add(givenPanel);
        givenPanel.setVisible(false);

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                givenPanel.setVisible(!givenPanel.isVisible());
            }
        });
    }





}
