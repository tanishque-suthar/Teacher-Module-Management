package View.Enrolls;

import View.Enrolls.tableEnrollsPanel;

import javax.swing.*;
import java.awt.*;

public class initialEnrollsPanel extends JPanel {
    private tableEnrollsPanel enroll_table;
    private addEnrollsPanel add_enroll;
    private editEnrollsPanel edit_enroll;
    private deleteEnrollsPanel delete_enroll;
    JPanel crudPanel;
    public initialEnrollsPanel() {
        super();
        //setLayout(new GridLayout(2,1,5,5));
        crudPanel = new JPanel();
        enroll_table = new tableEnrollsPanel();
        add(enroll_table);
        add_enroll = new addEnrollsPanel();
        crudPanel.add(add_enroll);
        edit_enroll = new editEnrollsPanel();
        crudPanel.add(edit_enroll);
        delete_enroll = new deleteEnrollsPanel();
        crudPanel.add(delete_enroll);
        add(crudPanel);
    }
    public void setEnroll_table(tableEnrollsPanel enroll_table) {
        this.enroll_table = enroll_table;
    }

    public void setDelete_enroll(deleteEnrollsPanel delete_enroll) {
        this.delete_enroll = delete_enroll;
    }

    public void setAdd_enroll(addEnrollsPanel add_enroll) {
        this.add_enroll = add_enroll;
    }

    public void setEdit_enroll(editEnrollsPanel edit_enroll) {
        this.edit_enroll = edit_enroll;
    }

    public deleteEnrollsPanel getDelete_enroll() {
        return delete_enroll;
    }

    public editEnrollsPanel getEdit_enroll() {
        return edit_enroll;
    }

    public addEnrollsPanel getAdd_enroll() {
        return add_enroll;
    }

    public tableEnrollsPanel getEnroll_table() {
        return enroll_table;
    }
}
