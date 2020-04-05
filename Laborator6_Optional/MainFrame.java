import javax.swing.*;

import static java.awt.BorderLayout.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        //arrange the components in the container (frame)
        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        pack();
    }
}
