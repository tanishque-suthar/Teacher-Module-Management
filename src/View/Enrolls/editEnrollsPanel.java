package View.Enrolls;

import javax.swing.*;
import java.awt.*;

public class editEnrollsPanel extends JPanel {
    JTextField txt_enroll_id;
    JTextField txt_enroll_index;
    JTextField txt_teacher_id;
    JTextField txt_module_id;
    JTextField enroll_date;
    JTextField teacher_sal;
    JButton editEnrollBtn;
    JButton getEnrollBtn;
    JPanel getDetailsPanel;

    public editEnrollsPanel(){
        getDetailsPanel = new JPanel();
        txt_enroll_id = new JTextField();
        txt_enroll_index = new JTextField();
        txt_teacher_id = new JTextField();
        txt_module_id = new JTextField();
        enroll_date = new JTextField();
        teacher_sal = new JTextField();
        editEnrollBtn = new JButton("Edit");
        editEnrollBtn.setBackground(Color.decode("#2ae866"));
        getEnrollBtn = new JButton("Get Details");
        getEnrollBtn.setBackground(Color.decode("#0fa8d6"));

        txt_enroll_index.setText("Serial No. to edit");
        txt_teacher_id.setText("teacher_id");
        txt_module_id.setText("module_id");
        enroll_date.setText("enrollment_date");
        teacher_sal.setText("teacher_salary");

        setLayout(new GridLayout(6,1,3,3));
        getDetailsPanel.add(txt_enroll_index);
        getDetailsPanel.add(getEnrollBtn);
        add(getDetailsPanel);
        add(txt_teacher_id);
        add(txt_module_id);
        add(enroll_date);
        add(teacher_sal);
        add(editEnrollBtn);
    }

    public void setTxt_enroll_id(JTextField txt_enroll_id) {
        this.txt_enroll_id = txt_enroll_id;
    }

    public JTextField getTxt_enroll_id() {
        return txt_enroll_id;
    }

    public void setTxt_module_id(JTextField txt_module_id) {
        this.txt_module_id = txt_module_id;
    }

    public void setTxt_teacher_id(JTextField txt_teacher_id) {
        this.txt_teacher_id = txt_teacher_id;
    }

    public void setTeacher_sal(JTextField teacher_sal) {
        this.teacher_sal = teacher_sal;
    }

    public void setEnroll_date(JTextField enroll_date) {
        this.enroll_date = enroll_date;
    }

    public void setEditEnrollBtn(JButton editEnrollBtn) {
        this.editEnrollBtn = editEnrollBtn;
    }

    public void setGetEnrollBtn(JButton getEnrollBtn) {
        this.getEnrollBtn = getEnrollBtn;
    }

    public void setTxt_enroll_index(JTextField txt_enroll_index) {
        this.txt_enroll_index = txt_enroll_index;
    }

    public JTextField getTxt_module_id() {
        return txt_module_id;
    }

    public JTextField getTxt_teacher_id() {
        return txt_teacher_id;
    }

    public JTextField getTeacher_sal() {
        return teacher_sal;
    }

    public JTextField getEnroll_date() {
        return enroll_date;
    }

    public JButton getGetEnrollBtn() {
        return getEnrollBtn;
    }

    public JButton getEditEnrollBtn() {
        return editEnrollBtn;
    }

    public JTextField getTxt_enroll_index() {
        return txt_enroll_index;
    }
}
