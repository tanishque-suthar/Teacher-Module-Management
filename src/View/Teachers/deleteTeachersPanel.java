package View.Teachers;

import javax.swing.*;
import java.awt.*;

public class deleteTeachersPanel extends JPanel {
    JTextField txt_del_teacher;
    JButton deleteTeacherBtn;
    public deleteTeachersPanel(){
        txt_del_teacher = new JTextField();
        deleteTeacherBtn = new JButton("Delete Teacher");
        deleteTeacherBtn.setBackground(Color.decode("#ed5f4c"));
        txt_del_teacher.setText("Enter_Teacher_Index_to_delete");

        this.setLayout(new GridLayout(2,1,5,5));
        add(txt_del_teacher);
        add(deleteTeacherBtn);
    }

    public void setDeleteTeacherBtn(JButton deleteTeacherBtn) {
        this.deleteTeacherBtn = deleteTeacherBtn;
    }

    public void setTxt_del_teacher(JTextField txt_del_teacher) {
        this.txt_del_teacher = txt_del_teacher;
    }

    public JButton getDeleteTeacherBtn() {
        return deleteTeacherBtn;
    }

    public JTextField getTxt_del_teacher() {
        return txt_del_teacher;
    }
}
