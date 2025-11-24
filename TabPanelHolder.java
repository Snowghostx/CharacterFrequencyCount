import javax.swing.*;

public class TabPanelHolder extends JTabbedPane {
    public JTabbedPane pane;


    public TabPanelHolder() {
        pane = new JTabbedPane();
        setVisible(true);
    }

    public void addPanel(String title,JPanel panel){
        add(title,panel);
        // get into habit of adding these so that once they're added we "reload" the look so
        // we're not waiting for the user to just click to initiate a "reload".
        getParent().revalidate();
        getParent().repaint();
    }
}
