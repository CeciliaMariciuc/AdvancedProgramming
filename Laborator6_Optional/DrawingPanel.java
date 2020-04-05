import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int Width = 800, Height = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    List<Shape> drawnShapes;
    List<Color> colorShapes;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        drawnShapes = new ArrayList<>();
        colorShapes = new ArrayList<>();
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
        setBorder(BorderFactory.createEtchedBorder());
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
        Color color = new Color(redValue, greenValue, blueValue, opacity);
        if ("Black".equals((String) frame.configPanel.colorCombo.getSelectedItem())) {
            colorShapes.add(new Color(0, 0, 0));
            graphics.setColor(new Color(0, 0, 0));
        } else {
            colorShapes.add(color);
            graphics.setColor(color);
        }

        if ("RegularPolygon".equals((String) frame.configPanel.shapesCombo.getSelectedItem())) {
            RegularPolygon regularPolygon = new RegularPolygon(x, y, radius, sides);
            drawnShapes.add(regularPolygon);
            graphics.fill(regularPolygon);
        } else if ("RegularCircle".equals((String) frame.configPanel.shapesCombo.getSelectedItem())) {
            RegularCircle regularCircle = new RegularCircle(x, y, radius);
            regularCircle.setRadius(radius);
            regularCircle.setX0(x);
            regularCircle.setY0(y);
            drawnShapes.add(regularCircle);
            graphics.fill(regularCircle);
        }

}

    @Override
    public void update(Graphics graphics) {
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, Width, Height);
        int count = 0;
        for (Shape shape : drawnShapes) {
            this.graphics.setColor(this.colorShapes.get(count));
            this.graphics.fill(shape);
            count++;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}