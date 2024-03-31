package View.Enrolls;

import javax.swing.*;
import java.awt.*;

public class deleteEnrollsPanel extends JPanel {
    JTextField txt_delete_enroll;
    JButton delete_enrollBtn;
    deleteEnrollsPanel(){
        txt_delete_enroll = new JTextField();
        delete_enrollBtn = new JButton("Delete");
        delete_enrollBtn.setBackground(Color.decode("#ed5f4c"));
        txt_delete_enroll.setText("Enroll ID to delete");

        setLayout(new GridLayout(2,1,5,5));
        add(txt_delete_enroll);
        add(delete_enrollBtn);
    }

    public void setDelete_enrollBtn(JButton delete_enrollBtn) {
        this.delete_enrollBtn = delete_enrollBtn;
    }

    public void setTxt_delete_enroll(JTextField txt_delete_enroll) {
        this.txt_delete_enroll = txt_delete_enroll;
    }

    public JButton getDelete_enrollBtn() {
        return delete_enrollBtn;
    }

    public JTextField getTxt_delete_enroll() {
        return txt_delete_enroll;
    }
}
