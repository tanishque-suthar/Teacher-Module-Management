package View.Enrolls;

import javax.swing.*;

public class manageEnrollsFrame extends JFrame {
    initialEnrollsPanel e_iPanel;

    public manageEnrollsFrame()
    {
        super("Manage Enrolls DashBoard");
        e_iPanel = new initialEnrollsPanel();
        add(e_iPanel);
        pack();
        setSize(1400, 800);
    }

    public void setE_iPanel(initialEnrollsPanel e_iPanel) {
        this.e_iPanel = e_iPanel;
    }

    public initialEnrollsPanel getE_iPanel() {
        return e_iPanel;
    }
}
