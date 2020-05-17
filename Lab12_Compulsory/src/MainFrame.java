import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("Dynamic Swing Designer ");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
        add(designPanel, CENTER);
        add(controlPanel, NORTH);
        pack();
    }
}
