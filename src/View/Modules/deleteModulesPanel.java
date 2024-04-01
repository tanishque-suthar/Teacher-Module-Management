package View.Modules;

import javax.swing.*;
import java.awt.*;

public class deleteModulesPanel extends JPanel {
    JTextField txt_del_module;
    JButton deleteModuleBtn;
    public deleteModulesPanel(){
        txt_del_module = new JTextField();
        deleteModuleBtn = new JButton("Delete Module");
        deleteModuleBtn.setBackground(Color.decode("#ed5f4c"));

        txt_del_module.setText("Enter_Module_Index_to_delete");

        this.setLayout(new GridLayout(2,1,5,5));
        add(txt_del_module);
        add(deleteModuleBtn);
    }

    public void setDeleteModuleBtn(JButton deleteModuleBtn) {
        this.deleteModuleBtn = deleteModuleBtn;
    }

    public void setTxt_del_module(JTextField txt_del_module) {
        this.txt_del_module = txt_del_module;
    }

    public JButton getDeleteModuleBtn() {
        return deleteModuleBtn;
    }

    public JTextField getTxt_del_module() {
        return txt_del_module;
    }
}
