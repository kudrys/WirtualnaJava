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
                surfaceSwiat.k.wypisz();
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
    public void buttonQuit(){
        JButton buttonQuit = new JButton("Quit");
        buttonQuit.setBounds(500,535,80,30);

        buttonQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonQuit);
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
        buttonQuit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}