package View.Modules;

import javax.swing.*;
import java.awt.*;

public class addModulesPanel extends JPanel {
    JTextField txt_module_id;
    JTextField txt_module_name;
    JTextField txt_module_credits;
    JTextField txt_module_tb;
    JTextField txt_subject_id;
    JTextField txt_subject_name;
    JTextField txt_subject_credits;
    JButton addModuleBtn;
    public addModulesPanel()
    {
        txt_module_id = new JTextField();
        txt_module_name = new JTextField();
        txt_module_credits = new JTextField();
        txt_module_tb = new JTextField();
        txt_subject_id = new JTextField();
        txt_subject_name = new JTextField();
        txt_subject_credits = new JTextField();
        addModuleBtn = new JButton("Add module");
        addModuleBtn.setBackground(Color.decode("#2ae866"));

        txt_module_id.setText("module_id");
        txt_module_name.setText("module_name");
        txt_module_credits.setText("module_credits");
        txt_module_tb.setText("module_tb");
        txt_subject_id.setText("subject_id");
        txt_subject_name.setText("subject_name");
        txt_subject_credits.setText("subject_credits");

        this.setLayout(new GridLayout(8,1,5,5));

        add(txt_subject_id);
        add(txt_subject_name);
        add(txt_subject_credits);
        add(txt_module_id);
        add(txt_module_name);
        add(txt_module_credits);
        add(txt_module_tb);
        add(addModuleBtn);
    }

    public void setAddModuleBtn(JButton addModuleBtn) {
        this.addModuleBtn = addModuleBtn;
    }

    public void setTxt_module_credits(JTextField txt_module_credits) {
        this.txt_module_credits = txt_module_credits;
    }

    public void setTxt_module_id(JTextField txt_module_id) {
        this.txt_module_id = txt_module_id;
    }

    public void setTxt_module_name(JTextField txt_module_name) {
        this.txt_module_name = txt_module_name;
    }

    public void setTxt_module_tb(JTextField txt_module_tb) {
        this.txt_module_tb = txt_module_tb;
    }

    public void setTxt_subject_id(JTextField txt_subject_id) {
        this.txt_subject_id = txt_subject_id;
    }

    public void setTxt_subject_name(JTextField txt_subject_name) {
        this.txt_subject_name = txt_subject_name;
    }

    public void setTxt_subject_credits(JTextField txt_subject_credits) {
        this.txt_subject_credits = txt_subject_credits;
    }

    public JButton getAddModuleBtn() {
        return addModuleBtn;
    }

    public JTextField getTxt_module_credits() {
        return txt_module_credits;
    }

    public JTextField getTxt_module_id() {
        return txt_module_id;
    }

    public JTextField getTxt_module_name() {
        return txt_module_name;
    }

    public JTextField getTxt_module_tb() {
        return txt_module_tb;
    }

    public JTextField getTxt_subject_id() {
        return txt_subject_id;
    }

    public JTextField getTxt_subject_name() {
        return txt_subject_name;
    }

    public JTextField getTxt_subject_credits() {
        return txt_subject_credits;
    }
}
