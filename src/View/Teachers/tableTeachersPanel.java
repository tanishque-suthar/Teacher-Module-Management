package View.Teachers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class tableTeachersPanel extends JPanel{
    ArrayList<JButton> teacher_buttons = new ArrayList<>();
    public tableTeachersPanel()
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
            teacher_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no, String button_text) {
        teacher_buttons.get(button_no).setText(button_text);
    }
    public ArrayList<JButton> getAllButtons()
    {
        return teacher_buttons;
    }
}
