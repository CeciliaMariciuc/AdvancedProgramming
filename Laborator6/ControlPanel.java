import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void reset(ActionEvent actionEvent) {
        frame.canvas.update(frame.canvas.graphics);
    }

    private void load(ActionEvent actionEvent) {

        JFileChooser chooser = new JFileChooser();
        // chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Alege o imagine: ");
        chooser.setAcceptAllFileFilterUsed(true);
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            {
                File file = chooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(file);
                    frame.canvas.graphics.drawImage(image, 0, 0, null);
                    frame.canvas.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void save(ActionEvent actionEvent) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\cecil\\OneDrive\\Desktop\\An_2\\Adv_Progr\\test_laborator.png"));
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }
}