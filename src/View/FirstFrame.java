package View;
import javax.swing.*;
import java.awt.*;

public class FirstFrame {
    JFrame frame = new JFrame();
    JButton mt1Button;
    JButton mm1Button;
    JButton me1Button;
    JPanel firstPanel;
    JPanel welcome_panel;
    JLabel welcome_label;
    JLabel redundantOK;
    JLabel redundantOK2;
    JLabel redundantOK3;
    JLabel redundantOK4;
    JLabel redundantOK5;
    JLabel redundantOK6;
    JPanel redundantBottomPanel;

    FirstFrame(){
        frame.setTitle("Dashboard");
        welcome_panel = new JPanel();
        welcome_label = new JLabel("WELCOME");
        welcome_panel.setBackground(Color.decode("#5c7875"));
        welcome_label.setFont(new Font("Montserrat",Font.BOLD,50));
        welcome_panel.add(welcome_label, BorderLayout.CENTER);

        mt1Button = buttonStyle("Teachers");
        mm1Button = buttonStyle("Modules");
        me1Button = buttonStyle("Enrollments");

        redundantOK = new JLabel();redundantOK2 = new JLabel();redundantOK3 = new JLabel();redundantOK4 = new JLabel();redundantOK5 = new JLabel();redundantOK6 = new JLabel();redundantBottomPanel = new JPanel();
        redundantBottomPanel.setBackground(Color.decode("#5c7875"));

        firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(3,3,10,10));
        firstPanel.add(redundantOK);
        firstPanel.add(mt1Button);
        firstPanel.add(redundantOK2);
        firstPanel.add(redundantOK3);
        firstPanel.add(mm1Button);
        firstPanel.add(redundantOK4);
        firstPanel.add(redundantOK5);
        firstPanel.add(me1Button);
        firstPanel.add(redundantOK6);
        firstPanel.setBackground(Color.decode("#5c7875"));

        frame.setLayout(new GridLayout(3,1));
        frame.add(welcome_panel);
        frame.add(firstPanel);
        frame.add(redundantBottomPanel);
        frame.pack();
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.decode("#77b5af"));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public JButton buttonStyle(String title){
        JButton b = new JButton(title);
        b.setPreferredSize(new Dimension(50,50));
        b.setFont(new Font("Montserrat", Font.BOLD,20));
        b.setBackground(Color.GRAY);
        b.setFocusable(false);
        b.setForeground(Color.white);
        return b;
    }
    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }
    public void setMe1Button(JButton me1Button) {
        this.me1Button = me1Button;
    }
    public void setMm1Button(JButton mm1Button) {
        this.mm1Button = mm1Button;
    }
    public void setMt1Button(JButton mt1Button) {
        this.mt1Button = mt1Button;
    }
    public JPanel getFirstPanel() {
        return firstPanel;
    }
    public JButton getMe1Button() {
        return me1Button;
    }
    public JButton getMm1Button() {
        return mm1Button;
    }
    public JButton getMt1Button() {
        return mt1Button;
    }
    public JFrame getFrame() {
        return frame;
    }
}
