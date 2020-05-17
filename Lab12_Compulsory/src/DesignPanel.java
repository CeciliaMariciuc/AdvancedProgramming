import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    final static int Width = 800, Height = 600;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
        repaint();
    }

    private void init() {
        setPreferredSize(new Dimension(Width, Height));
        setBackground(Color.WHITE);
        setLayout(null);
    }

    void addComponent(JComponent component) {
        int width = component.getPreferredSize().width;
        int height = component.getPreferredSize().height;
        Random random = new Random();
        Insets insets = this.getInsets();
        component.setBounds(random.nextInt(Width) + insets.left, random.nextInt(Height) + insets.top, width, height);
        component.setToolTipText(component.getClass().getName());
        this.add(component);
        repaint();
        frame.pack();
    }

}
