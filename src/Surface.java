import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
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

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        narysujObrazek(g2d);
        //button();
        Image img1 = Toolkit.getDefaultToolkit().getImage("legenda.png");
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            g2d.drawImage(img1, 0, 0, this);

    }

    public void narysujObrazek(Graphics2D g2d) {
        Node n = surfaceSwiat.k.first;

        while(n!=null){
            rysuj(n, g2d);
            n = n.next;
        }
        surfaceSwiat.k.reset();
    }

    /**
     * http://www.tutorialspoint.com/swing/swing_jbutton.htm
     */
    public void tura(Node kek){
        if(surfaceSwiat.k.aktualnyNode !=null){
            surfaceSwiat.k.next();
            if(surfaceSwiat.k.aktualnyNode==null)
                kek = surfaceSwiat.k.first;
            else
                kek = kek.next;
            surfaceSwiat.tura(kek.organizm);
        }
        //surfaceSwiat.k.reset();
    }

    public void button(Graphics g){
        JButton button = new JButton("RUNDA");
        button.setBounds(10, 535, 80,30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //tura(kek);
                while(button.getModel().isEnabled() && surfaceSwiat.k.aktualnyNode !=null){
                    Organizm temp = surfaceSwiat.k.aktualnyNode.organizm;
                    surfaceSwiat.k.next();
                    surfaceSwiat.tura(temp);
                }
                //surfaceSwiat.k.reset();
                doDrawing(g);
            }
        });
        add(button);
    }

    private void rysuj(Node n, Graphics2D g2d){
        int offsetY = 100;
        int offsetX = 20;
        int imgHeight = 20;
        int imgWidth = 20;

        String nazwa_obrazka = n.organizm.getLabel() + ".png";

        Image img1 = Toolkit.getDefaultToolkit().getImage(nazwa_obrazka);
        int x = n.organizm.getX();
        int y = n.organizm.getY();
        g2d.drawImage(img1, x*imgWidth+offsetX, y*imgHeight+offsetY, this);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
        button(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}