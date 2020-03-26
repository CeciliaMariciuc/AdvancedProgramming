import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int Width = 800, Height = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, Width, Height);
    }

    private void init() {
        setPreferredSize(new Dimension(Width, Height));
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Random random = new Random();
        int redValue = random.nextInt(255);
        int greenValue = random.nextInt(255);
        int blueValue = random.nextInt(255);
        int opacity = random.nextInt(255);
        int radius = random.nextInt(200);
        int sides = (int) frame.configPanel.getSidesField().getValue();
        Color color = new Color(redValue, greenValue, blueValue, opacity); //transparent random Color.
        if ("Black".equals((String) frame.configPanel.colorCombo.getSelectedItem())) {
            graphics.setColor(new Color(0,0,0));
        } else {
            graphics.setColor(color);
        }
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, Width, Height);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}