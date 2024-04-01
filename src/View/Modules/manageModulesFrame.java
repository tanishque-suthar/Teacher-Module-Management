package View.Modules;

import javax.swing.*;

public class manageModulesFrame extends JFrame {
    initialModulesPanel m_iPanel;

    public manageModulesFrame()
    {
        super("Manage Modules DashBoard");
        m_iPanel = new initialModulesPanel();
        add(m_iPanel);
        pack();
        setSize(1400, 800);
    }

    public void setM_iPanel(initialModulesPanel m_iPanel) {
        this.m_iPanel = m_iPanel;
    }

    public initialModulesPanel getM_iPanel() {
        return m_iPanel;
    }
}
