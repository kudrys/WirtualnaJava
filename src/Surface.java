import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Surface extends JPanel implements ActionListener {
    public Swiat surfaceSwiat;
    private final int DELAY = 10;
    private Timer timer;


    public Surface() {

        initTimer();
    }

    public void addSwiat(Swiat s){
        surfaceSwiat = s;
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
            //g2d.drawRect(x,y,10,10);
            //g2d.drawLine(x, y, x+5, y+5);
        }

        Node n = surfaceSwiat.k.first;

        while(n!=null){
            rysuj(n, g2d);
            n=n.next;
        }



        //Image img1 = Toolkit.getDefaultToolkit().getImage("legenda.png");
        //g2d.drawImage(img1, 0, 0, this);
    }

    private void rysuj(Node n, Graphics2D g2d){
        int offsetY = 100;
        int imgHeight = 20;
        int imgWidth = 20;

        String nazwa_obrazka = n.organizm.getLabel() + ".png";

        Image img1 = Toolkit.getDefaultToolkit().getImage(nazwa_obrazka);
        int x = n.organizm.getX();
        int y = n.organizm.getY();
        g2d.drawImage(img1, x*imgWidth, y*imgHeight+offsetY, this);
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