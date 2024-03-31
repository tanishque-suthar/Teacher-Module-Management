package View.Teachers;

import javax.swing.*;

public class initialTeachersPanel extends JPanel {
    private tableTeachersPanel teacher_table;
    private addTeachersPanel add_teacher;
    private editTeachersPanel edit_teacher;
    private deleteTeachersPanel delete_teacher;
    public initialTeachersPanel() {
        super();
        teacher_table = new tableTeachersPanel();
        add(teacher_table);
        add_teacher = new addTeachersPanel();
        add(add_teacher);
        edit_teacher = new editTeachersPanel();
        add(edit_teacher);
        delete_teacher = new deleteTeachersPanel();
        add(delete_teacher);
    }

    public void setEdit_teacher(editTeachersPanel edit_teacher) {
        this.edit_teacher = edit_teacher;
    }

    public void setDelete_teacher(deleteTeachersPanel delete_teacher) {
        this.delete_teacher = delete_teacher;
    }

    public void setAdd_teacher(addTeachersPanel add_teacher) {
        this.add_teacher = add_teacher;
    }
    public void setTeacher_table(tableTeachersPanel teacher_table) {
        this.teacher_table = teacher_table;
    }
    public addTeachersPanel getAdd_teacher() {
        return add_teacher;
    }
    public tableTeachersPanel getTeacher_table() {
        return teacher_table;
    }
    public editTeachersPanel getEdit_teacher() {
        return edit_teacher;
    }
    public deleteTeachersPanel getDelete_teacher() {
        return delete_teacher;
    }
}
