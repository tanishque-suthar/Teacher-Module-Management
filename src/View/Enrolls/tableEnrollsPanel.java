package View.Enrolls;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class tableEnrollsPanel extends JPanel{
    ArrayList<JButton> enroll_buttons = new ArrayList<>();
    public tableEnrollsPanel()
    {
        super();
    }
    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.decode("#e3dada"));
            b.setFocusable(false);
            b.setSize(500,50);
            enroll_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no, String button_text) {
        enroll_buttons.get(button_no).setText(button_text);
    }
    public ArrayList<JButton> getAllButtons()
    {
        return enroll_buttons;
    }
}
