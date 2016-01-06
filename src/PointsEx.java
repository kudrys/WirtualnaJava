import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class PointsEx extends JFrame {

    Surface surface;

    public PointsEx() {
        surface = new Surface();
    }

    public void addSurface(Surface surface){
        this.surface = surface;
    }

    public void initUI() {

        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override



            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main2(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                PointsEx ex = new PointsEx();
                ex.initUI();
                ex.setVisible(true);
            }
        });
    }
}