import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    // Use this class really only once, should set up the frame, the look and feel, and menubar
    // menu items should be addable so have a add() button i think.
    public JFrame frame;
    public JMenu menu;
    public JMenuBar mb;

    public MainFrame() throws IOException {
        // Frame
        frame = new JFrame("Chinese Learning");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure "close" closes
        frame.setSize(1280, 800); //size of frame's window
        frame.setLocationRelativeTo(null); // center's frame
        // Base Window Contents
        menu = new JMenu("Menu");
        mb = new JMenuBar();
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
    };






}
