package View.Teachers;

import javax.swing.*;
import java.awt.*;

public class addTeachersPanel extends JPanel {
    JTextField txt_teacher_id;
    JTextField txt_teacher_name;
    JTextField txt_teacher_qual;
    JTextField txt_teacher_mob_no;
    JTextField txt_teacher_exp;
    JButton addTeacherBtn;
    public addTeachersPanel()
    {

        txt_teacher_id = new JTextField();
        txt_teacher_name = new JTextField();
        txt_teacher_qual = new JTextField();
        txt_teacher_mob_no = new JTextField();
        txt_teacher_exp = new JTextField();
        addTeacherBtn = new JButton("Add teacher");
        addTeacherBtn.setBackground(Color.decode("#2ae866"));

        txt_teacher_id.setText("teacher id");
        txt_teacher_name.setText("teacher name");
        txt_teacher_qual.setText("teacher qualification");
        txt_teacher_mob_no.setText("mobile number");
        txt_teacher_exp.setText("teaching experience in years ");

        this.setLayout(new GridLayout(6,1,5,5));
        add(txt_teacher_id);
        add(txt_teacher_name);
        add(txt_teacher_qual);
        add(txt_teacher_exp);
        add(txt_teacher_mob_no);
        add(addTeacherBtn);
    }

    public void setTxt_teacher_exp(JTextField txt_teacher_exp) {
        this.txt_teacher_exp = txt_teacher_exp;
    }

    public void setTxt_teacher_id(JTextField txt_teacher_id) {
        this.txt_teacher_id = txt_teacher_id;
    }

    public void setTxt_teacher_mob_no(JTextField txt_teacher_mob_no) {
        this.txt_teacher_mob_no = txt_teacher_mob_no;
    }

    public void setTxt_teacher_name(JTextField txt_teacher_name) {
        this.txt_teacher_name = txt_teacher_name;
    }

    public void setTxt_teacher_qual(JTextField txt_teacher_qual) {
        this.txt_teacher_qual = txt_teacher_qual;
    }

    public void setAddTeacherBtn(JButton addTeacherBtn) {
        this.addTeacherBtn = addTeacherBtn;
    }

    public JTextField getTxt_teacher_exp() {
        return txt_teacher_exp;
    }

    public JTextField getTxt_teacher_id() {
        return txt_teacher_id;
    }

    public JTextField getTxt_teacher_mob_no() {
        return txt_teacher_mob_no;
    }

    public JTextField getTxt_teacher_name() {
        return txt_teacher_name;
    }

    public JTextField getTxt_teacher_qual() {
        return txt_teacher_qual;
    }

    public JButton getAddTeacherBtn() {
        return addTeacherBtn;
    }
}
