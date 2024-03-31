package View.Modules;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class tableModulesPanel extends JPanel {
    ArrayList<JButton> module_buttons = new ArrayList<>();
    public tableModulesPanel()
    {
        super();
    }
    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setFocusable(false);
            b.setBackground(Color.decode("#e3dada"));
            b.setSize(500,50);
            module_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no, String button_text) {
        module_buttons.get(button_no).setText(button_text);
    }
    public ArrayList<JButton> getAllButtons()
    {
        return module_buttons;
    }
}
