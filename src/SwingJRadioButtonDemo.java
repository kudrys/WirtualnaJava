import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 * A Swing program that demonstrates how to use JRadioButton component.
 *
 * @author www.codejava.net
 *
 */
public class SwingJRadioButtonDemo extends JFrame {

    private JButton buttonOK = new JButton("Jebaj");

    private JRadioButton optionLinux = new JRadioButton("Kurwa");
    private JRadioButton optionWin = new JRadioButton("Chuj");
    private JRadioButton optionMac = new JRadioButton("Pizda");

    private JLabel labelImage = new JLabel();


    public SwingJRadioButtonDemo() {
        super("Swing JRadioButton Demo");

        ButtonGroup group = new ButtonGroup();
        group.add(optionLinux);
        group.add(optionWin);
        group.add(optionMac);

        optionWin.setSelected(true);
        //labelImage.setIcon(iconWin);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        add(optionLinux, constraints);
        constraints.gridx = 1;
        add(optionWin, constraints);
        constraints.gridx = 2;
        add(optionMac, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;

        add(labelImage, constraints);

        constraints.gridy = 2;
        add(buttonOK, constraints);

        RadioButtonActionListener actionListener = new RadioButtonActionListener();
        optionLinux.addActionListener(actionListener);
        optionWin.addActionListener(actionListener);
        optionMac.addActionListener(actionListener);

        buttonOK.addActionListener(new ActionListener() {

            @Override   //po wybraniu i kliknieciu
            public void actionPerformed(ActionEvent event) {
                String selectedOption = "";
                if (optionLinux.isSelected()) {
                    selectedOption = "Kurwa";
                } else if (optionWin.isSelected()) {
                    selectedOption = "CHUJ";
                } else if (optionMac.isSelected()) {
                    selectedOption = "I Pizda";
                }
                JOptionPane.showMessageDialog(SwingJRadioButtonDemo.this,
                        "You selected: " + selectedOption);
            }
        });

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    class RadioButtonActionListener implements ActionListener {
        @Override    //samo wybranie
        public void actionPerformed(ActionEvent event) {
            JRadioButton button = (JRadioButton) event.getSource();
            if (button == optionLinux) {
                System.out.println("Kurwa");

            } else if (button == optionWin) {

                System.out.println("CHUJ");


            } else if (button == optionMac) {
                System.out.println("PIZDA");

            }
        }
    }
            public void run() {
                new SwingJRadioButtonDemo().setVisible(true);
            }


}