import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Random;

public class Surface extends JPanel implements ActionListener, MouseMotionListener {
    private Swiat surfaceSwiat;
    private final int DELAY = 10;
    private Timer timer;

    private int offsetY = 100;
    private int offsetX = 20;
    private int imgHeight = 20;
    private int imgWidth = 20;

    Surface() {
        initTimer();
    }

    void addSwiat(Swiat s){
        surfaceSwiat = s;
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    Timer getTimer() {
        return timer;
    }

    private void doDrawing(Graphics g) {
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX());
                final int[] coordinates = surfaceConvert(e.getX(), e.getY());
                if(coordinates[0] != -1 && coordinates[1] != -1){
                    System.out.println("prawda kek");
                }
            }
        });

        Graphics2D g2d = (Graphics2D) g;
        narysujObrazek(g2d);
        //button();
        Image img1 = Toolkit.getDefaultToolkit().getImage("legenda.png");

            g2d.drawImage(img1, 0, 0, this);

    }

    private void narysujObrazek(Graphics2D g2d) {
        Node n = surfaceSwiat.k.first;

        while(n!=null){
            rysujZwierzaka(n, g2d);
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

    private void button(Graphics g){
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

    private void rysujZwierzaka(Node n, Graphics2D g2d){

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


    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private int[] surfaceConvert(int X, int Y){

        int swiatX = (X - offsetX - 1) / imgWidth;
        int swiatY = (Y - offsetY - 1) / imgHeight;
        swiatX = (swiatX >= 0 && swiatX < surfaceSwiat.m.szerokosc )? swiatX : -1;
        swiatY = (swiatY >= 0 && swiatY < surfaceSwiat.m.wysokosc )? swiatY : -1;
        System.out.println("X:" + swiatX);
        System.out.println("Y:" + swiatY);
        int[] koordynaty = {swiatX, swiatY};
        return koordynaty;
    }
}