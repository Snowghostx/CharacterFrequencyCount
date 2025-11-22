import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{
    // Use this class really only once, should set up the frame, the look and feel, and menubar
    // menu items should be addable so have a add() button i think.

    public JMenuBar mb;


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

    private void setUpPanel(Subsection ) {

    }
}
