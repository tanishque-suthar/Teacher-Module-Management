package View.Enrolls;

import javax.swing.*;
import java.awt.*;

public class addEnrollsPanel extends JPanel {
    JTextField txt_teacher_id;
    JTextField txt_module_id;
    JTextField enroll_date;
    JTextField teacher_sal;
    JButton addEnrollBtn;
    public addEnrollsPanel()
    {
        txt_teacher_id = new JTextField();
        txt_module_id = new JTextField();
        enroll_date = new JTextField();
        teacher_sal = new JTextField();
        addEnrollBtn = new JButton("Add Enrollment");
        addEnrollBtn.setBackground(Color.decode("#2ae866"));
        txt_teacher_id.setText("teacher_id");
        txt_module_id.setText("module_id");
        enroll_date.setText("enrollment_date");
        teacher_sal.setText("teacher_salary");

        setLayout(new GridLayout(5,1,5,5));
        add(txt_teacher_id);
        add(txt_module_id);
        add(enroll_date);
        add(teacher_sal);
        add(addEnrollBtn);
    }

    public void setTxt_module_id(JTextField txt_module_id) {
        this.txt_module_id = txt_module_id;
    }

    public void setTxt_teacher_id(JTextField txt_teacher_id) {
        this.txt_teacher_id = txt_teacher_id;
    }

    public void setAddEnrollBtn(JButton addEnrollBtn) {
        this.addEnrollBtn = addEnrollBtn;
    }

    public void setEnroll_date(JTextField enroll_date) {
        this.enroll_date = enroll_date;
    }

    public void setTeacher_sal(JTextField teacher_sal) {
        this.teacher_sal = teacher_sal;
    }

    public JTextField getTxt_module_id() {
        return txt_module_id;
    }

    public JTextField getTxt_teacher_id() {
        return txt_teacher_id;
    }

    public JButton getAddEnrollBtn() {
        return addEnrollBtn;
    }

    public JTextField getEnroll_date() {
        return enroll_date;
    }

    public JTextField getTeacher_sal() {
        return teacher_sal;
    }
}
