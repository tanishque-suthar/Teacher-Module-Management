package View.Modules;

import View.Modules.addModulesPanel;
import View.Modules.tableModulesPanel;

import javax.swing.*;
import java.awt.*;

public class initialModulesPanel extends JPanel {
    private tableModulesPanel module_table;
    private addModulesPanel add_module;
    private editModulesPanel edit_module;
    private deleteModulesPanel delete_module;
    JPanel crud_Panel;
    public initialModulesPanel() {
        super();
        crud_Panel = new JPanel();
        setLayout(new GridLayout(2,1));
        module_table = new tableModulesPanel();
        add(module_table);
        add_module = new addModulesPanel();
        crud_Panel.add(add_module);
        edit_module = new editModulesPanel();
        crud_Panel.add(edit_module);
        delete_module = new deleteModulesPanel();
        crud_Panel.add(delete_module);
        add(crud_Panel);
    }

    public void setAdd_module(addModulesPanel add_module) {
        this.add_module = add_module;
    }

    public void setModule_table(tableModulesPanel module_table) {
        this.module_table = module_table;
    }

    public void setEdit_module(editModulesPanel edit_module) {
        this.edit_module = edit_module;
    }

    public void setDelete_module(deleteModulesPanel delete_module) {
        this.delete_module = delete_module;
    }

    public addModulesPanel getAdd_module() {
        return add_module;
    }

    public tableModulesPanel getModule_table() {
        return module_table;
    }

    public editModulesPanel getEdit_module() {
        return edit_module;
    }

    public deleteModulesPanel getDelete_module() {
        return delete_module;
    }
}
