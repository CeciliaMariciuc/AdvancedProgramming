import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JComboBox shapesCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String colors[] = {"Random", "Black"};
        String shapes[] = {"RegularPolygon", "RegularCircle"};
        colorCombo = new JComboBox(colors);
        shapesCombo = new JComboBox(shapes);
        add(shapesCombo);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

}