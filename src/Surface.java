import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 10;
    private Timer timer;

    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.green);
        g2d.setBackground(Color.black);
        int w = getWidth();
        int h = getHeight();

        Random r = new Random();

        for (int i = 0; i < 2000; i++) {
            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            g2d.drawRect(x,y,10,10);
            //g2d.drawLine(x, y, x+5, y+5);
        }
    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}