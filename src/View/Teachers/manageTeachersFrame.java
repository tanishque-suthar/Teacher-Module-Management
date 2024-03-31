package View.Teachers;

import javax.swing.*;

public class manageTeachersFrame extends JFrame {
    initialTeachersPanel t_iPanel;

    public manageTeachersFrame()
    {
        super("Manage Teachers DashBoard");
        t_iPanel = new initialTeachersPanel();
        add(t_iPanel);
        pack();
        setSize(500, 600);
    }

    public void setT_iPanel(initialTeachersPanel t_iPanel) {
        this.t_iPanel = t_iPanel;
    }

    public initialTeachersPanel getT_iPanel() {
        return t_iPanel;
    }
}
