import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PointsEx extends JFrame {

    Surface surface;
    //Swiat swiat;


    public PointsEx() {
        surface = new Surface();
    }

    public void addSurface(Surface surface){
        this.surface = surface;
    }

    public void initUI() {

        add(surface);
        surface.setLayout(null);
        

        addWindowListener(new WindowAdapter() {
            @Override



            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Zwierzecy Swiat");
        setSize(605, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main2(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                while(true) {
                    try {
                        Thread.sleep(1000);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    PointsEx ex = new PointsEx();

                    ex.initUI();
                    ex.setVisible(true);
                }
            }
        });
    }
}