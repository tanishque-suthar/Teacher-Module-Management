package View.Teachers;

import javax.swing.*;
import java.awt.*;

public class editTeachersPanel extends JPanel {
    JTextField txt_teacher_index;
    JTextField txt_teacher_id;
    JTextField txt_teacher_name;
    JTextField txt_teacher_qual;
    JTextField txt_teacher_mob_no;
    JTextField txt_teacher_exp;
    JButton getTeacherBtn;
    JButton editTeacherBtn;

    editTeachersPanel(){
        txt_teacher_index = new JTextField();
        txt_teacher_id = new JTextField();
        txt_teacher_name = new JTextField();
        txt_teacher_qual = new JTextField();
        txt_teacher_mob_no = new JTextField();
        txt_teacher_exp = new JTextField();

        getTeacherBtn = new JButton("Get Details");
        getTeacherBtn.setBackground(Color.decode("#0fa8d6"));
        editTeacherBtn = new JButton("Edit");
        editTeacherBtn.setBackground(Color.decode("#2ae866"));

        txt_teacher_index.setText("Teacher_Index");
        txt_teacher_id.setText("teacher_id");
        txt_teacher_name.setText("teacher_name");
        txt_teacher_qual.setText("teacher_qual");
        txt_teacher_mob_no.setText("teacher_mob_no");
        txt_teacher_exp.setText("teacher_exp");

        this.setLayout(new GridLayout(8,1,5,5));
        add(txt_teacher_index);
        add(getTeacherBtn);
        add(txt_teacher_id);
        add(txt_teacher_name);
        add(txt_teacher_qual);
        add(txt_teacher_exp);
        add(txt_teacher_mob_no);
        add(editTeacherBtn);
    }

    public void setTxt_teacher_id(JTextField txt_teacher_id) {
        this.txt_teacher_id = txt_teacher_id;
    }

    public void setTxt_teacher_qual(JTextField txt_teacher_qual) {
        this.txt_teacher_qual = txt_teacher_qual;
    }

    public void setTxt_teacher_name(JTextField txt_teacher_name) {
        this.txt_teacher_name = txt_teacher_name;
    }

    public void setTxt_teacher_mob_no(JTextField txt_teacher_mob_no) {
        this.txt_teacher_mob_no = txt_teacher_mob_no;
    }

    public void setTxt_teacher_exp(JTextField txt_teacher_exp) {
        this.txt_teacher_exp = txt_teacher_exp;
    }

    public void setEditTeacherBtn(JButton editTeacherBtn) {
        this.editTeacherBtn = editTeacherBtn;
    }

    public void setGetTeacherBtn(JButton getTeacherBtn) {
        this.getTeacherBtn = getTeacherBtn;
    }

    public void setTxt_teacher_index(JTextField txt_teacher_index) {
        this.txt_teacher_index = txt_teacher_index;
    }

    public JTextField getTxt_teacher_id() {
        return txt_teacher_id;
    }

    public JTextField getTxt_teacher_qual() {
        return txt_teacher_qual;
    }

    public JTextField getTxt_teacher_name() {
        return txt_teacher_name;
    }

    public JTextField getTxt_teacher_mob_no() {
        return txt_teacher_mob_no;
    }

    public JTextField getTxt_teacher_exp() {
        return txt_teacher_exp;
    }

    public JButton getEditTeacherBtn() {
        return editTeacherBtn;
    }

    public JButton getGetTeacherBtn() {
        return getTeacherBtn;
    }

    public JTextField getTxt_teacher_index() {
        return txt_teacher_index;
    }
}
