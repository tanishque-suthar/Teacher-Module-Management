package Model.Enrolls;
import Model.Teachers.*;
import Model.Modules.*;

public class Enrolls {
    int e_count = 0;
    teacher teacher_temp;
    module module_temp;
    String enroll_date;
    int teacher_sal;

    public Enrolls(int e_id,teacher s, module c, String enroll_date, int salary)
    {
        setE_count(e_id);
        setTeacher_temp(s);
        setModule_temp(c);
        setEnroll_date(enroll_date);
        setTeacher_sal(salary);
    }

    public void setTeacher_temp(teacher teacher_temp) {
        this.teacher_temp = teacher_temp;
    }

    public void setModule_temp(module module_temp) {
        this.module_temp = module_temp;
    }

    public void setEnroll_date(String enroll_date) {
        this.enroll_date = enroll_date;
    }

    public void setTeacher_sal(int teacher_sal) {
        this.teacher_sal = teacher_sal;
    }

    public teacher getTeacher_temp() {
        return teacher_temp;
    }

    public module getModule_temp() {
        return module_temp;
    }

    public String getEnroll_date() {
        return enroll_date;
    }

    public int getTeacher_sal() {
        return teacher_sal;
    }

    public void setE_count(int e_count) {
        this.e_count = e_count;
    }

    public int getE_count() {
        return e_count;
    }
}
