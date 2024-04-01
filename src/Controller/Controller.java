package Controller;

import Model.Model;
import Model.Modules.maxCreditsException;
import Model.Teachers.mobileNumberException;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        //-=-=-=-=-=-=-=-=-=-= TEACHER UI =-=-=-=-=-=-=-=-=-=-
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        //make Mtf (Teacher UI) visible and ff (Dashboard) not visible when button is clicked
        view.getFf().getMt1Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Teacher Button Clicked");
                view.getFf().getFrame().setVisible(false);
                view.getMtf().setVisible(true);
            }
        });

        //make dashboard(ff) visible again after Teacher UI(Mtf) is closed
        view.getMtf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().getFrame().setVisible(true);
            }
        });

        //create "LinesBeingDisplayed * Headers().size()" buttons to setup initial empty table
        model.getMt1().setLinesBeingDisplayed(24);
        view.tableInitialSetupTeacher(model.getMt1().getLinesBeingDisplayed(),model.getMt1().getHeaders().size());
        //display contents of json file in the table
        model.getMt1().setFirstLineToDisplay(0);
        view.tableUpdateTeacher(model.getMt1().getLines(model.getMt1().getFirstLineToDisplay(),model.getMt1().getLastLineToDisplay()),model.getMt1().getHeaders());

        //scroll functionality
        view.getMtf().getT_iPanel().getTeacher_table().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMt1().getFirstLineToDisplay();
                int current_last_line = model.getMt1().getLastLineToDisplay();
                int no_of_teachers = model.getMt1().getTable().size();
                int no_of_display_lines = model.getMt1().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMt1().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMt1().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMt1().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_teachers -1)
                {
                    model.getMt1().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_teachers -1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_teachers - no_of_display_lines)
                    {
                        new_first_line = no_of_teachers -no_of_display_lines;
                        model.getMt1().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMt1().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.tableUpdateTeacher(model.getMt1().getLines(model.getMt1().getFirstLineToDisplay(), model.getMt1().getLastLineToDisplay()), model.getMt1().getHeaders());
            }
        });

        //Add a teacher to json file
        view.getMtf().getT_iPanel().getAdd_teacher().getAddTeacherBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_name = view.getMtf().getT_iPanel().getAdd_teacher().getTxt_teacher_name().getText();
                String txt_id = view.getMtf().getT_iPanel().getAdd_teacher().getTxt_teacher_id().getText();
                String txt_qual = view.getMtf().getT_iPanel().getAdd_teacher().getTxt_teacher_qual().getText();
                String txt_exp = view.getMtf().getT_iPanel().getAdd_teacher().getTxt_teacher_exp().getText();
                String txt_mobno = view.getMtf().getT_iPanel().getAdd_teacher().getTxt_teacher_mob_no().getText();
                try {
                    String[] split = txt_name.split(" ");
                    if(txt_mobno.length() != 10){
                        throw new mobileNumberException("Phone number should be of 10 digits!!");
                    }
                    else{
                        model.getMt1().addNewTeacher(Integer.parseInt(txt_id), split[0], split[1], txt_qual, Integer.parseInt(txt_exp), txt_mobno);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                catch (mobileNumberException em){
                    JOptionPane.showMessageDialog(null,em.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Get data of json file at specified index
        view.getMtf().getT_iPanel().getEdit_teacher().getGetTeacherBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Get Teacher Details Clicked");
                String txt_teacher_idx = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_index().getText();
                model.getMt1().readTeacherJsonFile("src/Model/Teachers/teachers.json");
                int t_id = model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx)-1).getTeacher_id();
                int t_exp = model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx)-1).getTeacher_exp();
                String t_name = model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx)-1).getTeacher_fname() + " " + model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx) -1 ).getTeacher_lname();
                String t_qual = model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx)-1).getTeacher_qualification();
                String t_mobno = model.getMt1().getTable().get(Integer.parseInt(txt_teacher_idx)-1).getTeacher_phone_number();

                view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_id().setText(String.valueOf(t_id));
                view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_exp().setText(String.valueOf(t_exp));
                view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_mob_no().setText(t_mobno);
                view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_name().setText(t_name);
                view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_qual().setText(t_qual);
            }
        });

        //Edit already existing data in teacher.json file
        view.getMtf().getT_iPanel().getEdit_teacher().getEditTeacherBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_index = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_index().getText();
                String txt_name = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_name().getText();
                String txt_id = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_id().getText();
                String txt_qual = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_qual().getText();
                String txt_exp = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_exp().getText();
                String txt_mobno = view.getMtf().getT_iPanel().getEdit_teacher().getTxt_teacher_mob_no().getText();
                try {
                    String[] split = txt_name.split(" ");
                    model.getMt1().editNewTeacher(Integer.parseInt(txt_index)-1, Integer.parseInt(txt_id), split[0], split[1], txt_qual, Integer.parseInt(txt_exp), txt_mobno);
                    //model.getMt1().setFirstLineToDisplay(0);
                    view.tableUpdateTeacher(model.getMt1().getLines(model.getMt1().getFirstLineToDisplay(),model.getMt1().getLastLineToDisplay()),model.getMt1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Delete data in json file and reflect in the table
        view.getMtf().getT_iPanel().getDelete_teacher().getDeleteTeacherBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Teacher Button Clicked");
                String txt_teacher_idx = view.getMtf().getT_iPanel().getDelete_teacher().getTxt_del_teacher().getText();
                try {
                    int id = model.getMt1().deleteTeacher(Integer.parseInt(txt_teacher_idx)-1);
                    model.getMe1().deleteEnrollConditional(id);
                    view.tableUpdateTeacher(model.getMt1().getLines(model.getMt1().getFirstLineToDisplay(),model.getMt1().getLastLineToDisplay()),model.getMt1().getHeaders());
                    view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(),model.getMe1().getLastLineToDisplay()),model.getMe1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        //-=-=-=-=-=-=-=-=-= MODULE UI =-=-=-=-=-=-=-=-=-=-
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        //make dashboard(ff) visible again after Module UI(mmf) is closed
        view.getMmf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().getFrame().setVisible(true);
            }
        });
        //make mmf (Module UI) visible and ff (Dashboard) not visible when button is clicked
        view.getFf().getMm1Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().getFrame().setVisible(false);
                view.getMmf().setVisible(true);
            }
        });

        //create "LinesBeingDisplayed * Headers().size()" buttons to setup initial empty table
        model.getMm1().setLinesBeingDisplayed(15);
        view.tableInitialSetupModule(model.getMm1().getLinesBeingDisplayed(),model.getMm1().getHeaders().size());
        //display contents of json file in the table
        model.getMm1().setFirstLineToDisplay(0);
        view.tableUpdateModule(model.getMm1().getLines(model.getMm1().getFirstLineToDisplay(),model.getMm1().getLastLineToDisplay()),model.getMm1().getHeaders());

        //scroll functionality
        view.getMmf().getM_iPanel().getModule_table().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMm1().getFirstLineToDisplay();
                int current_last_line = model.getMm1().getLastLineToDisplay();
                int no_of_modules = model.getMm1().getTable().size();
                int no_of_display_lines = model.getMm1().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMm1().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMm1().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMm1().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_modules -1)
                {
                    model.getMm1().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_modules -1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_modules - no_of_display_lines)
                    {
                        new_first_line = no_of_modules -no_of_display_lines;
                        model.getMm1().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMm1().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.tableUpdateModule(model.getMm1().getLines(model.getMm1().getFirstLineToDisplay(), model.getMm1().getLastLineToDisplay()), model.getMm1().getHeaders());
            }
        });

        //Add new module to module.json UI
        view.getMmf().getM_iPanel().getAdd_module().getAddModuleBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mod_name = view.getMmf().getM_iPanel().getAdd_module().getTxt_module_name().getText();
                String sub_name = view.getMmf().getM_iPanel().getAdd_module().getTxt_subject_name().getText();
                String mod_id = view.getMmf().getM_iPanel().getAdd_module().getTxt_module_id().getText();
                String sub_id = view.getMmf().getM_iPanel().getAdd_module().getTxt_subject_id().getText();
                String mod_tb = view.getMmf().getM_iPanel().getAdd_module().getTxt_module_tb().getText();
                String mod_cred = view.getMmf().getM_iPanel().getAdd_module().getTxt_module_credits().getText();
                String sub_cred = view.getMmf().getM_iPanel().getAdd_module().getTxt_subject_credits().getText();

                try {
                    if ((Integer.parseInt(mod_cred)<=0) || (Integer.parseInt(mod_cred) > Integer.parseInt(sub_cred))) {
                        throw new maxCreditsException("Module Credits should be more than 0 and less or equal to subject credits!!");
                    }
                    if((Integer.parseInt(sub_cred)<=0) || (Integer.parseInt(sub_cred) >10)){
                        throw new maxCreditsException("Subject credits should lie between 0 and 10 !!");
                    }
                    else {
                        model.getMm1().addNewModule(Integer.parseInt(mod_id), Integer.parseInt(sub_id), sub_name, Integer.parseInt(sub_cred), mod_name, Integer.parseInt(mod_cred), mod_tb);
                    }
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                catch (maxCreditsException ec){
                    JOptionPane.showMessageDialog(null,ec.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Get data of json file at specified index UI
        view.getMmf().getM_iPanel().getEdit_module().getGetModulesBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_module_idx = view.getMmf().getM_iPanel().getEdit_module().getModule_index().getText();
                model.getMm1().readModuleJsonFile("src/Model/Modules/modules.json");
                int m_id = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getModule_id();
                int s_id = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getSubject_id();
                String m_name = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getModule_name();
                String s_name = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getSubject_name();
                String tb_name = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getModule_tb();
                int m_cred = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getModule_credits();
                int s_cred = model.getMm1().getTable().get(Integer.parseInt(txt_module_idx)-1).getSubject_credits();

                view.getMmf().getM_iPanel().getEdit_module().getTxt_module_id().setText(String.valueOf(m_id));
                view.getMmf().getM_iPanel().getEdit_module().getTxt_module_name().setText(m_name);
                view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_name().setText(s_name);
                view.getMmf().getM_iPanel().getEdit_module().getTxt_module_tb().setText(tb_name);
                view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_id().setText(String.valueOf(s_id));
                view.getMmf().getM_iPanel().getEdit_module().getTxt_module_credits().setText(String.valueOf(m_cred));
                view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_credits().setText(String.valueOf(s_cred));
            }
        });

        //Edit already existing data in json file UI
        view.getMmf().getM_iPanel().getEdit_module().getEditModuleBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_index = view.getMmf().getM_iPanel().getEdit_module().getModule_index().getText();
                String mod_name = view.getMmf().getM_iPanel().getEdit_module().getTxt_module_name().getText();
                String sub_name = view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_name().getText();
                String mod_id = view.getMmf().getM_iPanel().getEdit_module().getTxt_module_id().getText();
                String sub_id = view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_id().getText();
                String mod_tb = view.getMmf().getM_iPanel().getEdit_module().getTxt_module_tb().getText();
                String mod_cred = view.getMmf().getM_iPanel().getEdit_module().getTxt_module_credits().getText();
                String sub_cred = view.getMmf().getM_iPanel().getEdit_module().getTxt_subject_credits().getText();
                try {
                    model.getMm1().editModule(Integer.parseInt(txt_index)-1, Integer.parseInt(mod_id), Integer.parseInt(sub_id), sub_name, Integer.parseInt(sub_cred), mod_name, Integer.parseInt(mod_cred), mod_tb);
                    //model.getMm1().setFirstLineToDisplay(0);
                    view.tableUpdateModule(model.getMm1().getLines(model.getMm1().getFirstLineToDisplay(),model.getMm1().getLastLineToDisplay()),model.getMm1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Delete data in modules.json file UI
        view.getMmf().getM_iPanel().getDelete_module().getDeleteModuleBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_module_idx = view.getMmf().getM_iPanel().getDelete_module().getTxt_del_module().getText();
                try {
                    int id = model.getMm1().deleteModule(Integer.parseInt(txt_module_idx)-1);
                    model.getMe1().deleteEnrollConditional(id);
                    view.tableUpdateModule(model.getMm1().getLines(model.getMm1().getFirstLineToDisplay(),model.getMm1().getLastLineToDisplay()),model.getMm1().getHeaders());
                    view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(),model.getMe1().getLastLineToDisplay()),model.getMe1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        //-=-=-=-=-=-=-=-= ENROLLMENT UI =-=-=-=-=-=-=-=-
        //-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        //make dashboard(ff) visible again after Enrollment UI(mef) is closed
        view.getMef().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().getFrame().setVisible(true);
            }
        });
        //make mef (Enrollment UI) visible and ff (Dashboard) not visible when button is clicked
        view.getFf().getMe1Button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().getFrame().setVisible(false);
                view.getMef().setVisible(true);
            }
        });

        //create "LinesBeingDisplayed * Headers().size()" buttons to setup initial empty table
        model.getMe1().setLinesBeingDisplayed(18);
        view.tableInitialSetupEnroll(model.getMe1().getLinesBeingDisplayed(),model.getMe1().getHeaders().size());
        //display contents of json file in the table
        model.getMe1().setFirstLineToDisplay(0);
        view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(),model.getMe1().getLastLineToDisplay()),model.getMe1().getHeaders());

        //scroll functionality
        view.getMef().getE_iPanel().getEnroll_table().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMe1().getFirstLineToDisplay();
                int current_last_line = model.getMe1().getLastLineToDisplay();
                int no_of_enrolls = model.getMe1().getTable().size();
                int no_of_display_lines = model.getMe1().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMe1().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMe1().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMe1().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_enrolls -1)
                {
                    model.getMe1().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_enrolls -1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_enrolls - no_of_display_lines)
                    {
                        new_first_line = no_of_enrolls -no_of_display_lines;
                        model.getMe1().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMe1().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(), model.getMe1().getLastLineToDisplay()), model.getMe1().getHeaders());
            }
        });

        //Add an enrollment to Enrolls.json
        view.getMef().getE_iPanel().getAdd_enroll().getAddEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int e_id = Integer.parseInt(view.getMef().getE_iPanel().getAdd_enroll().getTxt_enroll_id().getText());
                String e_date = view.getMef().getE_iPanel().getAdd_enroll().getEnroll_date().getText();
                int t_sal = Integer.parseInt(view.getMef().getE_iPanel().getAdd_enroll().getTeacher_sal().getText());
                int t_id = Integer.parseInt(view.getMef().getE_iPanel().getAdd_enroll().getTxt_teacher_id().getText());
                int m_id = Integer.parseInt(view.getMef().getE_iPanel().getAdd_enroll().getTxt_module_id().getText());

                try {
                    model.getMe1().addNewEnroll(t_id ,m_id,t_sal,e_date);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Get data of Enrolls.json file at specified index
        view.getMef().getE_iPanel().getEdit_enroll().getGetEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String e_index = view.getMef().getE_iPanel().getEdit_enroll().getTxt_enroll_index().getText();
                model.getMe1().readEnrollsJsonFile("src\\Model\\Enrolls\\Enrolls.json");
                //int e_id = model.getMe1().getTable().get(Integer.parseInt(e_index)-1).getSerialNo();
                String e_date = model.getMe1().getTable().get(Integer.parseInt(e_index)-1).getEnroll_date();
                int t_sal = model.getMe1().getTable().get(Integer.parseInt(e_index)-1).getTeacher_sal();
                int t_id = model.getMe1().getTable().get(Integer.parseInt(e_index)-1).getTeacher_temp().getTeacher_id();
                int m_id = model.getMe1().getTable().get(Integer.parseInt(e_index)-1).getModule_temp().getModule_id();

                //view.getMef().getE_iPanel().getEdit_enroll().getTxt_enroll_id().setText(String.valueOf(e_id));
                view.getMef().getE_iPanel().getEdit_enroll().getTeacher_sal().setText(String.valueOf(t_sal));
                view.getMef().getE_iPanel().getEdit_enroll().getTxt_module_id().setText(String.valueOf(m_id));
                view.getMef().getE_iPanel().getEdit_enroll().getTxt_teacher_id().setText(String.valueOf(t_id));
                view.getMef().getE_iPanel().getEdit_enroll().getEnroll_date().setText(String.valueOf(e_date));
            }
        });

        //Edit already existing data in Enrolls.json file
        view.getMef().getE_iPanel().getEdit_enroll().getEditEnrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int txt_index = Integer.parseInt(view.getMef().getE_iPanel().getEdit_enroll().getTxt_enroll_index().getText());
                    //int e_id = Integer.parseInt(view.getMef().getE_iPanel().getEdit_enroll().getTxt_enroll_id().getText());
                    int t_id = Integer.parseInt(view.getMef().getE_iPanel().getEdit_enroll().getTxt_teacher_id().getText());
                    int m_id = Integer.parseInt(view.getMef().getE_iPanel().getEdit_enroll().getTxt_module_id().getText());
                    String date = view.getMef().getE_iPanel().getEdit_enroll().getEnroll_date().getText();
                    int t_sal = Integer.parseInt(view.getMef().getE_iPanel().getEdit_enroll().getTeacher_sal().getText());

                    model.getMe1().editEnroll(txt_index-1, t_id, m_id, t_sal, date);
                    //model.getMe1().setFirstLineToDisplay(0);
                    view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(),model.getMe1().getLastLineToDisplay()),model.getMe1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Delete data in Enrolls.json file
        view.getMef().getE_iPanel().getDelete_enroll().getDelete_enrollBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String txt_enroll_idx = view.getMef().getE_iPanel().getDelete_enroll().getTxt_delete_enroll().getText();
                    model.getMe1().deleteEnroll(Integer.parseInt(txt_enroll_idx)-1);
                    view.tableUpdateEnroll(model.getMe1().getLines(model.getMe1().getFirstLineToDisplay(),model.getMe1().getLastLineToDisplay()),model.getMe1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
