import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField className = new JTextField(35);
    JTextField defaultText = new JTextField(35);
    JButton addButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(new JLabel("Specify class name:"));
        add(className);
        add(new JLabel("Default text:"));
        add(defaultText);
        add(addButton);
        addButton.addActionListener(this::addComponent);
    }

    private void addComponent(ActionEvent actionEvent) {
        try {
            Class clazz = Class.forName("javax.swing."+className.getText());
            Component component = (Component) clazz.getConstructor().newInstance();

            Method method = clazz.getMethod("setText", String.class);
            method.invoke(component, defaultText.getText());
            frame.designPanel.addComponent((JComponent) component);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
