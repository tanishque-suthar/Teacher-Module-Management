package View;

import View.Enrolls.manageEnrollsFrame;
import View.Modules.manageModulesFrame;
import View.Teachers.manageTeachersFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    manageModulesFrame mmf;
    manageTeachersFrame mtf;
    manageEnrollsFrame mef;
    public View()
    {
        ff = new FirstFrame();
        mtf = new manageTeachersFrame();
        mmf = new manageModulesFrame();
        mef = new manageEnrollsFrame();
    }

    public void tableInitialSetupTeacher(int linesBeingDisplayed, int size) {
        mtf.getT_iPanel().getTeacher_table().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mtf.getT_iPanel().getTeacher_table().createButtons((linesBeingDisplayed+1) * size);
    }

    public void tableInitialSetupModule(int linesBeingDisplayed, int size) {
        mmf.getM_iPanel().getModule_table().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mmf.getM_iPanel().getModule_table().createButtons((linesBeingDisplayed+1) * size);
    }
    public void tableInitialSetupEnroll(int linesBeingDisplayed, int size) {
        mef.getE_iPanel().getEnroll_table().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mef.getE_iPanel().getEnroll_table().createButtons((linesBeingDisplayed+1) * size);
    }

    public void tableUpdateTeacher(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mtf.getT_iPanel().getTeacher_table().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int teacher_row_no = 0; teacher_row_no < lines.size(); teacher_row_no++)
        {
            for (int teacher_col_no = 0; teacher_col_no < headers.size(); teacher_col_no++)
            {
                int button_no = teacher_row_no * headers.size() + headers.size() + teacher_col_no;
                String button_txt = lines.get(teacher_row_no).get(teacher_col_no);

                mtf.getT_iPanel().getTeacher_table().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }
    public void tableUpdateModule(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mmf.getM_iPanel().getModule_table().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int module_row_no = 0; module_row_no < lines.size(); module_row_no++)
        {
            for (int module_col_no = 0; module_col_no < headers.size(); module_col_no++)
            {
                int button_no = module_row_no * headers.size() + headers.size() + module_col_no;
                String button_txt = lines.get(module_row_no).get(module_col_no);

                mmf.getM_iPanel().getModule_table().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }
    public void tableUpdateEnroll(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mef.getE_iPanel().getEnroll_table().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int enroll_row_no = 0; enroll_row_no < lines.size(); enroll_row_no++)
        {
            for (int enroll_col_no = 0; enroll_col_no < headers.size(); enroll_col_no++)
            {
                int button_no = enroll_row_no * headers.size() + headers.size() + enroll_col_no;
                String button_txt = lines.get(enroll_row_no).get(enroll_col_no);

                mef.getE_iPanel().getEnroll_table().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

    public void setMmf(manageModulesFrame mmf) {
        this.mmf = mmf;
    }
    public void setMtf(manageTeachersFrame mtf) {
        this.mtf = mtf;
    }

    public void setMef(manageEnrollsFrame mef) {
        this.mef = mef;
    }

    public manageModulesFrame getMmf() {
        return mmf;
    }

    public manageTeachersFrame getMtf() {
        return mtf;
    }

    public manageEnrollsFrame getMef() {
        return mef;
    }
}
