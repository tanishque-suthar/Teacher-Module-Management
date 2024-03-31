package View.Modules;

import javax.swing.*;
import java.awt.*;

public class editModulesPanel extends JPanel {
    JTextField txt_module_id;
    JTextField module_index;
    JTextField txt_module_name;
    JTextField txt_module_credits;
    JTextField txt_module_tb;
    JTextField txt_subject_id;
    JTextField txt_subject_name;
    JTextField txt_subject_credits;
    JButton editModuleBtn;
    JButton getModulesBtn;
    JPanel getDetailsPanel;
    JPanel editDetailsPanel;
    public editModulesPanel()
    {
        editDetailsPanel = new JPanel();
        getDetailsPanel = new JPanel();
        module_index = new JTextField();
        txt_module_id = new JTextField();
        txt_module_name = new JTextField();
        txt_module_credits = new JTextField();
        txt_module_tb = new JTextField();
        txt_subject_id = new JTextField();
        txt_subject_name = new JTextField();
        txt_subject_credits = new JTextField();
        editModuleBtn = new JButton("Edit module");
        editModuleBtn.setBackground(Color.decode("#2ae866"));
        getModulesBtn = new JButton("Get Details");
        getModulesBtn.setBackground(Color.decode("#0fa8d6"));

        module_index.setText("Enter module ID");
        txt_module_id.setText("module_id");
        txt_module_name.setText("module_name");
        txt_module_credits.setText("module_credits");
        txt_module_tb.setText("module_tb");
        txt_subject_id.setText("subject_id");
        txt_subject_name.setText("subject_name");
        txt_subject_credits.setText("subject_credits");

        //this.setLayout(new GridLayout(2,1));
        this.setLayout(new BorderLayout(5,5));

        getDetailsPanel.add(module_index);
        getDetailsPanel.add(getModulesBtn);
        add(getDetailsPanel,BorderLayout.NORTH);
        editDetailsPanel.setLayout(new GridLayout(8,1,5,5));
        editDetailsPanel.add(txt_module_id);
        editDetailsPanel.add(txt_subject_id);
        editDetailsPanel.add(txt_subject_name);
        editDetailsPanel.add(txt_subject_credits);
        editDetailsPanel.add(txt_module_name);
        editDetailsPanel.add(txt_module_credits);
        editDetailsPanel.add(txt_module_tb);
        editDetailsPanel.add(editModuleBtn);
        add(editDetailsPanel,BorderLayout.CENTER);
    }

    public void setTxt_module_id(JTextField txt_module_id) {
        this.txt_module_id = txt_module_id;
    }

    public void setTxt_subject_name(JTextField txt_subject_name) {
        this.txt_subject_name = txt_subject_name;
    }

    public void setTxt_subject_credits(JTextField txt_subject_credits) {
        this.txt_subject_credits = txt_subject_credits;
    }

    public void setTxt_subject_id(JTextField txt_subject_id) {
        this.txt_subject_id = txt_subject_id;
    }

    public void setTxt_module_tb(JTextField txt_module_tb) {
        this.txt_module_tb = txt_module_tb;
    }

    public void setTxt_module_name(JTextField txt_module_name) {
        this.txt_module_name = txt_module_name;
    }

    public void setTxt_module_credits(JTextField txt_module_credits) {
        this.txt_module_credits = txt_module_credits;
    }

    public void setEditModuleBtn(JButton editModuleBtn) {
        this.editModuleBtn = editModuleBtn;
    }

    public void setGetModulesBtn(JButton getModulesBtn) {
        this.getModulesBtn = getModulesBtn;
    }

    public void setModule_index(JTextField module_index) {
        this.module_index = module_index;
    }

    public JTextField getTxt_module_id() {
        return txt_module_id;
    }

    public JTextField getTxt_subject_credits() {
        return txt_subject_credits;
    }

    public JTextField getTxt_subject_name() {
        return txt_subject_name;
    }

    public JTextField getTxt_subject_id() {
        return txt_subject_id;
    }

    public JTextField getTxt_module_tb() {
        return txt_module_tb;
    }

    public JTextField getTxt_module_name() {
        return txt_module_name;
    }

    public JTextField getTxt_module_credits() {
        return txt_module_credits;
    }

    public JButton getEditModuleBtn() {
        return editModuleBtn;
    }

    public JButton getGetModulesBtn() {
        return getModulesBtn;
    }

    public JTextField getModule_index() {
        return module_index;
    }
}
